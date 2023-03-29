package com.emdev.wallet.service;

import com.emdev.wallet.model.Account;
import com.emdev.wallet.repository.AccountRepository;
import com.emdev.wallet.user.User;
import com.emdev.wallet.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class IAccountService implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Account> getUserAccounts(Integer userId) {
        return userRepository.findAccountsByUser(userId);
    }

    @Override
    public Account getAccount(Integer accountId) {
        return accountRepository.findByAccountId(accountId).orElse(null);
    }

    @Override
    public Account createAccount(Integer userId) {
        User user = userRepository.findById(userId).orElse(null);

        Account newAccount = new Account();
        user.getAccounts().add(newAccount);
        return accountRepository.save(newAccount);
    }

    @Override
    public void deleteAccount(Integer accountId) {
    accountRepository.deleteById(accountId);
    }

}
