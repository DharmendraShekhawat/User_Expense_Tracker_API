package com.dharmendra.weekly_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class UserController {

    @Autowired
   ProductService productService;

    @Autowired
    UserService userService;

    //----------add products
 @PostMapping("/products")
    public ResponseEntity<String> addProducts(@RequestBody Product products){
     return productService.addProducts(products);
 }
    //----------add user
    @PostMapping("/user")
    public ResponseEntity<String> addUser(@RequestBody Users user){
        return userService.addUser(user);
    }

    //----------find products of particular date
    @GetMapping("/products/date")
    public ResponseEntity<List<Product>> findProductsOfDate(@RequestParam LocalDate date){
        return productService.findProductsOfDate(date);
    }
    //----------get all expenses of user from starting date to end date
    @GetMapping("/allExpenses/user/{userId}")
    public ResponseEntity<Double> findAllExpenses(@PathVariable Integer userId,  @RequestParam LocalDate startDate, @RequestParam LocalDate endDate){
        return productService.findAllExpenses(userId,startDate,endDate);
    }


}
