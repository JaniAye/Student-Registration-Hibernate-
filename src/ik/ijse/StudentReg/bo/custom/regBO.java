package ik.ijse.StudentReg.bo.custom;

import ik.ijse.StudentReg.bo.SuperBO;
import ik.ijse.StudentReg.dto.regDTO;

import java.util.List;

public interface regBO extends SuperBO {
    public boolean addReg(regDTO regDTO)throws Exception;
    public boolean deleteReg(int id)throws Exception;
    public boolean updateReg(regDTO regDTO)throws Exception;
    public regDTO getReg(int id)throws Exception;
    public List<regDTO> getALlRegs()throws Exception;

    public int getRegNO()throws Exception;

}
