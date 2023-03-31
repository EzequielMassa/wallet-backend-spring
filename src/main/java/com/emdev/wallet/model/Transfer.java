package com.emdev.wallet.model;

import com.emdev.wallet.types.TransactionType;
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

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    public Transfer(Double amount, String description) {
        this.amount = amount;
        this.description = description;

        this.type = TransactionType.TRANSFER;
    }
}
