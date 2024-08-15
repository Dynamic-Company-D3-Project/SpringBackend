package com.app.Entities;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "cart_items")
@Data
public class CartItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private SubCategoryEntity subCategoryId;

} 

