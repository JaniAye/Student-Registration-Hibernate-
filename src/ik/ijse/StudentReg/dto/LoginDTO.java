package ik.ijse.StudentReg.dto;

public class LoginDTO {
    private String user;
    private String ps;

    public LoginDTO(String user, String ps) {
        this.user = user;
        this.ps = ps;
    }

    public LoginDTO() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }
}
