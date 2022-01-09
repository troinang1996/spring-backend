package com.laptrinh.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name ="OrderDetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    @Id
    @Column(name = "Id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "OrderId")
    Order order;
    @ManyToOne
    @JoinColumn(name ="ProductId")
    Product product;
    @Column(name="UnitPrice")
    private Integer unitPrice;
    @Column(name =" Quantity")
    private Integer quantity;
    @Column(name="Discount")
    private Integer discount;

}
