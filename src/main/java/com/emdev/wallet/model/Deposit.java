package com.emdev.wallet.model;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "_deposit")
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double amount;
    private String description;

    public Deposit(Double amount, String description) {
        this.amount = amount;
        this.description = description;
    }

}
