package com.emdev.wallet.controller;

import com.emdev.wallet.model.Transfer;
import com.emdev.wallet.service.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/transfers")
public class TransferController {

    @Autowired
    private ITransferService transferService;

    @GetMapping("/getTransfers/id/{id}")
    public ResponseEntity<List<Transfer>> getAllAccountTransfers(@PathVariable("id") Integer id){
        List<Transfer> accountTransfers = transferService.getAccountTransfers(id);
        return ResponseEntity.ok(accountTransfers);
    }

    @GetMapping("/getTransfer/id/{id}")
    public ResponseEntity<Transfer> getAccountTransfer(@PathVariable("id") Integer id){
        Transfer accountTransfer = transferService.getTransfer(id);
        return ResponseEntity.ok(accountTransfer);
    }

    @PostMapping("/newTransfer/origin/{accountOriginId}/destiny/{accountDestinyId}")
    public ResponseEntity<Transfer> createDeposit(@PathVariable("accountOriginId") Integer accountOriginId ,@PathVariable("accountDestinyId") Integer accountDestinyId ,@RequestBody Transfer transfer) throws Exception {
        try{
            Transfer newTransfer = transferService.createTransfer(accountOriginId,accountDestinyId,transfer);
            return new ResponseEntity<>(newTransfer, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(transfer, HttpStatus.BAD_REQUEST);
        }

    }

}
