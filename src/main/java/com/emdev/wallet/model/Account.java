package com.emdev.wallet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


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

    @OneToMany(targetEntity = Deposit.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fkAccountId", referencedColumnName = "accountId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Deposit> deposits = new ArrayList<Deposit>();
    public Account() {
        this.balance = 0.0;
    }

    public Double setBalance(Double value){
       return this.balance += value;
    }


}
