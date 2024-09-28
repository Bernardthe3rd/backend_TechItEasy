package nl.novi.techiteasy.controllers;

import jakarta.validation.Valid;
import nl.novi.techiteasy.dtos.CiModuleDto;
import nl.novi.techiteasy.dtos.CiModuleInputDto;
import nl.novi.techiteasy.repositories.CiModuleRepository;
import nl.novi.techiteasy.services.CiModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cimodules")
public class CiModuleController {

    private final CiModuleService ciModuleService;
    private final CiModuleRepository ciModuleRepository;

    public CiModuleController(CiModuleService ciModuleService, CiModuleRepository ciModuleRepository) {
        this.ciModuleService = ciModuleService;
        this.ciModuleRepository = ciModuleRepository;
    }

    @GetMapping
    public ResponseEntity<List<CiModuleDto>> getAllCiModules() {
        List<CiModuleDto> ciModules = ciModuleService.getCiModules();
        return ResponseEntity.ok(ciModules);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CiModuleDto> getCiModuleById(@PathVariable Long id) {
        CiModuleDto oneModule = ciModuleService.getCiModule(id);
        return ResponseEntity.ok(oneModule);
    }

    @PostMapping
    public ResponseEntity<CiModuleDto> addCiModule(@Valid @RequestBody CiModuleInputDto dto) {
        CiModuleDto module = ciModuleService.saveCiModule(dto);
        URI location = URI.create("http://localhost:8080/televisions/" + module.getId());
        return ResponseEntity.created(location).body(module);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CiModuleDto> updateCiModule(@PathVariable Long id, @RequestBody CiModuleInputDto ciModule) {
        CiModuleDto updatedModule = ciModuleService.updateCiModule(id, ciModule);
        return ResponseEntity.ok(updatedModule);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCiModule(@PathVariable Long id) {
        ciModuleService.deleteCiModule(id);
        return ResponseEntity.noContent().build();
    }
}
