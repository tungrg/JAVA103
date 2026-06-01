package com.slide1.Util;



import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DbConnector {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    public static EntityManager getConnection() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("demo");
        }
        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
        }
        return em;
    }


}
