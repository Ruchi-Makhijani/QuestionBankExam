package com.restApp.QuestionBankExam.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DemandResponse {
    private String productId;
    private double availability;
}
