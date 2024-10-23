package nl.novi.techiteasy.services;

import nl.novi.techiteasy.dtos.UserDto;
import nl.novi.techiteasy.exceptions.UsernameNotFoundException;
import nl.novi.techiteasy.mappers.UserMapper;
import nl.novi.techiteasy.models.Role;
import nl.novi.techiteasy.models.User;
import nl.novi.techiteasy.repositories.UserRepository;
import nl.novi.techiteasy.utils.RandomStringGenerator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserDto> getUsers() {
        List<UserDto> collection = new ArrayList<>();
        List<User> currentList = userRepository.findAll();
        for (User user : currentList) {
            collection.add(userMapper.fromUserToUserDto(user));
        }
        return collection;
    }

    public UserDto getUserByUsername(String username) {
        UserDto dto = new UserDto();
        Optional<User> getUser = userRepository.findById(username);
        if (getUser.isPresent()) {
            dto = userMapper.fromUserToUserDto(getUser.get());
        } else {
            throw new UsernameNotFoundException(username);
        }
        return dto;
    }

    public boolean userExists(String username) {
        return userRepository.existsById(username);
    }

    public String createUser(UserDto userDto) {
        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
        userDto.setApiKey(randomString);
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User newUser = userRepository.save(userMapper.fromUserDtoToUser(userDto));
        return newUser.getUsername();
    }

    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    public void updateUser(String username, UserDto newUser) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
    }

    public Set<Role> getRoles(String username) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        UserDto userDto = userMapper.fromUserToUserDto(user);
        return userDto.getRoles();
    }

    public void addRole(String username, String role) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        user.addRole(new Role(username, role));
        userRepository.save(user);
    }

    public void removeRole(String username, String role) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        Role roleToRemove = user.getRoles().stream().filter((a) -> a.getRole().equalsIgnoreCase(role)).findAny().get();
        user.removeRole(roleToRemove);
        userRepository.save(user);
    }
}
