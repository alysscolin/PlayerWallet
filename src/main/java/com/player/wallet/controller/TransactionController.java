package com.player.wallet.controller;


import com.player.wallet.datatransferobject.TransactionDTO;
import com.player.wallet.datatransferobject.WalletDTO;
import com.player.wallet.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    //Get Transaction History of player
    @GetMapping(value = "/history/{playerId}")
    public ResponseEntity<List<TransactionDTO>> transactionHistory(@PathVariable("playerId") long playerId) {
        List<TransactionDTO> playerTransactionHistoryList = transactionService.getAllTransactionsByPlayerId(playerId);
        return new ResponseEntity<>(playerTransactionHistoryList, HttpStatus.OK);
    }

    //Make Credit to Player Account
    @PostMapping(value = "/credit")
    public ResponseEntity<WalletDTO> credit(@RequestBody TransactionDTO transactionDto) throws Exception {
        WalletDTO walletDto = transactionService.credit(transactionDto);
        return new ResponseEntity<>(walletDto, HttpStatus.OK);
    }

    //Make Debit to Player Account
    @PostMapping(value = "/debit")
    public ResponseEntity<WalletDTO> debit(@RequestBody TransactionDTO transactionDto) throws Exception {
        WalletDTO responseVo = transactionService.debit(transactionDto);
        return new ResponseEntity<>(responseVo, HttpStatus.OK);
    }
}
