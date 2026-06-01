package com.slide1.Dao;

import com.slide1.Entity.User;
import com.slide1.Util.DbConnector;

public class UserDao {
    public void save(User user) {
        try {
            DbConnector.getConnection().getTransaction().begin();
            DbConnector.getConnection().persist(user);
            DbConnector.getConnection().getTransaction().commit();
        } catch (Exception e) {
            DbConnector.getConnection().getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public User findByUsernameAndPassword(String username, String password) {
        try {
            return DbConnector.getConnection()
                    .createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public void delete(User user) {
        try {
            DbConnector.getConnection().getTransaction().begin();
            DbConnector.getConnection().remove(user);
            DbConnector.getConnection().getTransaction().commit();
        } catch (Exception e) {
            DbConnector.getConnection().getTransaction().rollback();
            e.printStackTrace();
        }
    }
    

}
