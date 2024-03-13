package com.example.fraudapplication.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TransactionEvent {
    private Instant timestamp;
    private double amount;
    private String userID;
    private String serviceID;
}
