package com.app.Entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "subcategory")
@ToString(exclude = "category") // Exclude category from toString
public class SubCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;
    
    @Column(length = 25)
    private String categoryName;
    
    @Column(length = 255)
    private String description;
    
    private String image;
    
    @Min(value = 0, message = "Rating should be between 0 and 5")
    @Max(value = 5, message = "Rating should be between 0 and 5")
    private int rating;
    
    private double price;
    
    private int isVisible;
    
    @UpdateTimestamp
    private LocalDate lastUpdated;
}
