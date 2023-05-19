package com.emdev.wallet.user;

import com.emdev.wallet.auth.AuthenticationResponse;
import com.emdev.wallet.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> getUserByTokenPassword(String tokenPassword) {
        return userRepository.findByTokenPassword(tokenPassword);
    }
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public void save(User usuario) {
         userRepository.save(usuario);
    }

    public AuthenticationResponse updateUser(UserRequest request) {
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var pass = request.getPassword();
        User updatedUser;

        if(pass.length() >= 4){
            updatedUser = User.builder()
                    .id(user.getId())
                    .firstName(request.getFirstname())
                    .lastName(request.getLastname())
                    .email(user.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(user.getRole())
                    .accounts(user.getAccounts())
                    .urlImg(request.getUrlImg())
                    .build();
        }else {
             updatedUser = User.builder()
                    .id(user.getId())
                    .firstName(request.getFirstname())
                    .lastName(request.getLastname())
                    .email(user.getEmail())
                     .password(user.getPassword())
                    .role(user.getRole())
                    .accounts(user.getAccounts())
                    .urlImg(request.getUrlImg())
                    .build();
        }


        userRepository.save(updatedUser);
        var jwtToken = jwtService.generateToken(updatedUser);

        return AuthenticationResponse.builder()
                .id(updatedUser.getId())
                .firstname(updatedUser.getFirstName())
                .lastname(updatedUser.getLastName())
                .email(updatedUser.getUsername())
                .token(jwtToken)
                .urlImg(updatedUser.getUrlImg())
                .build();
    }


}
