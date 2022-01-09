package com.laptrinh.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Customers")
public class Customer {
    @Id
    @Column(name="Id")
    private String id;

    @Column(name = "Password")
    private String password;

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "Email")
    private String email;

    @Column(name="Photo")
    private String photo;

    @Column(name = "Activated")
    private Boolean activated = false;

    @Column(name = "Admin")
    private Boolean admin = false;
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    List<Order> orderList;
}
