package com.restApp.QuestionBankExam.service;

import com.restApp.QuestionBankExam.model.Product;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    public List<Product> sortProducts(List<Product> productList) {
        List<Product> collect = productList.stream().sorted(Comparator.comparing(Product::getProductId).thenComparing(Product::getLaunchDate).reversed()).collect(Collectors.toList());
        return collect;
    }
}
