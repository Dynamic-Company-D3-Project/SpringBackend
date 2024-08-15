package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.Entities.AddressEntity;
import com.app.Entities.UserEntity;

import Helpers.AddressTypeEnum;

public interface AddressDao extends JpaRepository<AddressEntity, Long> {
List<AddressEntity> findAllByUser(UserEntity user);
//AddressEntity findByAddressType(AddressTypeEnum aEnum);

	
	AddressEntity findByUserAndAddressType(UserEntity user, AddressTypeEnum addressType);
}
