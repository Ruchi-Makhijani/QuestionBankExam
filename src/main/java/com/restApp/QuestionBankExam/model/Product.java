package com.restApp.QuestionBankExam.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


@Data
@AllArgsConstructor
public class Product {
    private String productId;
    private String productName;
    private String unitOfMeasure;
    private LocalDate launchDate;
}
