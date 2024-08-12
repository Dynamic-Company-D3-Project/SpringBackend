package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entities.BookingEntity;
import com.app.Entities.UserEntity;

public interface BookingDao extends JpaRepository<BookingEntity, Long> {

	List<BookingEntity> findByUserId(UserEntity user);
}
