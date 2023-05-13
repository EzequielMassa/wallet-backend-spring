package com.emdev.wallet.auth;

import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.emdev.wallet.config.JwtService;
import com.emdev.wallet.model.Account;
import com.emdev.wallet.user.Role;
import com.emdev.wallet.user.User;
import com.emdev.wallet.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        private final AuthenticationManager authenticationManager;

        public AuthenticationResponse register(RegisterRequest request) {
                var accounts = new ArrayList<Account>();
                accounts.add(new Account());
                var user = User.builder()
                                .firstName(request.getFirstname())
                                .lastName(request.getLastname())
                                .email(request.getEmail())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .role(Role.USER)
                                .accounts(accounts)
                                .urlImg(request.getUrlImg())
                                .build();
                userRepository.save(user);
                var jwtToken = jwtService.generateToken(user);
                return AuthenticationResponse.builder()
                                .id(user.getId())
                                .firstname(user.getFirstName())
                                .lastname(user.getLastName())
                                .email(user.getUsername())
                                .token(jwtToken)
                                .urlImg(user.getUrlImg())
                                .build();
        }

        public AuthenticationResponse authenticate(AuthenticationRequest request) {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                                request.getEmail(),
                                request.getPassword()));
                var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
                var jwtToken = jwtService.generateToken(user);
                return AuthenticationResponse.builder()
                                .id(user.getId())
                                .firstname(user.getFirstName())
                                .lastname(user.getLastName())
                                .email(user.getUsername())
                                .token(jwtToken)
                                .urlImg(user.getUrlImg())
                                .build();
        }
}
