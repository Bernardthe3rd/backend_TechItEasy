package nl.novi.techiteasy.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationInputDto {

    private String username;
    private String password;

    public AuthenticationInputDto() {
    }

    public AuthenticationInputDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
