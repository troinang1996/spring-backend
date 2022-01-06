package com.laptrinh.spring.responsitory;

import com.laptrinh.spring.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AccountRepository {

    @Autowired
    SessionFactory sessionFactory;

    public Customer findByUsername(String username){
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.find(Customer.class, username);
        return customer!= null && customer.getFullName().length()>0 ? customer : null;

    }
    public List<Customer> getAll(){
        String hql = "FROM Customers"
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
        List<Customer> customerList = query.getResultList();
        return customerList;

    }
}
