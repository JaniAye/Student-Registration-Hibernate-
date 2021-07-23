package ik.ijse.StudentReg.bo;

import ik.ijse.StudentReg.bo.custom.impl.CourseBOImpl;
import ik.ijse.StudentReg.bo.custom.impl.LoginBOImpl;
import ik.ijse.StudentReg.bo.custom.impl.RegBOImpl;
import ik.ijse.StudentReg.bo.custom.impl.StudentBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance(){
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }
    public enum BOType {
        STUDENT,COURSES,REG,LOGIN
    }
    public <T extends SuperBO> T getBo(BOType boType){
        switch (boType){
            case REG:return(T) new RegBOImpl();
            case COURSES:return (T) new CourseBOImpl();
            case STUDENT:return (T) new StudentBOImpl();
            case LOGIN:return (T) new LoginBOImpl();
            default:return null;

        }
    }
}
