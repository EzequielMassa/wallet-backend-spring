package com.emdev.wallet.service;


import com.emdev.wallet.model.Expenses;
import com.emdev.wallet.model.Incomings;
import com.emdev.wallet.model.Movements;
import com.emdev.wallet.repository.AccountRepository;
import com.emdev.wallet.repository.ExpensesRepository;
import com.emdev.wallet.repository.IncomingsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class IMovementsService implements MovementsService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private IncomingsRepository incomingsRepository;

    @Autowired
    private ExpensesRepository expensesRepository;

    @Override
    public List<Movements> getAccountMovements(Integer accountId) {
        return accountRepository.findMovementsByAccountOrderByDateDesc(accountId).orElse(null);
    }
    @Override
    public List<Incomings> getAccountIncomings(Integer accountId) {
        return incomingsRepository.findAllIncomingsByAccountId(accountId).orElse(null);
    }

    @Override
    public List<Object> getAccountIncomingsByYear(Integer accountId, Integer year) {
        return incomingsRepository.findAllIncomingsByYear(accountId,year).orElse(null);
    }
    @Override
    public Object getAccountIncomingsByMonthAndYear(Integer accountId,Integer month, Integer year) {
        return incomingsRepository.findIncomingsByMonthAndYear(accountId,month,year).orElse(null);
    }

    @Override
    public List<Expenses> getAccountExpenses(Integer accountId) {
        return expensesRepository.findAllExpensesByAccountId(accountId).orElse(null);
    }

    @Override
    public List<Object> getAccountExpensesByYear(Integer accountId, Integer year) {
        return expensesRepository.findAllExpensesByYear(accountId,year).orElse(null);
    }

    @Override
    public Object getAccountExpensesByMonthAndYear(Integer accountId,Integer month, Integer year) {
        return expensesRepository.findExpensesByMonthAndYear(accountId,month,year).orElse(null);
    }

}
