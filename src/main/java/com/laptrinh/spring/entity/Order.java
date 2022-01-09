package com.laptrinh.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "customerId")
    Customer customer;
    @Temporal(TemporalType.DATE)
    @Column(name="OrderDate")
    private Date orderDate;
    @Column(name="Address")
    private String address;
    @Column(name = "Amount")
    private Double amount;
    @Column(name = "Description")
    private String description;
    @Column(name ="Status")
    private Integer status;
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    List<OrderDetail> orderDetailList;
}
