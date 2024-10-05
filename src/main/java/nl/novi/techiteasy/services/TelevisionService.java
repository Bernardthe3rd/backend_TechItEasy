package nl.novi.techiteasy.services;

import nl.novi.techiteasy.dtos.IdInputDto;
import nl.novi.techiteasy.dtos.TelevisionDto;
import nl.novi.techiteasy.dtos.TelevisionInputDto;
import nl.novi.techiteasy.mappers.TelevisionMapper;
import nl.novi.techiteasy.exceptions.RecordNotFoundException;
import nl.novi.techiteasy.models.CiModule;
import nl.novi.techiteasy.models.RemoteController;
import nl.novi.techiteasy.models.Television;
import nl.novi.techiteasy.models.WallBracket;
import nl.novi.techiteasy.repositories.CiModuleRepository;
import nl.novi.techiteasy.repositories.RemoteControllerRepository;
import nl.novi.techiteasy.repositories.TelevisionRepository;
import nl.novi.techiteasy.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;
    private final TelevisionMapper televisionMapper;
    private final RemoteControllerRepository remoteControllerRepository;
    private final CiModuleRepository ciModuleRepository;
    private final WallBracketRepository wallBracketRepository;

    public TelevisionService(TelevisionRepository televisionRepository, TelevisionMapper televisionMapper, RemoteControllerRepository remoteControllerRepository, CiModuleRepository ciModuleRepository, WallBracketRepository wallBracketRepository) {
        this.televisionRepository = televisionRepository;
        this.televisionMapper = televisionMapper;
        this.remoteControllerRepository = remoteControllerRepository;
        this.ciModuleRepository = ciModuleRepository;
        this.wallBracketRepository = wallBracketRepository;
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
        Long getRemoteControllerId = remoteControllerId.getId();
        Optional<RemoteController> remoteControllerOptional = remoteControllerRepository.findById(getRemoteControllerId);
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

    public TelevisionDto assignCiModuleToTelevision(long id, IdInputDto ciModuleId) {
        Long getCiModuleId = ciModuleId.getId();
        Optional<CiModule> ciModuleOptional = ciModuleRepository.findById(getCiModuleId);
        Optional<Television> televisionOptional = televisionRepository.findById(id);
        if (ciModuleOptional.isPresent() && televisionOptional.isPresent()) {
            CiModule ciModule = ciModuleOptional.get();
            Television television = televisionOptional.get();
            television.setCiModule(ciModule);
            return televisionMapper.toTelevisionDto(televisionRepository.save(television));
        } else {
            throw new RecordNotFoundException("Ci module with id " + ciModuleId + " not found");
        }
    }

    public TelevisionDto assignWallBracketToTelevision(long id, IdInputDto wallBracketId) {
        Long getWallBracketId = wallBracketId.getId();
        Optional<WallBracket> wallBracketOptional = wallBracketRepository.findById(getWallBracketId);
        Optional<Television> televisionOptional = televisionRepository.findById(id);
        if (wallBracketOptional.isPresent() && televisionOptional.isPresent()) {
            WallBracket wallBracket = wallBracketOptional.get();
            Television television = televisionOptional.get();
            List<WallBracket> currentWallBrackets = television.getWallBracket();
            currentWallBrackets.add(wallBracket);
            television.setWallBracket(currentWallBrackets);
            return televisionMapper.toTelevisionDto(televisionRepository.save(television));
        } else {
            throw new RecordNotFoundException("Wall bracket with id " + wallBracketId + " not found");
        }
    }
}
