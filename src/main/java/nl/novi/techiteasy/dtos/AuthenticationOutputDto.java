package nl.novi.techiteasy.dtos;

import lombok.Getter;

@Getter
public class AuthenticationOutputDto {

    private final String jwt;

    public AuthenticationOutputDto(String jwt) {
        this.jwt = jwt;
    }
}
