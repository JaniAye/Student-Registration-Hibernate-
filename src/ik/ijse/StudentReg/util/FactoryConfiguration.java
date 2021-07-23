package ik.ijse.StudentReg.util;


import ik.ijse.StudentReg.entity.Course;
import ik.ijse.StudentReg.entity.Registration;
import ik.ijse.StudentReg.entity.Student;
import ik.ijse.StudentReg.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FactoryConfiguration {

    private static FactoryConfiguration factoryConfiguration;
   private Properties properties ;
    private SessionFactory sessionFactory;
   private FactoryConfiguration(){
       properties=new Properties();
       try {
           properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("ConfigProp.properties"));
           sessionFactory=new Configuration().mergeProperties(properties)
                   .addAnnotatedClass(Student.class)
                   .addAnnotatedClass(Course.class)
                   .addAnnotatedClass(Registration.class)
                   .addAnnotatedClass(User.class)
                   .buildSessionFactory();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
    public static FactoryConfiguration getInstance(){
        return factoryConfiguration==null?factoryConfiguration=new FactoryConfiguration():factoryConfiguration;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }


}
