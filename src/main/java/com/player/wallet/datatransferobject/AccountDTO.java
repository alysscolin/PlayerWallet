package com.player.wallet.datatransferobject;

import java.math.BigDecimal;

public class AccountDTO {
    private String accountName;
    private long playerId;
    private BigDecimal balance;

    public AccountDTO(String accountName, long playerId, BigDecimal balance) {
        this.accountName = accountName;
        this.playerId = playerId;
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
