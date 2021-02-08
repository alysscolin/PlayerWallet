package com.player.wallet.service;

import com.player.wallet.datatransferobject.TransactionDTO;
import com.player.wallet.datatransferobject.WalletDTO;

import java.util.List;

public interface TransactionService {
    /**
     * Make debit to account
     * @param transactionDto
     */
    public WalletDTO debit(TransactionDTO transactionDto);

    /**
     * Make credit to account by generated transaction record
     * @param transactionDto
     */
    public WalletDTO credit(TransactionDTO transactionDto);

    public List<TransactionDTO> getAllTransactionsByPlayerId(long playerId);
}
