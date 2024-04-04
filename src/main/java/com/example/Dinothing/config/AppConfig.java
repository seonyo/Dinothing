package com.example.Dinothing.config;

import com.example.Dinothing.repository.HeartRepository;
import com.example.Dinothing.repository.IdeaRepository;
import com.example.Dinothing.repository.MemoRepository;
import com.example.Dinothing.repository.UserRepository;
import com.example.Dinothing.service.HeartService;
import com.example.Dinothing.service.IdeaService;
import com.example.Dinothing.service.MemoService;
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
    private final MemoRepository memoRepository;
    private final HeartRepository heartRepository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public UserService userService() {
        return new UserService(userRepository, passwordEncoder);
    }

    @Bean
    public IdeaService ideaService(){
        return new IdeaService(ideaRepository, userRepository);
    }

    @Bean
    public MemoService memoService(){return new MemoService(memoRepository);}

    @Bean
    public HeartService heartService(){
        return new HeartService(heartRepository);
    }
}
