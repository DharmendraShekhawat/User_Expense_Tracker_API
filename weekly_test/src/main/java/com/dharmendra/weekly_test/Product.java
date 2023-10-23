package com.dharmendra.weekly_test;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    private String productTitle;
    private String productDesc;
    private ProductType productType;
    private double productPrice;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    Users user;

}
