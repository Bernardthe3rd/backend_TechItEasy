package nl.novi.techiteasy.mappers;

import nl.novi.techiteasy.dtos.WallBracketDto;
import nl.novi.techiteasy.dtos.WallBracketInputDto;
import nl.novi.techiteasy.models.WallBracket;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WallBracketMapper {

    public static WallBracketDto toWallBracketDto(WallBracket wallBracket) {
        var dto = new WallBracketDto();

        dto.setId(wallBracket.getId());
        dto.setName(wallBracket.getName());
        dto.setPrice(wallBracket.getPrice());
        dto.setAdjustable(wallBracket.isAdjustable());
        dto.setSize(wallBracket.getSize());

        return dto;
    }

    public WallBracket toWallBracket(WallBracketInputDto dto) {
        var bracket = new WallBracket();
        return toWallBracket(dto, bracket);
    }

    public WallBracket toWallBracket(WallBracketInputDto dto, WallBracket bracket) {

        bracket.setName(dto.getName());
        bracket.setPrice(dto.getPrice());
        bracket.setAdjustable(dto.isAdjustable());
        bracket.setSize(dto.getSize());

        return bracket;
    }

    public static List<WallBracketDto> wallBracketsToWallBracketDtos(List<WallBracket> wallBrackets) {
        List<WallBracketDto> dtos = new ArrayList<>();
        for (WallBracket wallBracket : wallBrackets) {
            WallBracketDto dto = toWallBracketDto(wallBracket);
            dtos.add(dto);
        }
        return dtos;
    }
}
