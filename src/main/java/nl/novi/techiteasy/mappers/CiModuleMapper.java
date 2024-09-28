package nl.novi.techiteasy.mappers;

import nl.novi.techiteasy.dtos.CiModuleDto;
import nl.novi.techiteasy.dtos.CiModuleInputDto;
import nl.novi.techiteasy.models.CiModule;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CiModuleMapper {

    public CiModuleDto toCimoduleDto(CiModule ciModule) {
        var dto = new CiModuleDto();

        dto.setId(ciModule.getId());
        dto.setName(ciModule.getName());
        dto.setPrice(ciModule.getPrice());
        dto.setType(ciModule.getType());

        return dto;
    }

    public CiModule toCimodule(CiModuleInputDto dto) {
        var ciModule = new CiModule();
        return toCimodule(dto, ciModule);
    }

    public CiModule toCimodule(CiModuleInputDto dto, CiModule ciModule) {

        ciModule.setName(dto.getName());
        ciModule.setPrice(dto.getPrice());
        ciModule.setType(dto.getType());

        return ciModule;
    }

    public List<CiModuleDto> ciModulesToCimoduleDtos(List<CiModule> ciModules) {
        List<CiModuleDto> dtos = new ArrayList<>();
        for (CiModule ciModule : ciModules) {
            CiModuleDto dto = toCimoduleDto(ciModule);
            dtos.add(dto);
        }
        return dtos;
    }
}
