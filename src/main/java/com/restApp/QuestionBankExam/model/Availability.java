package com.restApp.QuestionBankExam.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Availability {
    private String storeNo;
    private String productId;
    private LocalDate date;
    private double availQty;
}
