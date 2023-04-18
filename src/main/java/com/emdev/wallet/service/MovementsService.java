package com.emdev.wallet.service;

import com.emdev.wallet.model.Movements;

import java.util.List;


public interface MovementsService {
    List<Movements> getAccountMovements(Integer accountId);


}
