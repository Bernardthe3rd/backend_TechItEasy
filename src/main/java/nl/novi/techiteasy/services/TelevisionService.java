package nl.novi.techiteasy.services;

import nl.novi.techiteasy.dtos.TelevisionDto;
import nl.novi.techiteasy.models.Television;
import nl.novi.techiteasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public List<Television> getTelevisions() {
        return televisionRepository.findAll();
    }

    public Television getTelevision(Long id) {
        return televisionRepository.getReferenceById(id);
    }

    public Television saveTelevision(Television television) {
        return televisionRepository.save(television);
    }

    public Television updateTelevision(Television television) {
        return televisionRepository.save(television);
    }

    public void deleteTelevision(Long id) {
        televisionRepository.deleteById(id);
    }

}
