package com.emdev.wallet.controller;

import com.emdev.wallet.dto.ChangePasswordDto;
import com.emdev.wallet.dto.EmailValuesDto;
import com.emdev.wallet.service.EmailService;
import com.emdev.wallet.user.User;
import com.emdev.wallet.user.UserService;
import com.emdev.wallet.utils.Mensaje;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/auth")
public class EmailController {
    @Autowired
    EmailService emailService;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${spring.mail.username}")
    private String emailFrom;


    private static final String subject = "Cambio de contraseña";
    @PostMapping("/password-forgot")
    public ResponseEntity<?> sendEmailTemplate(@RequestBody EmailValuesDto dto) {
        Optional<User> usuarioOpt = userService.getUserByEmail(dto.getMailTo());
       if (!usuarioOpt.isPresent())
           return new ResponseEntity<>(new Mensaje("No existe el usuario con ese correo"), HttpStatus.NOT_FOUND);
       User usuario = usuarioOpt.get();

        dto.setMailFrom(emailFrom);
        dto.setSubject(subject);
        dto.setMailTo(usuario.getEmail());
        dto.setUserName(usuario.getUsername());
        UUID uuid = UUID.randomUUID();
        String tokenPassword = uuid.toString();
        dto.setTokenPassword(tokenPassword);
        usuario.setTokenPassword(tokenPassword);
        userService.save(usuario);
        emailService.sendEmail(dto);
        return new ResponseEntity<>(new Mensaje("Te hemos enviado un correo"), HttpStatus.OK);
    }

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePasswordDto dto, BindingResult bindingResult) {
         if (bindingResult.hasErrors()){
             return new ResponseEntity<>(new Mensaje("Campos invalidos"), HttpStatus.BAD_REQUEST);
         }
         if (!dto.getPassword().equals(dto.getConfirmPassword())){
             return new ResponseEntity<>(new Mensaje("Las contraseñas no coinciden"), HttpStatus.BAD_REQUEST);
         }
         Optional<User> usuarioOpt = userService.getUserByTokenPassword(dto.getTokenPassword());
        if (!usuarioOpt.isPresent())
            return new ResponseEntity<>(new Mensaje("No existe el usuario"), HttpStatus.NOT_FOUND);
        User usuario = usuarioOpt.get();
        String newPassword = passwordEncoder.encode(dto.getPassword());
        usuario.setPassword(newPassword);
        usuario.setTokenPassword(null);
        userService.save(usuario);
        return new ResponseEntity<>(new Mensaje("Contraseña actualizada con exito"),HttpStatus.OK);
    }
}
