package com.laptrinh.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Image")
    private String image;
    @Column(name = "UnitPrice")
    private Double unitPrice;
    @Column(name = "Discount")
    private Double discount;
    @Column(name = "Quantity")
    private Integer quantity;
    @Temporal(TemporalType.DATE)
    @Column(name = "ProductDate")
    private Date productDate;
    @Column(name = "Available")
    private Boolean available;

    @ManyToOne // nhiều
    @JoinColumn(name = "categoryId")
    Category category;  // một

    @Column(name = "Description")
    private String description;
    @Column(name = "ViewCount")
    private Integer viewCount;
}
