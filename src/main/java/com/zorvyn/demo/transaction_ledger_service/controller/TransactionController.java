package com.zorvyn.demo.transaction_ledger_service.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.zorvyn.demo.transaction_ledger_service.model.Transaction;
import com.zorvyn.demo.transaction_ledger_service.service.TransactionService;

@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping("/transaction")
    public String createTransaction(@RequestBody Transaction tx) {
        service.processTransaction(tx);
        return "Transaction processed";
    }

    @GetMapping("/balance/{userId}")
    public double getBalance(@PathVariable String userId) {
        return service.getBalance(userId);
    }
}