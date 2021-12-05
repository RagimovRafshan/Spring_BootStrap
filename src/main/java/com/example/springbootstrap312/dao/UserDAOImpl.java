package com.example.springbootstrap312.dao;

import com.example.springbootstrap312.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList().stream()
                .sorted(Comparator.comparing(User::getFirstName)).collect(Collectors.toList());
    }

    @Override
    public User getUser(long id) {
        return (User) entityManager.createQuery("select u from User u JOIN fetch u.roles where u.id=:id")
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeUser(long id) {
        entityManager.remove(getUser(id));
    }

    @Override
    public void updateUser(long id, User updatedUser) {
        User user = getUser(id);
        user.setFirstName(updatedUser.getFirstName());
        user.setAge(updatedUser.getAge());
        user.setEmail(updatedUser.getEmail());
    }

    @Override
    public User getUserByEmail(String email) {
        return entityManager.createQuery("select u from User u where u.email=:mail", User.class)
                .setParameter("mail", email).getSingleResult();
    }
}
