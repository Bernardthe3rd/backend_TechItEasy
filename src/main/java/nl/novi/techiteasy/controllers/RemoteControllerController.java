package nl.novi.techiteasy.controllers;

import jakarta.validation.Valid;
import nl.novi.techiteasy.dtos.RemoteControllerDto;
import nl.novi.techiteasy.dtos.RemoteControllerInputDto;
import nl.novi.techiteasy.repositories.RemoteControllerRepository;
import nl.novi.techiteasy.services.RemoteControllerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/remotecontrollers")
public class RemoteControllerController {

    private final RemoteControllerService remoteControllerService;
    private final RemoteControllerRepository remoteControllerRepository;

    public RemoteControllerController(RemoteControllerService remoteControllerService, RemoteControllerRepository remoteControllerRepository) {
        this.remoteControllerService = remoteControllerService;
        this.remoteControllerRepository = remoteControllerRepository;
    }

    @GetMapping
    public ResponseEntity<List<RemoteControllerDto>> getAllRemoteControllers() {
        List<RemoteControllerDto> remoteControllers = remoteControllerService.getRemoteControllers();
        return ResponseEntity.ok(remoteControllers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemoteControllerDto> getRemoteControllerById(@PathVariable Long id) {
        RemoteControllerDto oneRemoteController = remoteControllerService.getRemoteController(id);
        return ResponseEntity.ok(oneRemoteController);
    }

    @PostMapping
    public ResponseEntity<RemoteControllerDto> addRemoteController(@Valid @RequestBody RemoteControllerInputDto dto) {
        RemoteControllerDto remoteController = remoteControllerService.saveRemoteController(dto);
        URI location = URI.create("http://localhost:8080/televisions/" + remoteController.getId());
        return ResponseEntity.created(location).body(remoteController);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RemoteControllerDto> updateRemoteController(@PathVariable Long id, @RequestBody RemoteControllerInputDto remoteController) {
        RemoteControllerDto updatedRemoteController = remoteControllerService.updateRemoteController(id, remoteController);
        return ResponseEntity.ok(updatedRemoteController);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRemoteController(@PathVariable Long id) {
        remoteControllerService.deleteRemoteController(id);
        return ResponseEntity.noContent().build();
    }
}
