package com.example.Dinothing.config;

import com.example.Dinothing.repository.IdeaRepository;
import com.example.Dinothing.repository.UserRepository;
import com.example.Dinothing.service.IdeaService;
import com.example.Dinothing.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@Configuration
public class AppConfig {

    private final UserRepository userRepository;
    private final IdeaRepository ideaRepository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public UserService userService() {
        return new UserService(userRepository, passwordEncoder);
    }

    @Bean
    public IdeaService ideaService(){
        return new IdeaService(ideaRepository, userRepository);
    }
}
