package com.jj.jirademo.auth.service;

import com.jj.jirademo.user.dto.UserDto;
import com.jj.jirademo.user.dto.UserRequest;
import com.jj.jirademo.user.dto.UserResponse;
import com.jj.jirademo.user.dto.converter.UserDtoConverter;
import com.jj.jirademo.user.model.User;
import com.jj.jirademo.user.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDtoConverter userDtoConverter;

    public AuthenticationService(UserRepository userRepository, JwtService jwtService, AuthenticationManager authenticationManager, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userDtoConverter = userDtoConverter;
    }

    public UserResponse auth(UserRequest userRequest){
        String deneme = userRequest.getEmail();
        System.out.println(deneme);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getEmail(),userRequest.getPassword()));
        User user =userRepository.findByEmail(userRequest.getEmail()).orElseThrow();
        String token = jwtService.generateToken(user);
        return new UserResponse(token);

    }
}
