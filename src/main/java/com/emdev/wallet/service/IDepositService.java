package com.emdev.wallet.service;

import com.emdev.wallet.model.Account;
import com.emdev.wallet.model.Deposit;
import com.emdev.wallet.repository.AccountRepository;
import com.emdev.wallet.repository.DepositRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class IDepositService implements DepositService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private DepositRepository depositRepository;

    @Override
    public List<Deposit> getAccountDeposits(Integer accountId) {
        return accountRepository.findDepositsByAccount(accountId);
    }

    @Override
    public Deposit getDeposit(Integer depositId) {
        return depositRepository.findById(depositId).orElse(null);
    }

    @Override
    public Deposit createDeposit(Integer accountId, Deposit deposit) {
        Account account = accountRepository.findByAccountId(accountId).orElse(null);
        Deposit newDeposit = new Deposit(deposit.getAmount(), deposit.getDescription());


        account.setBalance(newDeposit.getAmount());
        account.getDeposits().add(newDeposit);


        return depositRepository.save(newDeposit);

    }

}
