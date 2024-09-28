package nl.novi.techiteasy;

import nl.novi.techiteasy.controllers.TelevisionController;
import nl.novi.techiteasy.models.Television;
import nl.novi.techiteasy.repositories.TelevisionRepository;
import nl.novi.techiteasy.services.TelevisionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TechItEasyApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechItEasyApplication.class, args);
    }
}
