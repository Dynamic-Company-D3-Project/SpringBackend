package com.app.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table(name = "provider")
@ToString(callSuper = true)
public class ProviderEntity extends UserBaseEntity {
 @Column(length = 25)
 private String country;
 @Column(name="zip_code")
 private Long zipCode;
 @Column(length = 25)
 private String city;
 private Boolean isDeleted ;
 @Column(name="provider_image_path")
 private String providerImagePath;
}
