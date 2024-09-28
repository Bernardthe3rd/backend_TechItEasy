package nl.novi.techiteasy.services;

import nl.novi.techiteasy.dtos.RemoteControllerDto;
import nl.novi.techiteasy.dtos.RemoteControllerInputDto;
import nl.novi.techiteasy.exceptions.RecordNotFoundException;
import nl.novi.techiteasy.mappers.RemoteControllerMapper;
import nl.novi.techiteasy.models.RemoteController;
import nl.novi.techiteasy.repositories.RemoteControllerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RemoteControllerService {

    private final RemoteControllerRepository remoteControllerRepository;
    private final RemoteControllerMapper remoteControllerMapper;

    public RemoteControllerService(RemoteControllerRepository remoteControllerRepository, RemoteControllerMapper remoteControllerMapper) {
        this.remoteControllerRepository = remoteControllerRepository;
        this.remoteControllerMapper = remoteControllerMapper;
    }

    public List<RemoteControllerDto> getRemoteControllers() {
        return remoteControllerMapper.remoteControllersToRemoteControllerDtos(remoteControllerRepository.findAll());
    }

    public RemoteControllerDto getRemoteController(Long id) {
        Optional<RemoteController> remoteControllerOptional = remoteControllerRepository.findById(id);
        if (remoteControllerOptional.isPresent()) {
            RemoteController remoteController = remoteControllerOptional.get();
            return remoteControllerMapper.toRemoteControllerDto(remoteController);
        } else {
            throw new RecordNotFoundException("Television with id " + id + " not found");
        }
    }

    public RemoteControllerDto saveRemoteController(RemoteControllerInputDto remoteController) {
        RemoteController remoteController1 = remoteControllerMapper.toRemoteController(remoteController);
        return remoteControllerMapper.toRemoteControllerDto(remoteControllerRepository.save(remoteController1));
    }

    public RemoteControllerDto updateRemoteController(Long id, RemoteControllerInputDto remoteController) {
        RemoteController getRemoteController = remoteControllerRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Television with id " + id + " not found"));
        RemoteController updatedRemoteController = remoteControllerMapper.toRemoteController(remoteController, getRemoteController);
//        updatedTelevision.setId(id);
        return remoteControllerMapper.toRemoteControllerDto(remoteControllerRepository.save(updatedRemoteController));
    }


    public RemoteControllerDto deleteRemoteController(Long id) {
        remoteControllerRepository.deleteById(id);
        return null;
    }
}
