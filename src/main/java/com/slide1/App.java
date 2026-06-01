package com.slide1;

import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.text.html.parser.Entity;

import org.mariadb.jdbc.Connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User user = new User("john1.doe@example.com", "johndoe1234", 30, "password");
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
