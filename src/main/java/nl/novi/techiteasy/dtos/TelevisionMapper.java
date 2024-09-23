package nl.novi.techiteasy.dtos;

import nl.novi.techiteasy.models.Television;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TelevisionMapper {

    public TelevisionDto toTelevisionDto(Television television) {
        var dto = new TelevisionDto();

        dto.setType(television.getType());
        dto.setBrand(television.getBrand());
        dto.setName(television.getName());
        dto.setPrice(television.getPrice());
        dto.setAvailableSize(television.getAvailableSize());
        dto.setRefreshRate(television.getRefreshRate());
        dto.setScreenType(television.getScreenType());
        dto.setScreenQuality(television.getScreenQuality());
        dto.setSmartTv(television.getSmartTv());
        dto.setWifi(television.getWifi());
        dto.setVoiceControl(television.getVoiceControl());
        dto.setHdr(television.getHdr());
        dto.setBluetooth(television.getBluetooth());
        dto.setAmbiLight(television.getAmbiLight());
        dto.setOriginalStock(television.getOriginalStock());
        dto.setSold(television.getSold());
        dto.setLastSold(television.getLastSold());

        return dto;
    }

    public Television toTelevision(TelevisionInputDto dto) {
        var television = new Television();

        television.setType(dto.getType());
        television.setBrand(dto.getBrand());
        television.setName(dto.getName());
        television.setPrice(dto.getPrice());
        television.setAvailableSize(dto.getAvailableSize());
        television.setRefreshRate(dto.getRefreshRate());
        television.setScreenType(dto.getScreenType());
        television.setScreenQuality(dto.getScreenQuality());
        television.setSmartTv(dto.getSmartTv());
        television.setWifi(dto.getWifi());
        television.setVoiceControl(dto.getVoiceControl());
        television.setHdr(dto.getHdr());
        television.setBluetooth(dto.getBluetooth());
        television.setAmbiLight(dto.getAmbiLight());
        television.setOriginalStock(dto.getOriginalStock());
        television.setSold(dto.getSold());
        television.setLastSold(dto.getLastSold());

        return television;
    }

    public List<TelevisionDto> televisionsToTelevisionDtos(List<Television> televisions) {
        List<TelevisionDto> dtos = new ArrayList<>();
        for (Television television : televisions) {
            TelevisionDto dto = toTelevisionDto(television);
            dtos.add(dto);
        }

        return dtos;
    }
}
