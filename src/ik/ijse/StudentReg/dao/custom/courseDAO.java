package ik.ijse.StudentReg.dao.custom;

import ik.ijse.StudentReg.dao.SuperDAO;
import ik.ijse.StudentReg.entity.Course;

import java.util.List;

public interface courseDAO extends SuperDAO<Course ,String> {

    public String getCourseID() throws Exception;
    public List<String> getALlCIDS() throws Exception;
}
