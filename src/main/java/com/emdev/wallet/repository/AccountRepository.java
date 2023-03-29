package com.emdev.wallet.repository;

import com.emdev.wallet.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

    Optional<Account> findByAccountId(Integer accountId);

}
