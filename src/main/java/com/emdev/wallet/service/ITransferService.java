package com.emdev.wallet.service;

import com.emdev.wallet.model.Account;
import com.emdev.wallet.model.Transfer;
import com.emdev.wallet.repository.AccountRepository;
import com.emdev.wallet.repository.TransferRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class ITransferService implements TransferService{

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
    public Transfer createTransfer(Integer accountOriginId, Integer accountDestinyId, Transfer transfer) throws Exception {
        Account originAccount = accountRepository.findByAccountId(accountOriginId).orElse(null);
        Account destinyAccount = accountRepository.findByAccountId(accountDestinyId).orElse(null);
        if(originAccount.getBalance() < transfer.getAmount()) {
            throw  new Exception("saldo insuficiente");
        }
        try {
            Transfer newTransfer = new Transfer(transfer.getAmount(), transfer.getDescription());
            originAccount.setPayment(transfer.getAmount());
            destinyAccount.setBalance(transfer.getAmount());
            originAccount.getTransfers().add(newTransfer);
            destinyAccount.getTransfers().add(newTransfer);
            return transferRepository.save(newTransfer);

        }catch (Exception e){
            throw e;
        }
    }

}
