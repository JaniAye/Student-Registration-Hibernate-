package ik.ijse.StudentReg.dao.custom.impl;

import ik.ijse.StudentReg.dao.custom.courseDAO;
import ik.ijse.StudentReg.entity.Course;
import ik.ijse.StudentReg.entity.Student;
import ik.ijse.StudentReg.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class courseDAOImpl implements courseDAO {
    @Override
    public boolean add(Course entity) throws Exception {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public boolean delete(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Course load = session.load(Course.class, s);
        session.delete(load);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Course entity) throws Exception {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Course find(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Course course = session.get(Course.class, s);

        transaction.commit();

        session.close();
        if (course!=null){
            return course;
        }
        return null;
    }

    @Override
    public List<Course> findAll() throws Exception {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        List list = session.createCriteria(Course.class).list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public String getCourseID() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        NativeQuery sqlQuery = session.createSQLQuery("select code from Course order by code desc limit 1");
        String id = (String) sqlQuery.uniqueResult();
        transaction.commit();

        session.close();
        return id;
    }

    @Override
    public List<String> getALlCIDS() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        NativeQuery sqlQuery = session.createSQLQuery("select code from course order by code desc ");
        List list = sqlQuery.list();
        transaction.commit();

        session.close();
        return list;
    }
}
