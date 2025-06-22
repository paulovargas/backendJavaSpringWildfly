package com.fiescbank.repositories;

import com.fiescbank.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findByNumberAccount(String numberAccount);
}
