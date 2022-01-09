package com.laptrinh.spring.responsitory;

import com.laptrinh.spring.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrderReponsitory {
    @Autowired
    SessionFactory sessionFactory;
    public List<Order> getAllOrder(){
        String hql="From Orders";
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Order> query = session.createQuery(hql, Order.class);
        List<Order> orderList = query.getResultList();
        return orderList;
    }
}
