package com.emdev.wallet.repository;

import com.emdev.wallet.model.Movements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovementsRepository extends JpaRepository<Movements,Integer> {

}
