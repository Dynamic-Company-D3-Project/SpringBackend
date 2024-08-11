package com.app.Entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
@Table(name="user")
@ToString(callSuper = true)
public class UserEntity extends UserBaseEntity implements UserDetails {
private int age;
@Column(name = "is_deleted")
private boolean isDeleted;
@Column(name="image_path")
private String imagePath;
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public String getUsername() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean isEnabled() {
	// TODO Auto-generated method stub
	return false;
}
}
