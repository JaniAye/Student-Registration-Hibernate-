package ik.ijse.StudentReg.bo.custom;

import ik.ijse.StudentReg.bo.SuperBO;
import ik.ijse.StudentReg.dto.StudentDTO;
import ik.ijse.StudentReg.dto.joinDTO;

import java.util.List;

public interface studentBO extends SuperBO {
    public boolean addStudents(StudentDTO std)throws Exception;
    public boolean deleteStudents(String id)throws Exception;
    public boolean updateStudents(StudentDTO std)throws Exception;
    public StudentDTO getStudent(String id)throws Exception;
    public List<StudentDTO> getAllStudents()throws Exception;

    public List<String> getAllIDs()throws Exception;
    public String getCustID()throws Exception;
    public List<StudentDTO> getJoins(String code)throws Exception;


}
