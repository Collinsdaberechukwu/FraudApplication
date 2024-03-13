package com.example.fraudapplication;

import com.example.fraudapplication.domain.enums.AlertName;
import com.example.fraudapplication.domain.model.Alert;
import com.example.fraudapplication.domain.utils.DateUtils;
import com.example.fraudapplication.service.impl.AlertGeneratorImpl;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AlertGeneratorImplTest {

    @Test
    public void testGenerateHighTransactionAlert() {
        String userId = "testUser";
        AlertGeneratorImpl alertGenerator = new AlertGeneratorImpl();

        Alert alert = alertGenerator.generateHighTransactionAlert(userId);

        assertEquals(userId, alert.getUserId());
        assertEquals(AlertName.HIGH_TRANSACTION.getAlertName(), alert.getAlertName());
        assertEquals(AlertName.HIGH_TRANSACTION.getAlertMessage(), alert.getAlertMessage());
        assertEquals(DateUtils.stringifyDate(LocalDateTime.now()), alert.getAlertTime());
    }

    @Test
    public void testGenerateMultipleServiceAlert() {
        String userId = "testUser";
        AlertGeneratorImpl alertGenerator = new AlertGeneratorImpl();

        Alert alert = alertGenerator.generateMultipleServiceAlert(userId);

        assertEquals(userId, alert.getUserId());
        assertEquals(AlertName.MULTIPLE_SERVICE.getAlertName(), alert.getAlertName());
        assertEquals(AlertName.MULTIPLE_SERVICE.getAlertMessage(), alert.getAlertMessage());
        assertEquals(DateUtils.stringifyDate(LocalDateTime.now()), alert.getAlertTime());
    }

    @Test
    public void testGeneratePingPongAlert() {
        String userId = "testUser";
        AlertGeneratorImpl alertGenerator = new AlertGeneratorImpl();


        Alert alert = alertGenerator.generatePingPongAlert(userId);

        assertEquals(userId, alert.getUserId());
        assertEquals(AlertName.PING_PONG.getAlertName(), alert.getAlertName());
        assertEquals(AlertName.PING_PONG.getAlertMessage(), alert.getAlertMessage());
        assertEquals(DateUtils.stringifyDate(LocalDateTime.now()), alert.getAlertTime());
    }
}
