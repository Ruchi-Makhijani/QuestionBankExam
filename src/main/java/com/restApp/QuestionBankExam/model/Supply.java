package com.restApp.QuestionBankExam.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Supply {
    private String productId;
    private double quantity;
}
