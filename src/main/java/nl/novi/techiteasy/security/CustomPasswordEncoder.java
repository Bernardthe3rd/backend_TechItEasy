package nl.novi.techiteasy.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class CustomPasswordEncoder {

    @Bean
    public PasswordEncoder passwordEncoder() {
        System.out.println("Password encoder wordt aangeroepen");
        return new BCryptPasswordEncoder();
    }
}
