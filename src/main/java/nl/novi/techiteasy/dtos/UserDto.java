package nl.novi.techiteasy.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import nl.novi.techiteasy.models.Role;

import java.util.Set;

@Getter
@Setter
public class UserDto {

    public String username;
    public String password;
    public boolean enabled;
    public String apiKey;
    public String email;
    @JsonSerialize
    public Set<Role> roles;
    
}
