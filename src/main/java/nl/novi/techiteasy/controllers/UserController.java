package nl.novi.techiteasy.controllers;

import nl.novi.techiteasy.dtos.UserDto;
import nl.novi.techiteasy.exceptions.BadRequestException;
import nl.novi.techiteasy.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> dtos = userService.getUsers();
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<UserDto> getUser(@PathVariable("username") String username) {
        UserDto optionalUser = userService.getUserByUsername(username);
        return ResponseEntity.ok().body(optionalUser);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto dtoUser) {
        String newUsername = userService.createUser(dtoUser);
        userService.addRole(newUsername, "ROLE_USER");
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}").buildAndExpand(newUsername).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{username}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("username") String username, @RequestBody UserDto userDto) {
        userService.updateUser(username, userDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{username}")
    public ResponseEntity<Object> deleteUser(@PathVariable("username") String username) {
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{username}/roles")
    public ResponseEntity<Object> getRoles(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(userService.getRoles(username));
    }

    @PostMapping(value = "/{username}/roles")
    public ResponseEntity<Object> addRole(@PathVariable("username") String username, @RequestParam("role") String roleName) {
        try {
            userService.addRole(username, roleName);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new BadRequestException();
        }
    }

    @DeleteMapping(value = "/{username}/roles/{role}")
    public ResponseEntity<Object> deleteRole(@PathVariable("username") String username, @PathVariable("role") String roleName) {
        userService.removeRole(username, roleName);
        return ResponseEntity.noContent().build();
    }
}
