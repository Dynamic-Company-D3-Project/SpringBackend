package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entities.UserEntity;
import com.app.dto.UserLoginDto;

public interface UserDao extends JpaRepository<UserEntity, Long> {
	
Optional<UserEntity> findByEmailAndPassword(String email, String password);
Optional<UserEntity> findByEmail(String email);
}
