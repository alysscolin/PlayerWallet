package com.player.wallet.service;

import com.player.wallet.dataaccessobject.AccountRepository;
import com.player.wallet.dataobject.Account;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Optional;

public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    private void validateAccount(Optional<Account> account) {
        if (!account.isPresent()) {
            throw new RuntimeException("Account Not Found");
        }
    }

    @Override
    public Account getAccountByPlayerId(long playerId) {
        Optional<Account> account = accountRepository.getByPlayerId(playerId);
        validateAccount(account);
        return account.get();
    }

    @Override
    public void updateAccountBalanceById(BigDecimal newBalance, Long id) {
        Optional<Account> account = accountRepository.findById(id);
        validateAccount(account);
        account.get().setBalance(newBalance);
        accountRepository.save(account.get());
    }
}
