package ik.ijse.StudentReg.bo.custom;

import ik.ijse.StudentReg.bo.SuperBO;
import ik.ijse.StudentReg.dto.CourseDTO;
import ik.ijse.StudentReg.dto.LoginDTO;

import java.util.List;

public interface LoginBO extends SuperBO {
    public boolean addLogin(LoginDTO loginDTO)throws Exception;
    public boolean deleteLogin(String id)throws Exception;
    public boolean updateLogin(LoginDTO loginDTO)throws Exception;
    public LoginDTO getLogin(String id)throws Exception;
    public List<LoginDTO> getAllLogins()throws Exception;
}
