package com.emdev.wallet.user;

import com.emdev.wallet.auth.AuthenticationRequest;
import com.emdev.wallet.auth.AuthenticationResponse;
import com.emdev.wallet.auth.AuthenticationService;
import com.emdev.wallet.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
