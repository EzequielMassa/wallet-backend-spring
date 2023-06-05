package com.emdev.wallet.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emdev.wallet.auth.AuthenticationResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PutMapping("/update")
    public ResponseEntity<AuthenticationResponse> updateUser(@RequestBody UserRequest request) {
        return ResponseEntity.ok(service.updateUser(request));
    }
}
