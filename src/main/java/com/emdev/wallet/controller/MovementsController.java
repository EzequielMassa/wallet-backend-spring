package com.emdev.wallet.controller;

import com.emdev.wallet.model.Deposit;
import com.emdev.wallet.model.Movements;
import com.emdev.wallet.service.IMovementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/movements")
@CrossOrigin(origins = "*")
public class MovementsController {

    @Autowired
    private IMovementsService movementsService;

    @GetMapping("/id/{id}")
    public ResponseEntity<List<Movements>> getAllAccountMovements(@PathVariable("id") Integer id){
        List<Movements> accountMovements = movementsService.getAccountMovements(id);
        return ResponseEntity.ok(accountMovements);
    }

}
