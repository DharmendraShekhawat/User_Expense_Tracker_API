package com.dharmendra.weekly_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    IProductRepo productRepo;

    public ResponseEntity<String> addProducts(Product products) {

        productRepo.save(products);
        HttpStatus status = HttpStatus.CREATED;
       return ResponseEntity.status(status).body("products added");
    }

    public ResponseEntity<List<Product>> findProductsOfDate(LocalDate date) {
     List<Product> products =  productRepo.findProductByDate(date);
        HttpStatus status = HttpStatus.ACCEPTED;
        return ResponseEntity.status(status).body(products);
    }

    public ResponseEntity<Double> findAllExpenses(Integer userId, LocalDate startDate, LocalDate endDate) {
        List<Product> products = productRepo.findProductByFkUserId(userId);


        double expense = 0;
        for(Product product : products){
            if(product.getDate().isAfter(startDate)  && product.getDate().isBefore(endDate)){
                expense += product.getProductPrice();
            }

        }

        HttpStatus status = HttpStatus.ACCEPTED;
        return ResponseEntity.status(status).body(expense);
    }
}
