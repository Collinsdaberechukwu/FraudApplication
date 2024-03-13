package com.example.fraudapplication.service;


import com.example.fraudapplication.domain.model.Alert;

public interface AlertGenerator {
    Alert generateHighTransactionAlert(String userId);

    Alert generateMultipleServiceAlert(String userId);

    Alert generatePingPongAlert(String userId);
}
