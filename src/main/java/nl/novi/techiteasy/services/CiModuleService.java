package nl.novi.techiteasy.services;

import nl.novi.techiteasy.dtos.CiModuleDto;
import nl.novi.techiteasy.dtos.CiModuleInputDto;
import nl.novi.techiteasy.exceptions.RecordNotFoundException;
import nl.novi.techiteasy.mappers.CiModuleMapper;
import nl.novi.techiteasy.models.CiModule;
import nl.novi.techiteasy.repositories.CiModuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CiModuleService {

    private final CiModuleRepository ciModuleRepository;
    private final CiModuleMapper ciModuleMapper;

    public CiModuleService(CiModuleRepository ciModuleRepository, CiModuleMapper ciModuleMapper) {
        this.ciModuleRepository = ciModuleRepository;
        this.ciModuleMapper = ciModuleMapper;
    }

    public List<CiModuleDto> getCiModules() {
        return ciModuleMapper.ciModulesToCimoduleDtos(ciModuleRepository.findAll());
    }

    public CiModuleDto getCiModule(Long id) {
        Optional<CiModule> ciModuleOptional = ciModuleRepository.findById(id);
        if (ciModuleOptional.isPresent()) {
            CiModule module = ciModuleOptional.get();
            return ciModuleMapper.toCimoduleDto(module);
        } else {
            throw new RecordNotFoundException("Television with id " + id + " not found");
        }
    }

    public CiModuleDto saveCiModule(CiModuleInputDto ciModule) {
        CiModule ciModule1 = ciModuleMapper.toCimodule(ciModule);
        return ciModuleMapper.toCimoduleDto(ciModuleRepository.save(ciModule1));
    }

    public CiModuleDto updateCiModule(Long id, CiModuleInputDto ciModule) {
        CiModule getCiModule = ciModuleRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Television with id " + id + " not found"));
        CiModule updatedCiModule = ciModuleMapper.toCimodule(ciModule, getCiModule);
//        updatedTelevision.setId(id);
        return ciModuleMapper.toCimoduleDto(ciModuleRepository.save(updatedCiModule));
    }


    public CiModuleDto deleteCiModule(Long id) {
        ciModuleRepository.deleteById(id);
        return null;
    }
}
