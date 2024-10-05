package nl.novi.techiteasy.services;

import nl.novi.techiteasy.dtos.WallBracketDto;
import nl.novi.techiteasy.dtos.WallBracketInputDto;
import nl.novi.techiteasy.exceptions.RecordNotFoundException;
import nl.novi.techiteasy.mappers.WallBracketMapper;
import nl.novi.techiteasy.models.WallBracket;
import nl.novi.techiteasy.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WallBracketService {

    private final WallBracketRepository wallBracketRepository;
    private final WallBracketMapper wallBracketMapper;

    public WallBracketService(WallBracketRepository wallBracketRepository, WallBracketMapper wallBracketMapper) {
        this.wallBracketRepository = wallBracketRepository;
        this.wallBracketMapper = wallBracketMapper;
    }

    public List<WallBracketDto> getWallBrackets() {
        return wallBracketMapper.wallBracketsToWallBracketDtos(wallBracketRepository.findAll());
    }

    public WallBracketDto getWallBracket(Long id) {
        Optional<WallBracket> wallBracketOptional = wallBracketRepository.findById(id);
        if (wallBracketOptional.isPresent()) {
            WallBracket bracket = wallBracketOptional.get();
            return wallBracketMapper.toWallBracketDto(bracket);
        } else {
            throw new RecordNotFoundException("Television with id " + id + " not found");
        }
    }

    public WallBracketDto saveWallBracket(WallBracketInputDto wallBracket) {
        WallBracket wallBracket1 = wallBracketMapper.toWallBracket(wallBracket);
        return wallBracketMapper.toWallBracketDto(wallBracketRepository.save(wallBracket1));
    }

    public WallBracketDto updateWallBracket(Long id, WallBracketInputDto wallBracket) {
        WallBracket getWallBracket = wallBracketRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Television with id " + id + " not found"));
        WallBracket updatedWallBracket = wallBracketMapper.toWallBracket(wallBracket, getWallBracket);
//        updatedTelevision.setId(id);
        return wallBracketMapper.toWallBracketDto(wallBracketRepository.save(updatedWallBracket));
    }


    public WallBracketDto deleteWallBracket(Long id) {
        wallBracketRepository.deleteById(id);
        return null;
    }
}
