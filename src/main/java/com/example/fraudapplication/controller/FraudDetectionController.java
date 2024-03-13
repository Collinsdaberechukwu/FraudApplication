package com.example.fraudapplication.controller;
import com.example.fraudapplication.domain.model.Alert;
import com.example.fraudapplication.domain.model.TransactionEvent;
import com.example.fraudapplication.domain.utils.ListToCsv;
import com.example.fraudapplication.service.FraudDetectorEngineService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("fraud")
@RequiredArgsConstructor
public class FraudDetectionController {

    private final FraudDetectorEngineService fraudDetectorEngineService;
    private final String CSV_FILE_PATH = "path/to/your/csv/file.csv";

    private List<TransactionEvent> generateTransactionEvents() {
        List<TransactionEvent> events = new ArrayList<>();

        events.add(new TransactionEvent(Instant.now().plusSeconds(480), 150.00, "user1", "serviceA")); // User1 conducts a transaction in serviceA
        events.add(new TransactionEvent(Instant.now().plusSeconds(480), 200.00, "user1", "serviceB")); // User1 conducts a transaction in serviceB
        events.add(new TransactionEvent(Instant.now().plusSeconds(480), 250.00, "user1", "serviceC")); // User1 conducts a transaction in serviceC
        events.add(new TransactionEvent(Instant.now().plusSeconds(480), 300.00, "user1", "serviceD")); // User1 conducts a transaction in serviceD
        events.add(new TransactionEvent(Instant.now().plusSeconds(480), 350.00, "user1", "serviceE")); // User1 conducts a transaction in serviceE

        events.add(new TransactionEvent(Instant.now().plusSeconds(720), 400.00, "user1", "serviceF")); // User1 conducts a transaction in serviceF
        events.add(new TransactionEvent(Instant.now().plusSeconds(780), 450.00, "user1", "serviceG")); // User1 conducts a transaction in serviceG
        events.add(new TransactionEvent(Instant.now().plusSeconds(840), 500.00, "user1", "serviceF")); // User1 conducts another transaction in serviceF
        events.add(new TransactionEvent(Instant.now().plusSeconds(780), 450.00, "user1", "serviceG"));
        events.add(new TransactionEvent(Instant.now().plusSeconds(24 *60 *60 * 2), 10000.00, "user1", "serviceH")); // User1 conducts a transaction with an unusually high amount

        events.add(new TransactionEvent(Instant.now().plusSeconds(480), 150.00, "user2", "serviceA")); // User2 conducts a transaction in serviceA
        events.add(new TransactionEvent(Instant.now().plusSeconds(480), 200.00, "user2", "serviceB")); // User2 conducts a transaction in serviceB
        events.add(new TransactionEvent(Instant.now().plusSeconds(480), 250.00, "user2", "serviceC")); // User2 conducts a transaction in serviceC
        events.add(new TransactionEvent(Instant.now().plusSeconds(480), 300.00, "user2", "serviceD")); // User2 conducts a transaction in serviceD
        events.add(new TransactionEvent(Instant.now().plusSeconds(480), 350.00, "user2", "serviceE")); // User2 conducts a transaction in serviceE

        events.add(new TransactionEvent(Instant.now().plusSeconds(720), 400.00, "user2", "serviceF")); // User2 conducts a transaction in serviceF
        events.add(new TransactionEvent(Instant.now().plusSeconds(780), 450.00, "user2", "serviceG")); // User2 conducts a transaction in serviceG
        events.add(new TransactionEvent(Instant.now().plusSeconds(840), 500.00, "user2", "serviceF")); // User2 conducts another transaction in serviceF

        events.add(new TransactionEvent(Instant.now().plusSeconds(24 *60 *60 * 2), 10000.00, "user2", "serviceH")); // User2 conducts a transaction with an unusually high amount

        return events;
    }

    @GetMapping("/all")
    public List<Alert> checkAllFraudTransactions(){
        return fraudDetectorEngineService.checkAllFraudActivities(generateTransactionEvents());
    }

    @GetMapping("/download")
    public ResponseEntity<Void> exportCsv (HttpServletResponse httpServletResponse) throws FileNotFoundException {
        List<TransactionEvent> events = new ArrayList<>();

        events.add(new TransactionEvent(Instant.now().plusSeconds(480), 150.00, "user1", "serviceA")); // User1 conducts a transaction in serviceA
        events.add(new TransactionEvent(Instant.now().plusSeconds(480), 200.00, "user1", "serviceB")); // User1 conducts a transaction in serviceB
        events.add(new TransactionEvent(Instant.now().plusSeconds(480), 250.00, "user1", "serviceC")); // User1 conducts a transaction in serviceC
        events.add(new TransactionEvent(Instant.now().plusSeconds(480), 300.00, "user1", "serviceD")); // User1 conducts a transaction in serviceD
        events.add(new TransactionEvent(Instant.now().plusSeconds(480), 350.00, "user1", "serviceE")); // User1 conducts a transaction in serviceE

        events.add(new TransactionEvent(Instant.now().plusSeconds(720), 400.00, "user1", "serviceF")); // User1 conducts a transaction in serviceF
        events.add(new TransactionEvent(Instant.now().plusSeconds(780), 450.00, "user1", "serviceG")); // User1 conducts a transaction in serviceG
        events.add(new TransactionEvent(Instant.now().plusSeconds(840), 500.00, "user1", "serviceF")); // User1 conducts another transaction in serviceF
        events.add(new TransactionEvent(Instant.now().plusSeconds(780), 450.00, "user1", "serviceG"));
        events.add(new TransactionEvent(Instant.now().plusSeconds(24 *60 *60 * 2), 10000.00, "user1", "serviceH")); // User1 conducts a transaction with an unusually high amount

        events.add(new TransactionEvent(Instant.now().plusSeconds(480), 150.00, "user2", "serviceA")); // User2 conducts a transaction in serviceA
        events.add(new TransactionEvent(Instant.now().plusSeconds(480), 200.00, "user2", "serviceB")); // User2 conducts a transaction in serviceB
        events.add(new TransactionEvent(Instant.now().plusSeconds(480), 250.00, "user2", "serviceC")); // User2 conducts a transaction in serviceC
        events.add(new TransactionEvent(Instant.now().plusSeconds(480), 300.00, "user2", "serviceD")); // User2 conducts a transaction in serviceD
        events.add(new TransactionEvent(Instant.now().plusSeconds(480), 350.00, "user2", "serviceE")); // User2 conducts a transaction in serviceE

        events.add(new TransactionEvent(Instant.now().plusSeconds(720), 400.00, "user2", "serviceF")); // User2 conducts a transaction in serviceF
        events.add(new TransactionEvent(Instant.now().plusSeconds(780), 450.00, "user2", "serviceG")); // User2 conducts a transaction in serviceG
        events.add(new TransactionEvent(Instant.now().plusSeconds(840), 500.00, "user2", "serviceF")); // User2 conducts another transaction in serviceF

        events.add(new TransactionEvent(Instant.now().plusSeconds(24 *60 *60 * 2), 10000.00, "user2", "serviceH")); // User2 conducts a transaction with an unusually high amount

        ListToCsv.exportCSV(events,httpServletResponse,"fraudDetection");
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
