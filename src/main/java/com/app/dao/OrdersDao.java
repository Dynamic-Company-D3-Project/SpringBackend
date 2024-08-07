package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entities.OrdersEntity;
import com.app.Entities.UserEntity;

public interface OrdersDao extends JpaRepository<OrdersEntity, Long>{

	List<OrdersEntity> findByUserId(UserEntity userId);

}
