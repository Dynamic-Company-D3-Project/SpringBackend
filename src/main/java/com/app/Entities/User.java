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
@Table(name="user")
@ToString(callSuper = true)
public class User extends UserBaseEntity {
private int age;
@Column(name = "is_deleted")
private boolean isDeleted;
@Column(name="image_path")
private String imagePath;
}
