package com.example.Dinothing.service.User;

import com.example.Dinothing.dto.RegisterDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    boolean registerUser(RegisterDto request);
}
