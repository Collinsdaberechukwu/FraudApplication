package com.example.fraudapplication.service;


import com.example.fraudapplication.domain.model.Alert;
import com.example.fraudapplication.domain.model.TransactionEvent;

import java.util.List;

public interface FraudDetectorEngineService {

    List<Alert> checkAllFraudActivities(List<TransactionEvent> events);

    List<Alert> checkHighTransactionFraud(List<TransactionEvent> events);

    List<Alert> checkPingPongFraud(List<TransactionEvent> events);

    List<Alert> checkMultipleServiceFraud(List<TransactionEvent> events);



}
