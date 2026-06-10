package com.slide1.Util;



import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
// import javax.persistence.EntityManager;
// import javax.persistence.EntityManagerFactory;
// import javax.persistence.Persistence;

public class DbConnector {
    public static EntityManagerFactory emf;
    public static EntityManager em;
    public static EntityManager init() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("demo");
        }
        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
        }
        return em;
    }
    public static void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }


}
