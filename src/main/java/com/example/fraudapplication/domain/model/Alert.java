package com.example.fraudapplication.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Alert {

    private String userId;
    private String alertName;
    private String alertMessage;
    private String alertTime;
}
