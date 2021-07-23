package ik.ijse.StudentReg.bo.custom.impl;

import ik.ijse.StudentReg.bo.custom.courseBO;
import ik.ijse.StudentReg.dao.DAOFactory;
import ik.ijse.StudentReg.dao.custom.courseDAO;
import ik.ijse.StudentReg.dao.custom.studentDAO;
import ik.ijse.StudentReg.dto.CourseDTO;
import ik.ijse.StudentReg.dto.StudentDTO;
import ik.ijse.StudentReg.entity.Course;
import ik.ijse.StudentReg.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseBOImpl  implements courseBO {

    courseDAO courseDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOType.Course);
    @Override
    public boolean addCourse(CourseDTO courseDTO) throws Exception {
      return courseDAO.add(new Course(courseDTO.getCode(),courseDTO.getCname(),courseDTO.getFee(),
               courseDTO.getDuration()));
    }

    @Override
    public boolean deleteCourse(String id) throws Exception {
       return courseDAO.delete(id);
    }

    @Override
    public boolean updateCourse(CourseDTO courseDTO) throws Exception {
        return courseDAO.update(new Course(courseDTO.getCode(),courseDTO.getCname(),courseDTO.getFee(),
                courseDTO.getDuration()));
    }

    @Override
    public CourseDTO getCourse(String id) throws Exception {
        Course course = courseDAO.find(id);
        if (course!=null){
            return new CourseDTO(course.getCode(),course.getName(),course.getFee(),course.getDuaration());
        }
        return null;
    }

    @Override
    public List<CourseDTO> getAllCourse() throws Exception {
        List<Course> list= courseDAO.findAll();
        List<CourseDTO> courseLst=new ArrayList<>();
        for (Course ctd :list
        ) {
            courseLst.add(new CourseDTO(ctd.getCode(),ctd.getName(),ctd.getFee(),ctd.getDuaration()));
        }
        return courseLst;
    }

    @Override
    public String genCid() throws Exception {
        String lastID = courseDAO.getCourseID();
        if (lastID == null) {
            return "C001";
        }
        int newID = Integer.parseInt(lastID.substring(1, 4)) + 1;

        if (newID < 10) {
            return "C00" + newID;
        } else if (newID < 100) {
            return "C0" + newID;
        } else {
            return "C" + newID;
        }
    }

    @Override
    public List<String> getAllIDS() throws Exception {
       return courseDAO.getALlCIDS();
    }
}
