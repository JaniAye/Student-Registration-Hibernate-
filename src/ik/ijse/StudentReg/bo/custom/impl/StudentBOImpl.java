package ik.ijse.StudentReg.bo.custom.impl;

import ik.ijse.StudentReg.bo.custom.studentBO;
import ik.ijse.StudentReg.dao.DAOFactory;
import ik.ijse.StudentReg.dao.custom.studentDAO;
import ik.ijse.StudentReg.dto.StudentDTO;
import ik.ijse.StudentReg.dto.joinDTO;
import ik.ijse.StudentReg.entity.Student;
import ik.ijse.StudentReg.entity.joinEntity;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements studentBO {

    studentDAO studentDAO =DAOFactory.getInstance().getDAO(DAOFactory.DAOType.Student);
    @Override
    public boolean addStudents(StudentDTO std) throws Exception {
        return studentDAO.add(new Student(std.getSid(),
                std.getSname(),
                std.getAddress(),std.getPhone(),std.getDate(),std.getGender()));
    }

    @Override
    public boolean deleteStudents(String id) throws Exception {
       return studentDAO.delete(id);
    }

    @Override
    public boolean updateStudents(StudentDTO std) throws Exception {
        return studentDAO.update(new Student(std.getSid(),std.getSname(),std.getAddress(),std.getPhone(),
                std.getDate(),std.getGender()));
    }

    @Override
    public StudentDTO getStudent(String id) throws Exception {
        Student student = studentDAO.find(id);
        if (student!=null) {
            return new StudentDTO(student.getId(), student.getName(), student.getAddress(), student.getContact(),
                    student.getDob(), student.getGender());
        }
        return null;
    }

    @Override
    public List<StudentDTO> getAllStudents() throws Exception {
        List<Student> list=studentDAO.findAll();
        List<StudentDTO> studlist=new ArrayList<>();
        for (Student std :list
             ) {
            studlist.add(new StudentDTO(std.getId(),std.getName(),std.getAddress(),std.getContact(),std.getDob(),std.getGender()));
        }
        return studlist;
    }

    @Override
    public List<String> getAllIDs() throws Exception {
        List<String> allSid = studentDAO.getAllSid();
        return allSid;
    }

    @Override
    public String getCustID() throws Exception {
        String lastID = studentDAO.getSid();
        if (lastID == null) {
            return "S001";
        }
        int newID = Integer.parseInt(lastID.substring(1, 4)) + 1;

        if (newID < 10) {
            return "S00" + newID;
        } else if (newID < 100) {
            return "S0" + newID;
        } else {
            return "S" + newID;
        }
    }

    @Override
    public List<StudentDTO> getJoins(String code) throws Exception {
        List<Student> joins = studentDAO.getJoins(code);
        List<StudentDTO> dto=new ArrayList<>();
        for (Student enty:joins) {
            dto.add(new StudentDTO(enty.getId(),enty.getName(),enty.getAddress(),enty.getContact(),enty.getDob(),enty.getGender()));
        }
        return dto;
    }
}
