package com.emdev.wallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emdev.wallet.model.Account;
import com.emdev.wallet.model.Movements;
import com.emdev.wallet.model.Transfer;
import com.emdev.wallet.repository.AccountRepository;
import com.emdev.wallet.repository.TransferRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ITransferService implements TransferService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransferRepository transferRepository;

    @Override
    public List<Transfer> getAccountTransfers(Integer accountId) {
        return accountRepository.findTransfersByAccount(accountId);
    }

    @Override
    public Transfer getTransfer(Integer transferId) {
        return transferRepository.findById(transferId).orElse(null);
    }

    @Override
    public Transfer createTransfer(Integer accountOriginId, Integer accountDestinyId, Transfer transfer)
            throws Exception {
        Account originAccount = accountRepository.findByAccountId(accountOriginId).orElse(null);
        Account destinyAccount = accountRepository.findByAccountId(accountDestinyId).orElse(null);

        if (originAccount.getBalance() < transfer.getAmount()) {
            throw new Exception("saldo insuficiente");
        }
        try {
            Transfer newTransferOrigin = new Transfer(transfer.getAmount(), transfer.getDescription());
            Transfer newTransferDestiny = new Transfer(transfer.getAmount(), transfer.getDescription());
            Movements newMovementsOrigin = new Movements(transfer.getAmount(), transfer.getDescription(),
                    newTransferOrigin.getType());
            Movements newMovementsDestiny = new Movements(transfer.getAmount(), transfer.getDescription(),
                    newTransferDestiny.getType());
            originAccount.setPayment(transfer.getAmount());
            destinyAccount.setBalance(transfer.getAmount());
            originAccount.getTransfers().add(newTransferOrigin);
            originAccount.getMovements().add(newMovementsOrigin);
            destinyAccount.getTransfers().add(newTransferDestiny);
            destinyAccount.getMovements().add(newMovementsDestiny);

            transferRepository.save(newTransferDestiny);

            return transferRepository.save(newTransferOrigin);

        } catch (Exception e) {
            throw e;
        }
    }

}