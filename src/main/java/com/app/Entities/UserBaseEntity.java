package com.app.Entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import Helpers.Gender;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString(exclude = {"creationTime"})
public class UserBaseEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(length = 25,nullable = false,name = "first_name")
private String firstName;
@Column(length = 25,nullable = false,name = "last_name")
private String lastName;
@Column(nullable = false)
private String password;
@Column(unique = true,nullable = false)
private String email;
@Column(length = 20,name="phone_number")
private String phoneNumber;
@Enumerated(EnumType.STRING)
private Gender gender;
@CreationTimestamp
@Column(name="creation_time")
private LocalDateTime creationTime;
@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
@Column(name="last_login_time")
private LocalDateTime lastLoginTime;
}
