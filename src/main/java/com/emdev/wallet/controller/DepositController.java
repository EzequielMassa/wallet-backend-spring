package com.emdev.wallet.controller;

import com.emdev.wallet.model.Deposit;
import com.emdev.wallet.service.IDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/deposits")
public class DepositController {

    @Autowired
    private IDepositService depositService;


    @GetMapping("/getDeposits/id/{id}")
    public ResponseEntity<List<Deposit>> getAllAccountDeposits(@PathVariable("id") Integer id){
        List<Deposit> accountDeposits = depositService.getAccountDeposits(id);
        return ResponseEntity.ok(accountDeposits);
    }

    @GetMapping("/getDeposit/id/{id}")
    public ResponseEntity<Deposit> getAccountDeposit(@PathVariable("id") Integer id){
        Deposit accountDeposit = depositService.getDeposit(id);
        return ResponseEntity.ok(accountDeposit);
    }

    @PostMapping("/newDeposit/{id}")
    public ResponseEntity<Deposit> createDeposit(@PathVariable("id") Integer id,@RequestBody Deposit deposit){
        Deposit newDeposit = depositService.createDeposit(id,deposit);
        return ResponseEntity.ok(newDeposit);
    }

}
