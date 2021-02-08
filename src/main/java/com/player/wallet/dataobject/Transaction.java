package com.player.wallet.dataobject;

import com.player.wallet.transactiontype.TransType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private UUID extTransId;

    @Column
    private TransType transType;

    @Column
    private BigDecimal transAmount;

    @Column
    private BigDecimal balance;

    @Column
    private long accountId;

    @Column
    private long playerId;

    public Transaction() { }

    public Transaction(UUID extTransId, TransType transType, BigDecimal transAmount, BigDecimal balance, long playerId) {
        this.extTransId = extTransId;
        this.transType = transType;
        this.transAmount = transAmount;
        this.balance = balance;
        this.playerId = playerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getExtTransId() {
        return extTransId;
    }

    public void setExtTransId(UUID extTransId) {
        this.extTransId = extTransId;
    }

    public TransType getTransType() {
        return transType;
    }

    public void setTransType(TransType transType) {
        this.transType = transType;
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }
}
