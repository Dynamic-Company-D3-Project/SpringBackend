package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.ProviderSupportService;

@RestController
@RequestMapping("/provider-support")
public class ProviderSupportController {

	@Autowired
	ProviderSupportService psService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getAllTickets(@PathVariable Long id){
		return ResponseEntity.ok().body(psService.getAllTickets(id));
	}
}
