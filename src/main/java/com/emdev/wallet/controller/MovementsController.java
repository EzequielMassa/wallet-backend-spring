package com.emdev.wallet.controller;

import java.util.List;

import com.emdev.wallet.model.Expenses;
import com.emdev.wallet.model.Incomings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emdev.wallet.model.Movements;
import com.emdev.wallet.service.IMovementsService;

@RestController
@RequestMapping("/api/v1/movements")
public class MovementsController {

    @Autowired
    private IMovementsService movementsService;

    @GetMapping("/id/{id}")
    public ResponseEntity<List<Movements>> getAllAccountMovements(@PathVariable("id") Integer id) {
        List<Movements> accountMovements = movementsService.getAccountMovements(id);
        return ResponseEntity.ok(accountMovements);
    }
    @GetMapping("/incomings/id/{id}")
    public ResponseEntity<List<Incomings>> getAllAccountIncomings(@PathVariable("id") Integer id) {
        List<Incomings> accountIncomings = movementsService.getAccountIncomings(id);
        return ResponseEntity.ok(accountIncomings);
    }

    @GetMapping("/incomings/id/{id}/year/{year}")
    public ResponseEntity<List<Object>> getAllAccountIncomingsByYear(@PathVariable("id") Integer id,@PathVariable("year") Integer year) {
        List<Object> accountIncomings = movementsService.getAccountIncomingsByYear(id,year);
        return ResponseEntity.ok(accountIncomings);
    }

    @GetMapping("/incomings/id/{id}/month/{month}/year/{year}")
    public ResponseEntity<Object> getAAccountIncomingsByMonthAndYear(@PathVariable("id") Integer id,@PathVariable("month") Integer month,@PathVariable("year") Integer year) {
        Object accountIncoming = movementsService.getAccountIncomingsByMonthAndYear(id,month,year);
        return ResponseEntity.ok(accountIncoming);
    }

    @GetMapping("/expenses/id/{id}")
    public ResponseEntity<List<Expenses>> getAllAccountExpenses(@PathVariable("id") Integer id) {
        List<Expenses> accountExpenses = movementsService.getAccountExpenses(id);
        return ResponseEntity.ok(accountExpenses);
    }

    @GetMapping("/expenses/id/{id}/year/{year}")
    public ResponseEntity<List<Object>> getAllAccountExpensesByYear(@PathVariable("id") Integer id,@PathVariable("year") Integer year) {
        List<Object> accountExpenses = movementsService.getAccountExpensesByYear(id,year);
        return ResponseEntity.ok(accountExpenses);
    }

    @GetMapping("/expenses/id/{id}/month/{month}/year/{year}")
    public ResponseEntity<Object> getAAccountExpensesByMonthAndYear(@PathVariable("id") Integer id,@PathVariable("month") Integer month,@PathVariable("year") Integer year) {
        Object accountExpense = movementsService.getAccountExpensesByMonthAndYear(id,month,year);
        return ResponseEntity.ok(accountExpense);
    }

}
