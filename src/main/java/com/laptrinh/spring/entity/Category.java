package com.laptrinh.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "Categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer  id;

    @Column(name = "Name")
    private String  name;

    @Column(name = "NameVN")
    private String  nameVN;


    @OneToMany(mappedBy ="category",fetch = FetchType.LAZY)
            List<Product> products;
}
