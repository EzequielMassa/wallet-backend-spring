package com.emdev.wallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emdev.wallet.model.Movements;
import com.emdev.wallet.service.IMovementsService;

@RestController
@RequestMapping("/api/v1/movements")
@CrossOrigin(origins = "*")
public class MovementsController {

    @Autowired
    private IMovementsService movementsService;

    @GetMapping("/id/{id}")
    public ResponseEntity<List<Movements>> getAllAccountMovements(@PathVariable("id") Integer id) {
        List<Movements> accountMovements = movementsService.getAccountMovements(id);
        return ResponseEntity.ok(accountMovements);
    }

}
