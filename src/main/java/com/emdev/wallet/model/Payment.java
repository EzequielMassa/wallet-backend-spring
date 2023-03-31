package com.emdev.wallet.model;

import com.emdev.wallet.types.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "_payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double amount;
    private String description;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    public Payment(Double amount, String description) {
        this.amount = amount;
        this.description = description;
        this.type = TransactionType.PAYMENT;
    }
}
