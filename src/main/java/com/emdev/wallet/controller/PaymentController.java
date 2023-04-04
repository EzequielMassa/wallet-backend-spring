package com.emdev.wallet.controller;

import com.emdev.wallet.model.Payment;
import com.emdev.wallet.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @GetMapping("/getPayments/id/{id}")
    public ResponseEntity<List<Payment>> getAllAccountPayments(@PathVariable("id") Integer id){
        List<Payment> accountPayments = paymentService.getAccountPayments(id);
        return ResponseEntity.ok(accountPayments);
    }

    @GetMapping("/getPayment/id/{id}")
    public ResponseEntity<Payment> getAccountPayment(@PathVariable("id") Integer id){
        Payment accountPayment = paymentService.getPayment(id);
        return ResponseEntity.ok(accountPayment);
    }

    @PostMapping("/newPayment/{id}")
    public ResponseEntity<Payment> createDeposit(@PathVariable("id") Integer id, @RequestBody Payment payment) throws Exception {
        try{
            Payment newPayment = paymentService.createPayment(id,payment);
            return new ResponseEntity<>(newPayment, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(payment, HttpStatus.BAD_REQUEST);
        }

    }
}
