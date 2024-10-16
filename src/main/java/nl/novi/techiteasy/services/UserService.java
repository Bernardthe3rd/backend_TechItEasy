package nl.novi.techiteasy.services;

import nl.novi.techiteasy.dtos.UserDto;
import nl.novi.techiteasy.exceptions.UsernameNotFoundException;
import nl.novi.techiteasy.models.User;
import nl.novi.techiteasy.repositories.UserRepository;
import nl.novi.techiteasy.utils.RandomStringGenerator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getUsers() {
        List<UserDto> collection = new ArrayList<>();
        List<User> currentList = userRepository.findAll();
        for (User user : currentList) {
            collection.add(user);
        }
    }

    public UserDto getUserByUsername(String username) {
        UserDto dto = new UserDto();
        Optional<User> getUser = userRepository.findById(username);
        if (getUser.isPresent()) {
            dto = getUser.get();
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
        User newUser = userRepository.save(userDto);
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


}
