package com.laptrinh.spring.responsitory;

import com.laptrinh.spring.entity.Category;
import com.laptrinh.spring.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
        String hql = "FROM Product";
        TypedQuery<Product> query = session.createQuery(hql,Product.class);
        List<Product> pros = query.getResultList();
        return pros;
    }
    public Product findProductById(Integer id){
        Session session = sessionFactory.getCurrentSession();
        Product product = session.find(Product.class, id);
        return product;
    }
    public String updateProduct( Product product){
        String s = "succes";
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(product);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            s = "fail";
        }
        return s;
    }
    public String addProduct(Product product){
        String s = "succes";
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            s = "fail";
        }
        return s;

    }
    public String deleteProduct(Product product) {
        String s = "succes";
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(product);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            s = "fail";
        }
        return s;
    }


}
