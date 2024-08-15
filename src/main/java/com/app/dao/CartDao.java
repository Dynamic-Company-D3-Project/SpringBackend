package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entities.CartItemEntity;
import com.app.Entities.UserEntity;

public interface CartDao extends JpaRepository<CartItemEntity, Long> {

	List<CartItemEntity> findByUserId(UserEntity user);

}
