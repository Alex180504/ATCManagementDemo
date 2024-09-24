package com.example.atcmanagement;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.*;
public class DBConnect {
    public static Connection getConn() throws ClassNotFoundException {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/telephony","root","QWERTY12345qwerty");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static SessionFactory getSession() {
        SessionFactory sessionFactory;
        // configures settings from hibernate.cfg.xml
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            return sessionFactory;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static SessionFactory sessionFactory;

}
