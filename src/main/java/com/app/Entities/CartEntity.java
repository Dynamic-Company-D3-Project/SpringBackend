package com.app.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="carts")
@Data
public class CartEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cartId;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private UserEntity userId;
	
	@OneToMany(mappedBy = "cartId",
			cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartItemEntity> cartItems = new ArrayList<>();
	
	
}