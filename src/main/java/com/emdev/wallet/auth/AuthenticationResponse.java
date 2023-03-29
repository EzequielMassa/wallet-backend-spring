package com.emdev.wallet.auth;

import com.emdev.wallet.model.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


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

    private List<Account> accounts;

}
