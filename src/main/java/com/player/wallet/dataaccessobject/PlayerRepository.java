package com.player.wallet.dataaccessobject;

import com.player.wallet.dataobject.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlayerRepository extends CrudRepository<Player, Long> {
    Optional<Player> getPlayerById(long id);
    Optional<Player> getPlayerByName(String name);
}
