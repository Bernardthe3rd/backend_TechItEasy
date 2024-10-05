package nl.novi.techiteasy.mappers;

import nl.novi.techiteasy.dtos.RemoteControllerDto;
import nl.novi.techiteasy.dtos.RemoteControllerInputDto;
import nl.novi.techiteasy.models.RemoteController;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RemoteControllerMapper {

    public static RemoteControllerDto toRemoteControllerDto(RemoteController remoteController) {
        var dto = new RemoteControllerDto();

        dto.setId(remoteController.getId());
        dto.setCompatibleWith(remoteController.getCompatibleWith());
        dto.setBatteryType(remoteController.getBatteryType());
        dto.setName(remoteController.getName());
        dto.setBrand(remoteController.getBrand());
        dto.setPrice(remoteController.getPrice());
        dto.setOriginalStock(remoteController.getOriginalStock());

        return dto;
    }

    public RemoteController toRemoteController(RemoteControllerInputDto dto, RemoteController remoteController) {

        remoteController.setCompatibleWith(dto.getCompatibleWith());
        remoteController.setBatteryType(dto.getBatteryType());
        remoteController.setName(dto.getName());
        remoteController.setBrand(dto.getBrand());
        remoteController.setPrice(dto.getPrice());
        remoteController.setOriginalStock(dto.getOriginalStock());

        return remoteController;
    }

    public RemoteController toRemoteController(RemoteControllerInputDto dto) {
        var controller = new RemoteController();
        return toRemoteController(dto, controller);
    }

    public List<RemoteControllerDto> remoteControllersToRemoteControllerDtos(List<RemoteController> remoteControllers) {
        List<RemoteControllerDto> dtos = new ArrayList<>();
        for (RemoteController remoteController : remoteControllers) {
            RemoteControllerDto dto = toRemoteControllerDto(remoteController);
            dtos.add(dto);
        }
        return dtos;
    }
}
