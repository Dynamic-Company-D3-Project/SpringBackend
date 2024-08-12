package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entities.CartItemEntity;

public interface CartDao extends JpaRepository<CartItemEntity, Long>{

}
