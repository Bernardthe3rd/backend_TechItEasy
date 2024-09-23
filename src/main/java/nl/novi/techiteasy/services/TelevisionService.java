package nl.novi.techiteasy.services;

import nl.novi.techiteasy.dtos.TelevisionDto;
import nl.novi.techiteasy.dtos.TelevisionInputDto;
import nl.novi.techiteasy.dtos.TelevisionMapper;
import nl.novi.techiteasy.models.Television;
import nl.novi.techiteasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;
    private final TelevisionMapper televisionMapper;

    public TelevisionService(TelevisionRepository televisionRepository, TelevisionMapper televisionMapper) {
        this.televisionRepository = televisionRepository;
        this.televisionMapper = televisionMapper;
    }

    public List<TelevisionDto> getTelevisions() {
        return televisionMapper.televisionsToTelevisionDtos(televisionRepository.findAll());
    }

    public TelevisionDto getTelevision(Long id) {
        Optional<Television> televisionOptional = televisionRepository.findById(id);
        if (televisionOptional.isPresent()) {
            Television television = televisionOptional.get();
            return televisionMapper.toTelevisionDto(television);
        } else {
            throw new RuntimeException("Television with id " + id + " not found");
        }
    }

    public TelevisionDto saveTelevision(TelevisionInputDto television) {
        Television television1 = televisionMapper.toTelevision(television);
        return televisionMapper.toTelevisionDto(televisionRepository.save(television1));
    }

    public TelevisionDto updateTelevision(Long id, TelevisionInputDto television) {
        Television getTelevision = televisionRepository.getReferenceById(id);
        Television updatedTelevision = televisionMapper.toTelevision(television);
        return televisionMapper.toTelevisionDto(televisionRepository.save(updatedTelevision));
    }

    public TelevisionDto deleteTelevision(Long id) {
        televisionRepository.deleteById(id);
        return null;
    }

}
