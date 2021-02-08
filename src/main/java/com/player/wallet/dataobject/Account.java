package com.player.wallet.dataobject;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private BigDecimal balance;

    @OneToOne
    private Player player;

    @Version
    private Long version;

    public Account() {}

    public Account(Long id, String name, BigDecimal balance, Player player) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.player = player;
    }

    public Account(String name, BigDecimal balance, Player player) {
        this.name = name;
        this.balance = balance;
        this.player = player;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
