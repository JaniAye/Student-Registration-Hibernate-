package ik.ijse.StudentReg.dao;

import ik.ijse.StudentReg.dao.custom.impl.LoginDAOImpl;
import ik.ijse.StudentReg.dao.custom.impl.courseDAOImpl;
import ik.ijse.StudentReg.dao.custom.impl.regDAOImpl;
import ik.ijse.StudentReg.dao.custom.impl.studentDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getInstance(){

        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }
    public enum  DAOType{
        Student,Course,Reg,User
    }
    public <T extends SuperDAO> T getDAO(DAOType daoType){
        switch (daoType){
            case Student:
                return(T) new studentDAOImpl();
            case Course:
                return (T) new courseDAOImpl();
            case Reg:
                return (T) new regDAOImpl();
            case User:
                return (T) new LoginDAOImpl();
            default:
                return null;
        }
    }
}
