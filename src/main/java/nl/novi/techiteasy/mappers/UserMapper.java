package nl.novi.techiteasy.mappers;

import nl.novi.techiteasy.dtos.UserDto;
import nl.novi.techiteasy.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto fromUserToUserDto(User user) {
        var dto = new UserDto();

        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setEnabled(user.isEnabled());
        dto.setApiKey(user.getApiKey());
        dto.setEmail(user.getEmail());
        dto.setRoles(user.getRoles());

        return dto;
    }

    public User fromUserDtoToUser(UserDto dto) {
        var user = new User();

        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEnabled(dto.isEnabled());
        user.setApiKey(dto.getApiKey());
        user.setEmail(dto.getEmail());

        return user;
    }
}
