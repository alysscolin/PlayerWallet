package com.player.wallet.service;

import com.player.wallet.dataaccessobject.TransactionRepository;
import com.player.wallet.dataobject.Account;
import com.player.wallet.dataobject.Player;
import com.player.wallet.dataobject.Transaction;
import com.player.wallet.datatransferobject.TransactionDTO;
import com.player.wallet.datatransferobject.WalletDTO;
import com.player.wallet.transactiontype.TransType;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private PlayerService playerService;

    /**
     * Validation for external transaction Id
     *
     * @param transId
     * @return
     */
    private boolean validateTransaction(UUID transId) {

        Optional<Transaction> transaction = transactionRepository.getTransactionByExtTransId(transId);

        if (transaction.isPresent()) {
            throw new RuntimeException("You can not use already existed transaction Id");
        }

        return true;
    }

    private Transaction generateTransaction(TransactionDTO transactionDto) {

        Player player = playerService.getPlayerById(transactionDto.getPlayerId());
        Account account = accountService.getAccountByPlayerId(player.getId());

        Transaction transaction = new Transaction();
        transaction.setExtTransId(transactionDto.getExtTransId());
        transaction.setTransAmount(transactionDto.getTransAmount());
        transaction.setBalance(account.getBalance());
        transaction.setAccountId(account.getId());
        transaction.setPlayerId(player.getId());

        return transaction;
    }

    private boolean validateBalance(Transaction transaction) {
        if (transaction.getBalance().subtract(transaction.getTransAmount()).intValue() < 0) {
            throw new RuntimeException("Balance is not sufficient");
        }
        return true;
    }

    private WalletDTO updateBalance(Transaction transaction, BigDecimal newBalance) {
        WalletDTO walletDto = new WalletDTO();

        BigDecimal oldBalance = transaction.getBalance();
        accountService.updateAccountBalanceById(newBalance, transaction.getAccountId());
        transactionRepository.save(transaction);
        walletDto.setOldBalance(oldBalance);
        walletDto.setNewBalance(newBalance);
        walletDto.setAccountId(transaction.getAccountId());

        return walletDto;
    }

    @Override
    public WalletDTO debit(TransactionDTO transactionDto) {
        validateTransaction(transactionDto.getExtTransId());

        Transaction transaction = generateTransaction(transactionDto);
        transaction.setTransType(TransType.DEBIT);

        validateBalance(transaction);

        BigDecimal newBalance = transaction.getBalance().subtract(transaction.getTransAmount());
        WalletDTO responseVo = updateBalance(transaction, newBalance);

        return responseVo;
    }

    @Override
    public WalletDTO credit(TransactionDTO transactionDto) {
        validateTransaction(transactionDto.getExtTransId());

        Transaction transaction = generateTransaction(transactionDto);
        transaction.setTransType(TransType.CREDIT);

        BigDecimal newBalance = transaction.getBalance().add(transaction.getTransAmount());

        return updateBalance(transaction, newBalance);
    }

    @Override
    public List<TransactionDTO> getAllTransactionsByPlayerId(long playerId) {
        return transactionRepository.findTransactionsByPlayerId(playerId);
    }
}
