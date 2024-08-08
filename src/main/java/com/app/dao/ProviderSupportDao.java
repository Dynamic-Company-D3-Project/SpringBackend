package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entities.ProviderSupportEntity;

public interface ProviderSupportDao extends JpaRepository<ProviderSupportEntity, Long> {
	
}
