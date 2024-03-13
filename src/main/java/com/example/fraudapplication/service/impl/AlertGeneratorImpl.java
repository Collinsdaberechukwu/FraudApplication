package com.example.fraudapplication.service.impl;

import com.example.fraudapplication.domain.enums.AlertName;
import com.example.fraudapplication.domain.model.Alert;
import com.example.fraudapplication.domain.utils.DateUtils;
import com.example.fraudapplication.service.AlertGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AlertGeneratorImpl implements AlertGenerator {

    @Override
    public Alert generateHighTransactionAlert(String userId){
        return Alert.builder()
                .userId(userId)
                .alertName(AlertName.HIGH_TRANSACTION.getAlertName())
                .alertMessage(AlertName.HIGH_TRANSACTION.getAlertMessage())
                .alertTime(DateUtils.stringifyDate(LocalDateTime.now()))
                .build();
    }

    @Override
    public Alert generateMultipleServiceAlert(String userId){
        return Alert.builder()
                .userId(userId)
                .alertName(AlertName.MULTIPLE_SERVICE.getAlertName())
                .alertMessage(AlertName.MULTIPLE_SERVICE.getAlertMessage())
                .alertTime(DateUtils.stringifyDate(LocalDateTime.now()))
                .build();
    }

    @Override
    public Alert generatePingPongAlert(String userId){
        return Alert.builder()
                .userId(userId)
                .alertName(AlertName.PING_PONG.getAlertName())
                .alertMessage(AlertName.PING_PONG.getAlertMessage())
                .alertTime(DateUtils.stringifyDate(LocalDateTime.now()))
                .build();
    }
}
