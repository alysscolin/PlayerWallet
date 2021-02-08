package com.player.wallet.service;

import com.player.wallet.dataobject.Account;

import java.math.BigDecimal;

public interface AccountService {
    public Account getAccountByPlayerId(long playerId);
    public void updateAccountBalanceById(BigDecimal newBalance, Long id);
}
