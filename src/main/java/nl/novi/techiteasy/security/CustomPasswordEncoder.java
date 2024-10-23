package nl.novi.techiteasy.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class CustomPasswordEncoder {

    private final Logger logger = LoggerFactory.getLogger(CustomPasswordEncoder.class);

    @Bean
    public PasswordEncoder passwordEncoder() {
        logger.info("Password encoder wordt aangeroepen");
        return new BCryptPasswordEncoder();
    }
}
