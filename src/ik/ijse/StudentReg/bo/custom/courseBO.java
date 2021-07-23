package ik.ijse.StudentReg.bo.custom;

import ik.ijse.StudentReg.bo.SuperBO;
import ik.ijse.StudentReg.dto.CourseDTO;
import ik.ijse.StudentReg.dto.StudentDTO;

import java.util.List;

public interface courseBO extends SuperBO {
    public boolean addCourse(CourseDTO courseDTO)throws Exception;
    public boolean deleteCourse(String id)throws Exception;
    public boolean updateCourse(CourseDTO courseDTO)throws Exception;
    public CourseDTO getCourse(String id)throws Exception;
    public List<CourseDTO> getAllCourse()throws Exception;

    public String genCid() throws Exception;
    public List<String> getAllIDS() throws Exception;
}
