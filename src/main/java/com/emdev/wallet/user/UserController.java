package com.emdev.wallet.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.emdev.wallet.auth.AuthenticationResponse;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/get-all")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }


    @PutMapping("/update")
    public ResponseEntity<AuthenticationResponse> updateUser(@RequestBody UserRequest request) {
        return ResponseEntity.ok(service.updateUser(request));
    }
}
