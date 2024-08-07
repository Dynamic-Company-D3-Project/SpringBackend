package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entities.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Long> {

}
