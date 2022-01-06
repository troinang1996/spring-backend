package com.laptrinh.spring.responsitory;

import com.laptrinh.spring.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductReponsitory {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        String hql = " FROM Product";
        TypedQuery<Product> query = session.createQuery(hql,Product.class);
        List<Product> pros = query.getResultList();
        return pros;
    }


}
