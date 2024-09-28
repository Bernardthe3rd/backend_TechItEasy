package nl.novi.techiteasy.services;

import nl.novi.techiteasy.dtos.IdInputDto;
import nl.novi.techiteasy.dtos.TelevisionDto;
import nl.novi.techiteasy.dtos.TelevisionInputDto;
import nl.novi.techiteasy.mappers.TelevisionMapper;
import nl.novi.techiteasy.exceptions.RecordNotFoundException;
import nl.novi.techiteasy.models.RemoteController;
import nl.novi.techiteasy.models.Television;
import nl.novi.techiteasy.repositories.RemoteControllerRepository;
import nl.novi.techiteasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;
    private final TelevisionMapper televisionMapper;
    private RemoteControllerRepository remoteControllerRepository;

    public TelevisionService(TelevisionRepository televisionRepository, TelevisionMapper televisionMapper, RemoteControllerRepository remoteControllerRepository) {
        this.televisionRepository = televisionRepository;
        this.televisionMapper = televisionMapper;
        this.remoteControllerRepository = remoteControllerRepository;
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
            throw new RecordNotFoundException("Television with id " + id + " not found");
        }
    }

    public TelevisionDto saveTelevision(TelevisionInputDto television) {
        Television television1 = televisionMapper.toTelevision(television);
        return televisionMapper.toTelevisionDto(televisionRepository.save(television1));
    }

    public TelevisionDto updateTelevision(Long id, TelevisionInputDto television) {
        Television getTelevision = televisionRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Television with id " + id + " not found"));
        Television updatedTelevision = televisionMapper.toTelevision(television, getTelevision);
//        updatedTelevision.setId(id);
        return televisionMapper.toTelevisionDto(televisionRepository.save(updatedTelevision));
    }

    public TelevisionDto deleteTelevision(Long id) {
        televisionRepository.deleteById(id);
        return null;
    }

    public TelevisionDto assignRemoteControllerToTelevision(long id, IdInputDto remoteControllerId) {
        Optional<RemoteController> remoteControllerOptional = remoteControllerRepository.findById(remoteControllerId);
        Optional<Television> televisionOptional = televisionRepository.findById(id);
        if (remoteControllerOptional.isPresent() && televisionOptional.isPresent()) {
            RemoteController remoteController = remoteControllerOptional.get();
            Television television = televisionOptional.get();
            television.setRemoteController(remoteController);
            return televisionMapper.toTelevisionDto(televisionRepository.save(television));
        } else {
            throw new RecordNotFoundException("Remote controller with id " + remoteControllerId + " not found");
        }
    }
}
