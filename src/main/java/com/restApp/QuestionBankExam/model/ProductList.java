package com.restApp.QuestionBankExam.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductList {
    private List<Product> productList;
}
