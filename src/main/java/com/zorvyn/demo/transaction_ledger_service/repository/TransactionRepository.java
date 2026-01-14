package com.zorvyn.demo.transaction_ledger_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zorvyn.demo.transaction_ledger_service.model.Transaction;

public interface TransactionRepository
        extends JpaRepository<Transaction, String> {
}