package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.Entities.ProviderSupportEntity;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.ProviderSupportDao;

@Service
@Transactional
public class ProviderSupportService {
@Autowired
ProviderSupportDao providerSupportDao;


	
	public Optional<ProviderSupportEntity> getAllTickets(Long id){
		return providerSupportDao.findById(id);
	}
}
