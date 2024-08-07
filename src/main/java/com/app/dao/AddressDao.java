package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entities.AddressEntity;

public interface AddressDao extends JpaRepository<AddressEntity, Long> {

}
