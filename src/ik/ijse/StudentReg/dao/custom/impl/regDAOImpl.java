package ik.ijse.StudentReg.dao.custom.impl;

import ik.ijse.StudentReg.dao.custom.regDAO;
import ik.ijse.StudentReg.entity.Course;
import ik.ijse.StudentReg.entity.Registration;
import ik.ijse.StudentReg.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class regDAOImpl implements regDAO {
    @Override
    public boolean add(Registration entity) throws Exception {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Integer integer) throws Exception {
        return false;
    }


    @Override
    public boolean update(Registration entity) throws Exception {
        return false;
    }


    @Override
    public Registration find(Integer integer) throws Exception {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Registration registration = session.get(Registration.class, integer);
        transaction.commit();
        session.close();
        if (registration!=null){
            return registration;
        }
        return null;
    }

    @Override
    public List<Registration> findAll() throws Exception {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        List list = session.createCriteria(Registration.class).list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public int getLastNo() throws Exception {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        NativeQuery quary=session.createSQLQuery("Select regNo from registration ORDER by regNo desc limit 1");
        int rst =(int) quary.uniqueResult();
        transaction.commit();

        if (rst>0){
            return rst;
        }else {
            return 0;
        }

    }
}
