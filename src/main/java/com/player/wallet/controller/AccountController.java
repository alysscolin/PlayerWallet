package com.player.wallet.controller;

import com.player.wallet.dataobject.Account;
import com.player.wallet.datatransferobject.AccountDTO;
import com.player.wallet.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    //Get Current Balance of Player
    @GetMapping(value = "/balance/{playerId}")
    public ResponseEntity<AccountDTO> getCurrentBalance(@PathVariable("playerId") long playerId) {
        Account account = accountService.getAccountByPlayerId(playerId);
        AccountDTO accountVo = new AccountDTO(account.getName(), account.getPlayer().getId(), account.getBalance());
        return new ResponseEntity<>(accountVo, HttpStatus.OK);
    }
}
