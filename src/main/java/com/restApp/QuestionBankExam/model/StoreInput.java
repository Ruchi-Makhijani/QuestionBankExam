package com.restApp.QuestionBankExam.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class StoreInput {
    private String storeNo;
    private String productId;
    private double reqQty;
    private LocalDate reqDate;
}
