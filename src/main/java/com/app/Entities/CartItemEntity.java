package com.app.Entities;

import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;
import lombok.ToString;



@Entity
@Table(name = "cartItems")
@Data
@ToString(exclude = {"cart"})
public class CartItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    
    @CreatedDate
    private LocalDate addedAt; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private CartEntity cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_id")
    private SubCategoryEntity subCategory;
}


