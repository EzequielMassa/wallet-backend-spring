package com.emdev.wallet.model;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "_transfer")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transferId;


    private Double amount;
    private String description;

    public Transfer(Double amount, String description) {
        this.amount = amount;
        this.description = description;
    }
}
