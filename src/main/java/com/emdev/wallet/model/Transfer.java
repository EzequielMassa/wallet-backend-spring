package com.emdev.wallet.model;

import com.emdev.wallet.types.TransactionType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


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
    private Date date;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    public Transfer(Double amount, String description , TransactionType type) {
        this.amount = amount;
        this.description = description;
        this.date = new Date(System.currentTimeMillis());
        this.type = type;
    }
}
