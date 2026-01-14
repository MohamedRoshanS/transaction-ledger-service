package com.zorvyn.demo.transaction_ledger_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class UserBalance {

    @Id
    private String userId;
    @Getter
    @Setter
    private double balance;

    public UserBalance() {}


    public UserBalance(String userId, double balance) {
        this.userId = userId;
        this.balance = balance;
    }


    // getters & setters
}