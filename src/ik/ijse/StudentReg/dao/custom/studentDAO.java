package ik.ijse.StudentReg.dao.custom;

import ik.ijse.StudentReg.dao.SuperDAO;
import ik.ijse.StudentReg.entity.Student;
import ik.ijse.StudentReg.entity.joinEntity;

import java.util.List;

public interface studentDAO extends SuperDAO<Student, String> {
    public String getSid()throws  Exception;
    public List<String> getAllSid()throws  Exception;
    public List<Student> getJoins(String code)throws Exception;
}
