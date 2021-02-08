package com.player.wallet.dataaccessobject;

import com.player.wallet.dataobject.Transaction;
import com.player.wallet.datatransferobject.TransactionDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    Optional<Transaction> getTransactionByExtTransId(UUID transId);

    @Query("SELECT new com.player.wallet.datatransferobject.TransactionDTO(t.extTransId, t.playerId, t.transAmount) FROM Transaction t WHERE t.playerId = :playerId")
    public List<TransactionDTO> findTransactionsByPlayerId(@Param("playerId") long playerId);
}
