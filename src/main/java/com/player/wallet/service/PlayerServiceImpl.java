package com.player.wallet.service;

import com.player.wallet.dataaccessobject.PlayerRepository;
import com.player.wallet.dataobject.Player;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player getPlayerById(long playerId) {
        Optional<Player> player =  playerRepository.findById(playerId);
        if(!player.isPresent()) {
            throw new RuntimeException("Player Not Found");
        }
        return player.get();
    }
}
