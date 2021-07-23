package ik.ijse.StudentReg.bo.custom.impl;

import ik.ijse.StudentReg.bo.custom.LoginBO;
import ik.ijse.StudentReg.dao.DAOFactory;
import ik.ijse.StudentReg.dao.custom.LoginDAO;
import ik.ijse.StudentReg.dto.LoginDTO;
import ik.ijse.StudentReg.entity.User;

import java.util.List;

public class LoginBOImpl implements LoginBO {

    LoginDAO loginDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOType.User);
    @Override
    public boolean addLogin(LoginDTO loginDTO) throws Exception {
        return loginDAO.add(new User(loginDTO.getUser(),loginDTO.getPs()));
    }

    @Override
    public boolean deleteLogin(String id) throws Exception {
        return false;
    }

    @Override
    public boolean updateLogin(LoginDTO loginDTO) throws Exception {
        return loginDAO.update(new User(loginDTO.getUser(),loginDTO.getPs()));
    }

    @Override
    public LoginDTO getLogin(String id) throws Exception {
        User user = loginDAO.find(id);
        if (user!=null){
          return new LoginDTO(user.getUn(), user.getPs());
        }
        return null;

    }

    @Override
    public List<LoginDTO> getAllLogins() throws Exception {
        return null;
    }
}
