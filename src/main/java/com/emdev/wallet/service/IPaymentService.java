package com.emdev.wallet.service;

import com.emdev.wallet.model.Account;
import com.emdev.wallet.model.Expenses;
import com.emdev.wallet.model.Movements;
import com.emdev.wallet.model.Payment;
import com.emdev.wallet.repository.AccountRepository;
import com.emdev.wallet.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class IPaymentService implements PaymentService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<Payment> getAccountPayments(Integer accountId) {
        return accountRepository.findPaymentsByAccount(accountId);
    }

    @Override
    public Payment getPayment(Integer paymentId) {
        return paymentRepository.findById(paymentId).orElse(null);
    }

    @Override
    public Payment createPayment(Integer accountId, Payment payment) throws Exception {
        Account account = accountRepository.findByAccountId(accountId).orElse(null);
        Payment newPayment = new Payment(payment.getAmount(),payment.getDescription());

        if(account.getBalance() < newPayment.getAmount()) {
            throw  new Exception("saldo insuficiente");
        }

        try {
            Expenses newExpense = new Expenses(newPayment.getDate(),newPayment.getAmount(),account.getAccountId());
            Movements newMovements = new Movements(newPayment.getAmount(), newPayment.getDescription(), newPayment.getDate() ,newPayment.getType());
            newMovements.getExpenses().add(newExpense);
            account.setPayment(newPayment.getAmount());
            account.getPayments().add(newPayment);
            account.getMovements().add(newMovements);

            return paymentRepository.save(newPayment);
        } catch (Exception e) {
            throw e;
        }



    }

}
