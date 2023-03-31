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
@Table(name = "_movements")
public class Movements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movementsId;


    private Double amount;
    private String description;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    public Movements(Double amount, String description, TransactionType type) {
        this.amount = amount;
        this.description = description;
        this.type = type;
    }


}
