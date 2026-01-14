package com.zorvyn.demo.transaction_ledger_service.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.zorvyn.demo.transaction_ledger_service.model.*;
import com.zorvyn.demo.transaction_ledger_service.repository.*;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepo;

    @Autowired
    private UserBalanceRepository balanceRepo;

    public void processTransaction(Transaction tx) {

        // 1. Idempotency check
        if (transactionRepo.existsById(tx.getTransactionId())) {
            return;
        }

        // 2. Save transaction
        transactionRepo.save(tx);

        // 3. Update balance
        UserBalance balance = balanceRepo
                .findById(tx.getUserId())
                .orElse(new UserBalance(tx.getUserId(), 0));

        balance.setBalance(balance.getBalance() + tx.getAmount());
        balanceRepo.save(balance);
    }

    public double getBalance(String userId) {
        return balanceRepo
                .findById(userId)
                .map(UserBalance::getBalance)
                .orElse(0.0);
    }
}
