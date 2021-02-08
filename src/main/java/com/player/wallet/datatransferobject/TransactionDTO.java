package com.player.wallet.datatransferobject;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;


public class TransactionDTO {
    @NotNull
    private UUID extTransId;

    @NotNull
    private long playerId;

    @NotNull
    private BigDecimal transAmount;

    private Date transactionDate;

    public TransactionDTO() {}

    public TransactionDTO(@NotNull UUID extTransId, @NotNull long playerId, @NotNull BigDecimal transAmount) {
        this.extTransId = extTransId;
        this.playerId = playerId;
        this.transAmount = transAmount;
    }

    public TransactionDTO(@NotNull UUID extTransId, @NotNull long playerId, @NotNull BigDecimal transAmount, Date transactionDate) {
        this.extTransId = extTransId;
        this.playerId = playerId;
        this.transAmount = transAmount;
        this.transactionDate = transactionDate;
    }

    public UUID getExtTransId() {
        return extTransId;
    }

    public void setExtTransId(UUID extTransId) {
        this.extTransId = extTransId;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
