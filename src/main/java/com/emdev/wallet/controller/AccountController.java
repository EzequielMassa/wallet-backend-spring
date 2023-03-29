package com.emdev.wallet.controller;

import com.emdev.wallet.model.Account;
import com.emdev.wallet.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/accounts")
@CrossOrigin(origins = "*")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    //get all user accounts
    @GetMapping("/getAccounts/id/{id}")
    public ResponseEntity<List<Account>> getAllUserAccounts(@PathVariable("id") Integer id) {
        List<Account> userAccounts = accountService.getUserAccounts(id);
        return ResponseEntity.ok(userAccounts);
    }


    //get one user account
    @GetMapping("/getAccount/id/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable("id") Integer id) {
        Account userAccount = accountService.getAccount(id);
        return ResponseEntity.ok(userAccount);
    }

   //create a new account
    @PostMapping("/newAccount/{id}")
    public ResponseEntity<Account> createAccount(@PathVariable("id") Integer id) {
        Account newAccount = accountService.createAccount(id);
        return ResponseEntity.ok(newAccount);
    }


    //delete one account
    @DeleteMapping("/deleteAccount/{id}")
    public void deleteAccount(@PathVariable("id") Integer id){
        accountService.deleteAccount(id);
    }
}
