package com.example.fraudapplication.service;

import com.example.fraudapplication.domain.model.Alert;
import com.example.fraudapplication.domain.model.TransactionEvent;

import java.util.List;

public interface MultipleServiceTransaction {
    List<Alert> checkMultipleServiceTransactions(List<TransactionEvent> transactions, List<Alert> alerts,
                                                 String userId);
}
