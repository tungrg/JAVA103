package com.slide1.Dao;

import java.util.List;

import com.slide1.Entity.User;
import com.slide1.Util.DbConnector;

public class UserDao {
    public void save(User user) {
        try {
            DbConnector.em.getTransaction().begin();
            DbConnector.em.persist(user);
            DbConnector.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (DbConnector.em.getTransaction().isActive()) {
                DbConnector.em.getTransaction().rollback();
            }
        }
    }
    public void update(User user) {
        try {
            DbConnector.em.getTransaction().begin();
            DbConnector.em.merge(user);
            DbConnector.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (DbConnector.em.getTransaction().isActive()) {
                DbConnector.em.getTransaction().rollback();
            }
        }
    }
    public void delete(User user) {
        try {
            DbConnector.em.getTransaction().begin();
            DbConnector.em.remove(DbConnector.em.contains(user) ? user : DbConnector.em.merge(user));
            DbConnector.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (DbConnector.em.getTransaction().isActive()) {
                DbConnector.em.getTransaction().rollback();
            }
        }
    }
    public User findById(long id) {
        return DbConnector.em.find(User.class, id);
    }
    public User findByEmail(String email) {
        try {
            return DbConnector.em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<User> findAll() {
        return DbConnector.em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }
    public User findByUsernameAndPassword(String username, String password) {
        try {
            return DbConnector.em.createQuery(
                "SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
