package com.zorvyn.demo.transaction_ledger_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Transaction {

    @Getter
    @Setter
    @Id
    private String transactionId;
    @Getter
    @Setter
    private String userId;
    @Getter
    @Setter
    private double amount;
}