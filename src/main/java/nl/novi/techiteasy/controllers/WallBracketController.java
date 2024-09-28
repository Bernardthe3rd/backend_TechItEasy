package nl.novi.techiteasy.controllers;

import jakarta.validation.Valid;
import nl.novi.techiteasy.dtos.WallBracketDto;
import nl.novi.techiteasy.dtos.WallBracketInputDto;
import nl.novi.techiteasy.repositories.WallBracketRepository;
import nl.novi.techiteasy.services.WallBracketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/wallbrackets")
public class WallBracketController {

    private final WallBracketService wallBracketService;
    private final WallBracketRepository wallBracketRepository;

    public WallBracketController(WallBracketService wallBracketService, WallBracketRepository wallBracketRepository) {
        this.wallBracketService = wallBracketService;
        this.wallBracketRepository = wallBracketRepository;
    }

    @GetMapping
    public ResponseEntity<List<WallBracketDto>> getAllWallBrackets() {
        List<WallBracketDto> WallBrackets = wallBracketService.getWallBrackets();
        return ResponseEntity.ok(WallBrackets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WallBracketDto> getWallBracketById(@PathVariable Long id) {
        WallBracketDto oneBracket = wallBracketService.getWallBracket(id);
        return ResponseEntity.ok(oneBracket);
    }

    @PostMapping
    public ResponseEntity<WallBracketDto> addWallBracket(@Valid @RequestBody WallBracketInputDto dto) {
        WallBracketDto bracket = wallBracketService.saveWallBracket(dto);
        URI location = URI.create("http://localhost:8080/televisions/" + bracket.getId());
        return ResponseEntity.created(location).body(bracket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WallBracketDto> updateWallBracket(@PathVariable Long id, @RequestBody WallBracketInputDto wallBracket) {
        WallBracketDto updatedBracket = wallBracketService.updateWallBracket(id, wallBracket);
        return ResponseEntity.ok(updatedBracket);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWallBracket(@PathVariable Long id) {
        wallBracketService.deleteWallBracket(id);
        return ResponseEntity.noContent().build();
    }
}
