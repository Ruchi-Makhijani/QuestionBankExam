package com.restApp.QuestionBankExam.controller;

import com.restApp.QuestionBankExam.model.Product;
import com.restApp.QuestionBankExam.model.ProductList;
import com.restApp.QuestionBankExam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/sortProducts")
    public List<Product> sortProducts(@RequestBody ProductList productList)
    {
        List<Product> products = productService.sortProducts(productList.getProductList());
        return products;

    }

}
