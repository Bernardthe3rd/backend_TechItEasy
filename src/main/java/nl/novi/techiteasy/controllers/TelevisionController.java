package nl.novi.techiteasy.controllers;

import jakarta.validation.Valid;
import nl.novi.techiteasy.dtos.TelevisionDto;
import nl.novi.techiteasy.dtos.TelevisionInputDto;
import nl.novi.techiteasy.repositories.TelevisionRepository;
import nl.novi.techiteasy.services.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService televisionService;
    private final TelevisionRepository televisionRepository;

    public TelevisionController(TelevisionService televisionService, TelevisionRepository televisionRepository) {
        this.televisionService = televisionService;
        this.televisionRepository = televisionRepository;
    }

    @GetMapping
    public ResponseEntity<List<TelevisionDto>> getAllTelevisions() {
        List<TelevisionDto> televisions = televisionService.getTelevisions();
        return ResponseEntity.ok(televisions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionDto> getTelevisionById(@PathVariable Long id) {
        TelevisionDto oneTelevision = televisionService.getTelevision(id);
        return ResponseEntity.ok(oneTelevision);
    }

    @PostMapping
    public ResponseEntity<TelevisionDto> addTelevision(@Valid @RequestBody TelevisionInputDto dto) {
        TelevisionDto television = televisionService.saveTelevision(dto);
        URI location = URI.create("/televisions");
        return ResponseEntity.created(location).body(television);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelevisionDto> updateTelevision(@PathVariable Long id, @RequestBody TelevisionInputDto television) {
        TelevisionDto updatedTelevision = televisionService.updateTelevision(id, television);
        return ResponseEntity.ok(updatedTelevision);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable Long id) {
        TelevisionDto television = televisionService.deleteTelevision(id);
        return ResponseEntity.ok("Television with " + id + "with name" + television + " has been successfully deleted");
    }

}
