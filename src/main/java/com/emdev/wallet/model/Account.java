package com.emdev.wallet.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "_account")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    private Double balance;

    public Account() {
        this.balance = 0.0;
    }

}
