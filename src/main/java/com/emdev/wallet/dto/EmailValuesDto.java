package com.emdev.wallet.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailValuesDto {
    @Email(message = "Email format is not valid")
    @Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
    @NotBlank(message = "Email is required")
    private String mailFrom;
    @Email(message = "Email format is not valid")
    @Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
    @NotBlank(message = "Email is required")
    private String mailTo;
    private String subject;
    private String userName;
    private String tokenPassword;
}
