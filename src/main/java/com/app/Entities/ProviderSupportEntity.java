package com.app.Entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import Helpers.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
//@Data
//@Getter
//@Setter
//@Table(name = "provider_support")
//public class ProviderSupportEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long supportId; 
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "bookingId")
//    private BookingEntity booking; 
//    
//    @ManyToOne
//    @JoinColumn(name="providerId")
//    private ProviderEntity provider;
//    
//    @Column(length = 100, nullable = false)
//    private String supportType;
//    @Column(length = 255,nullable = false)
//    private String description;
//    
//    @Enumerated(EnumType.STRING)
//    private Status status;
//}
