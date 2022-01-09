package com.laptrinh.spring.service;

import com.laptrinh.spring.dto.Response.OrderResponse;
import com.laptrinh.spring.entity.Order;
import com.laptrinh.spring.responsitory.OrderReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderReponsitory orderReponsitory;
    public OrderResponse[] getAllOrder(){
        List<OrderResponse> orderResponseList = new ArrayList<>();
        List<Order> orderList = orderReponsitory.getAllOrder();
        orderList.stream().forEach(x->{
            OrderResponse orderResponse = new OrderResponse();
            orderResponse.setId(x.getId());
            orderResponse.setCustomer(x.getCustomer());
            orderResponse.setOrderDate(x.getOrderDate());
            orderResponse.setAddress(x.getAddress());
            orderResponse.setDescription(x.getDescription());
            orderResponse.setAmount(x.getAmount());
            orderResponse.setStatus(x.getStatus());
            orderResponse.setOrderDetailList(x.getOrderDetailList());
            orderResponseList.add(orderResponse);
        });

        return orderResponseList.stream().toArray(OrderResponse[]::new);
    }
}
