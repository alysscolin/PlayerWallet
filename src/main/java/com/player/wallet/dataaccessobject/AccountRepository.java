package com.player.wallet.dataaccessobject;

import com.player.wallet.dataobject.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Optional<Account> getByPlayerId(long playerId);
}
