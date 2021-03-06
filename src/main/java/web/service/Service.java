package web.service;

import web.model.User;

import java.util.List;

public interface Service {
    List<User> getAllUsers();
    User getUserById(int id);
    void addUser(User user);
    void deleteUser(int id);
    void upDateUser(User user);
}
