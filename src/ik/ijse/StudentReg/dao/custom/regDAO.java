package ik.ijse.StudentReg.dao.custom;

import ik.ijse.StudentReg.dao.SuperDAO;
import ik.ijse.StudentReg.entity.Registration;
import ik.ijse.StudentReg.entity.joinEntity;

public interface regDAO extends SuperDAO<Registration,Integer> {
    public int getLastNo()throws Exception;


}
