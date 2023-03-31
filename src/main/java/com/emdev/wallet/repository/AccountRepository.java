package com.emdev.wallet.repository;

import com.emdev.wallet.model.Payment;
import com.emdev.wallet.model.Account;
import com.emdev.wallet.model.Deposit;
import com.emdev.wallet.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

    Optional<Account> findByAccountId(Integer accountId);

    @Query("SELECT dep FROM Account acc join acc.deposits dep WHERE acc.accountId = :id")
    List<Deposit> findDepositsByAccount(@Param("id") Integer Id);

    @Query("SELECT pay FROM Account acc join acc.payments pay WHERE acc.accountId = :id")
    List<Payment> findPaymentsByAccount(@Param("id") Integer Id);

    @Query("SELECT trans FROM Account acc join acc.transfers trans WHERE acc.accountId = :id")
    List<Transfer> findTransfersByAccount(@Param("id") Integer Id);

}
