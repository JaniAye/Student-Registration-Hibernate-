package ik.ijse.StudentReg.bo.custom.impl;

import ik.ijse.StudentReg.bo.custom.regBO;
import ik.ijse.StudentReg.dao.DAOFactory;
import ik.ijse.StudentReg.dao.custom.regDAO;
import ik.ijse.StudentReg.dto.CourseDTO;
import ik.ijse.StudentReg.dto.StudentDTO;
import ik.ijse.StudentReg.dto.regDTO;
import ik.ijse.StudentReg.entity.Course;
import ik.ijse.StudentReg.entity.Registration;
import ik.ijse.StudentReg.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class RegBOImpl  implements regBO {

    ik.ijse.StudentReg.dao.custom.regDAO reg= DAOFactory.getInstance().getDAO(DAOFactory.DAOType.Reg);
    @Override
    public boolean addReg(regDTO regDTO)  {
        StudentDTO studentDTO =regDTO.getStudentDTO();
        Student student=new Student(studentDTO.getSid(),studentDTO.getSname(),studentDTO.getAddress(),studentDTO.getPhone(),
                studentDTO.getDate(),studentDTO.getGender());
        CourseDTO courseDTO=regDTO.getCourseDTO();
        Course course=new Course(courseDTO.getCode(),courseDTO.getCname(),courseDTO.getFee(),courseDTO.getDuration());
        try {
           return reg.add(new Registration(regDTO.getRegNO(),regDTO.getRegDate(),regDTO.getRegFee(),student,course));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteReg(int id) {
        return false;
    }

    @Override
    public boolean updateReg(regDTO regDTO) {
        return false;
    }

    @Override
    public regDTO getReg(int id) throws Exception {
        Registration registration = reg.find(id);
        Student student=registration.getStudent();
        Course course=registration.getCourse();

        StudentDTO studentDTO=new StudentDTO(student.getId(),student.getName(),student.getAddress(),
                student.getContact(),student.getDob(),student.getGender());
        CourseDTO courseDTO=new CourseDTO(course.getCode(),course.getName(),course.getFee(),
                course.getDuaration());
        return new regDTO(registration.getRegNo(),registration.getRegdate(),
                registration.getRegfee(),
                studentDTO,courseDTO);
    }

    @Override
    public List<regDTO> getALlRegs() throws Exception {
        List<Registration> all = reg.findAll();
        List<regDTO> regDTOS=new ArrayList<>();
        for (Registration registration:all) {

            Student student=registration.getStudent();
            Course course=registration.getCourse();

            StudentDTO studentDTO=new StudentDTO(student.getId(),student.getName(),student.getAddress(),
                    student.getContact(),student.getDob(),student.getGender());

            CourseDTO courseDTO=new CourseDTO(course.getCode(),course.getName(),course.getFee(),
                    course.getDuaration());

             regDTOS.add(new regDTO(registration.getRegNo(),registration.getRegdate(),
                    registration.getRegfee(),studentDTO,courseDTO ));
        }
        return regDTOS;

    }

    @Override
    public int getRegNO() throws Exception {
        int lastNo = reg.getLastNo();
        if (lastNo>0){
            return lastNo+1;
        }else {
            return 0;
        }

    }
}
