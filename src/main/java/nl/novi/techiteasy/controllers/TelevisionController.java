package nl.novi.techiteasy.controllers;

import nl.novi.techiteasy.models.Television;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TelevisionController {

    @GetMapping("/televisions")
    public ResponseEntity<String> getAllTelevisions() {
        return ResponseEntity.ok("television");
    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<String> getTelevisionById(@PathVariable String id) {
        return ResponseEntity.ok("television1");
    }

    @PostMapping("/televisions")
    public ResponseEntity<String> addTelevision(@RequestBody Television television) {
        return ResponseEntity.created(null).body("television");
    }

    @PutMapping("/televisions/{id}")
    public ResponseEntity<String> updateTelevision(@PathVariable String id, @RequestBody Television television) {
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable String id) {
        return ResponseEntity.noContent().build();
    }

}
