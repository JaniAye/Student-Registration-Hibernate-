package ik.ijse.StudentReg.dao.custom.impl;

import ik.ijse.StudentReg.dao.custom.LoginDAO;
import ik.ijse.StudentReg.entity.Registration;
import ik.ijse.StudentReg.entity.User;
import ik.ijse.StudentReg.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class LoginDAOImpl implements LoginDAO {
    @Override
    public boolean add(User entity) throws Exception {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(User entity) throws Exception {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public User find(String s) throws Exception {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        User user = session.get(User.class, s);
        transaction.commit();
        session.close();

            return user;

    }

    @Override
    public List<User> findAll() throws Exception {
        return null;
    }
}
