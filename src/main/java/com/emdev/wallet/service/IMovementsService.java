package com.emdev.wallet.service;


import com.emdev.wallet.model.Movements;
import com.emdev.wallet.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class IMovementsService implements MovementsService{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Movements> getAccountMovements(Integer accountId) {
        return accountRepository.findMovementsByAccountOrderByDateDesc(accountId).orElse(null);
    }

}
