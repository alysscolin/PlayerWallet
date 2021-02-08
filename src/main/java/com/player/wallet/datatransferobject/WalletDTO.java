package com.player.wallet.datatransferobject;

import java.math.BigDecimal;

public class WalletDTO {
    private long accountId;
    private BigDecimal oldBalance;
    private BigDecimal newBalance;

    public WalletDTO() {}

    public WalletDTO(long accountId, BigDecimal oldBalance, BigDecimal newBalance) {
        this.accountId = accountId;
        this.oldBalance = oldBalance;
        this.newBalance = newBalance;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getOldBalance() {
        return oldBalance;
    }

    public void setOldBalance(BigDecimal oldBalance) {
        this.oldBalance = oldBalance;
    }

    public BigDecimal getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(BigDecimal newBalance) {
        this.newBalance = newBalance;
    }
}
