package com.laptrinh.spring.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@PropertySource("classpath:db.properties")
public class HibernateConfig {
    @Autowired
    Environment env;


    @Primary // nếu có 2 bean cùng kiểu trả về , thì phuognw thức nào đặt Primary thì phương thức đó đc ưu tiên lấy
    @Bean()  // đặt id cho bean , muốn lấy bean này ra thì dùng @Qualifier
    public DataSource getDataSource1() {
        System.out.println("DataSource");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        return dataSource;
    }


    @Bean
    @Autowired
    public SessionFactory getSessionFactory(DataSource dataSource) throws IOException {
        System.out.println("SessionFactory");
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setPackagesToScan(new String[] {"com.laptrinh.spring.entity"});
        factoryBean.setDataSource(dataSource);
        Properties props = factoryBean.getHibernateProperties();
        props.put("hibernate.dialect", env.getProperty("hb.dialect"));
        props.put("hibernate.show_sql", env.getProperty("hb.show-sql"));
        props.put("current_session_context_class", env.getProperty("hb.session"));
        factoryBean.afterPropertiesSet();
        SessionFactory sessionFactory = factoryBean.getObject();
        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        System.out.println("HibernateTransactionManager");
        return new HibernateTransactionManager(sessionFactory);
    }
}
