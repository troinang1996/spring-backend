package com.laptrinh.spring.responsitory;

import com.laptrinh.spring.dto.BaseDto;
import com.laptrinh.spring.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CategoryReponsitory {
    @Autowired
    SessionFactory sessionFactory;

    public List<Category> getAllCategory() {
        Session session = sessionFactory.getCurrentSession();
        String hql = " FROM Category";
        TypedQuery<Category> query = session.createQuery(hql, Category.class);
        List<Category> categories = query.getResultList();
        return categories;
    }
    public String insertCategory(Category category){
        String s = "succes";
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(category);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            s="fail";
        }
        return s;
    }
    public String deleteCategory(Category category){
        String s= "succes";
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(category);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            s="fail";
        }
        return s;
    }
    public Category findCategoryById(Integer id){
        Session session = sessionFactory.getCurrentSession();
        Category category = session.find(Category.class, id);
        return  category;
    }
    public String updateCategory(Category category){
        String s= "succes";
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(category);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            s="fail";
        }
        return s;
    }
}
