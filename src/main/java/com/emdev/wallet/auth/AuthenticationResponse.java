package com.emdev.wallet.auth;

import java.util.List;

import com.emdev.wallet.model.Account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private Integer id;

    private String firstname;
    private String lastname;

    private String email;

    private String token;

    // TODO: elimate account on login

    private List<Account> accounts;

}
