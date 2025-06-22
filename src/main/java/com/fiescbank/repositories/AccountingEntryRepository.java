package com.fiescbank.repositories;

import com.fiescbank.entities.AccountingEntry;
import com.fiescbank.entities.BankStatement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountingEntryRepository extends JpaRepository<AccountingEntry, Integer> {
    @Query("SELECT a.id, a.numberAccount, COALESCE(SUM(ae.amount), 0) " +
            "FROM Account a " +
            "LEFT JOIN AccountingEntry ae ON ae.account = a " +
            "WHERE a.person.id = :personId " +
            "GROUP BY a.id, a.numberAccount")
    List<Object[]> findAccountBalanceByPersonId(@Param("personId") Integer personId);

    @Query("SELECT new com.fiescbank.entities.BankStatement(ae.amount, ae.createdAt) " +
            "FROM AccountingEntry ae " +
            "WHERE ae.account.id = :accountId")
    List<BankStatement> findAmountsAndTimestampsByAccountId(@Param("accountId") Integer accountId);

}
