package ik.ijse.StudentReg.dao.custom.impl;

import ik.ijse.StudentReg.dao.custom.studentDAO;
import ik.ijse.StudentReg.entity.Student;
import ik.ijse.StudentReg.entity.joinEntity;
import ik.ijse.StudentReg.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class studentDAOImpl implements studentDAO {
    @Override
    public boolean add(Student entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public boolean delete(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student load = session.load(Student.class, s);
        session.delete(load);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Student find(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, s);

        transaction.commit();

        session.close();
        if (student!=null){
            return student;
        }
        return null;
    }

    @Override
    public List<Student> findAll() throws Exception {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        List list = session.createCriteria(Student.class).list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public String getSid() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        NativeQuery sqlQuery = session.createSQLQuery("select id from student order by id desc limit 1");
        String id = (String) sqlQuery.uniqueResult();
        transaction.commit();

        session.close();
        return id;
    }

    @Override
    public List<String> getAllSid() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        NativeQuery sqlQuery = session.createSQLQuery("select id from student order by id desc ");
        List list = sqlQuery.list();
        transaction.commit();

        session.close();
        return list;
        
    }

    @Override
    public List<Student> getJoins(String code) throws Exception {
//        Session session=FactoryConfiguration.getInstance().getSession();
//        Transaction transaction=session.beginTransaction();
//        NativeQuery nativeQuery = session.createNativeQuery("SELECT id,Stdname,address,contact,dob,gender from student s inner join registration r on s.id=r.student_id inner join course c on r.course_code=c.code where c.code=?"+code);
//        List<Student> list = nativeQuery.list();
//        transaction.commit();
//        session.close();
//        List<Student> studentList = new ArrayList<>();
//        Iterator itr = list.iterator();
//        while (itr.hasNext()) {
//            Object[] obj = (Object[]) itr.next();
//            String sId = String.valueOf(obj[0]);
//            String sName = String.valueOf(obj[1]);
//            String sAddress = String.valueOf(obj[2]);
//            int sContact = Integer.parseInt(String.valueOf((obj[3])));
//            String sDob = String.valueOf(obj[4]);
//            String sGender = String.valueOf(obj[5]);
//            studentList.add(new Student(sId, sName, sAddress, sContact, sDob, sGender));
//        }
//        return studentList;


            Session session = FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            Query sqlQuery = session.createNativeQuery("SELECT DISTINCT s.id,s.Stdname,s.address,s.contact,s.dob,s.gender FROM Student s,Registration r,Course c " +
                    "WHERE (c.code=r.course_code && s.id = r.student_id) && c.code = :id");
//        Query query = session.createQuery("SELECT s FROM Student s  join fetch s.registration");
            sqlQuery.setParameter("id", code);

            List<Student> resultList = (List<Student>) sqlQuery.getResultList();

            transaction.commit();
            session.close();

            List<Student> studentList = new ArrayList<>();
            Iterator itr = resultList.iterator();
            while (itr.hasNext()) {
                Object[] obj = (Object[]) itr.next();
                String sId = String.valueOf(obj[0]);
                String sName = String.valueOf(obj[1]);
                String sAddress = String.valueOf(obj[2]);
                int sContact = Integer.parseInt(String.valueOf(obj[3]));
                String sDob = String.valueOf(obj[4]);
                String sGender = String.valueOf(obj[5]);
                studentList.add(new Student(sId, sName, sAddress, sContact, sDob, sGender));
            }
            System.out.println(studentList);
            return studentList;
        }

}
