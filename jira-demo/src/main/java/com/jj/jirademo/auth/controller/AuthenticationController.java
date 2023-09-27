package com.jj.jirademo.auth.controller;

import com.jj.jirademo.auth.service.AuthenticationService;
import com.jj.jirademo.user.dto.UserDto;
import com.jj.jirademo.user.dto.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public ResponseEntity<UserDto> auth(@RequestBody UserRequest userRequest){
        return null;
    }
}
