package com.laptrinh.spring.dto.Response;

import com.laptrinh.spring.entity.Customer;
import com.laptrinh.spring.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {


    private Integer id;

    Customer customer;

    private Date orderDate;

    private String address;

    private Double amount;

    private String description;

    private Integer status;

    List<OrderDetail> orderDetailList;
}
