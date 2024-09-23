package nl.novi.techiteasy.controllers;

import nl.novi.techiteasy.models.Television;
import nl.novi.techiteasy.services.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    @GetMapping
    public ResponseEntity<String> getAllTelevisions() {
        return ResponseEntity.ok("television");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getTelevisionById(@PathVariable String id) {
        return ResponseEntity.ok("television1");
    }

    @PostMapping
    public ResponseEntity<String> addTelevision(@RequestBody Television television) {
        return ResponseEntity.created(null).body("television");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTelevision(@PathVariable String id, @RequestBody Television television) {
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable String id) {
        return ResponseEntity.noContent().build();
    }

}
