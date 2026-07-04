package com.sri.user_service.service;

import com.sri.user_service.common.exception.DuplicateResourceException;
import com.sri.user_service.common.exception.UnAuthorizedException;
import com.sri.user_service.common.exception.UserNotFoundException;
import com.sri.user_service.dto.AuthResponseDTO;
import com.sri.user_service.dto.LoginRequestDTO;
import com.sri.user_service.dto.RegisterRequestDTO;
import com.sri.user_service.entity.Role;
import com.sri.user_service.entity.UserEntity;
import com.sri.user_service.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
            UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthResponseDTO registerUser(RegisterRequestDTO request) {

        boolean isExists = userRepository.existsByEmail(request.getEmail());

        if(isExists) {
            throw new DuplicateResourceException("User with that email already exists");
        }

        UserEntity user = new UserEntity();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.JOB_SEEKER);

        userRepository.save(user);

        return new AuthResponseDTO("User Registered Successfully", null);
    }

    public AuthResponseDTO loginUser(LoginRequestDTO request) {

        // Checking User Exists
        UserEntity user =
                userRepository.findByEmail(request.getEmail())
                        .orElseThrow(() ->
                                new UserNotFoundException(
                                        "User Not Found"));
        // Comparing password
        boolean isValid = passwordEncoder.matches(request.getPassword(), user.getPassword());

        if(!isValid) {
            throw new UnAuthorizedException("Invalid Credentials");
        }

        // need to pass token in here
        String token = jwtService.generateToken(request.getEmail());

        return new AuthResponseDTO("User LoggedIn Successfully", token);
    }
}
