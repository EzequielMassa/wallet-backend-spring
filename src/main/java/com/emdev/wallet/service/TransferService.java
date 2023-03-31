package com.emdev.wallet.service;

import com.emdev.wallet.model.Deposit;
import com.emdev.wallet.model.Transfer;

import java.util.List;


public interface TransferService {
    List<Transfer> getAccountTransfers(Integer accountId);
    Transfer getTransfer(Integer transferId);

    Transfer createTransfer(Integer accountOriginId,Integer accountDestinyId, Transfer transfer) throws Exception;
}
