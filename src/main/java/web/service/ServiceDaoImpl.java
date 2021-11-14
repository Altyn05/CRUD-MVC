package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.dao.Dao;
import web.model.User;

import java.util.List;


@Component
@Transactional
public class ServiceDaoImpl implements Service{

    private Dao dao;

    @Autowired
    public ServiceDaoImpl(Dao dao) {
        this.dao = dao;
    }

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override

    public User getUserById(int id) {
        return dao.getUserById(id);
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        dao.deleteUser(id);
    }

    @Override
    public void upDateUser(User user) {
        dao.upDateUser(user);
    }
}
