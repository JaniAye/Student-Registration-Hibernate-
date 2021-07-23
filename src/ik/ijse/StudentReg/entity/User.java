package ik.ijse.StudentReg.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User implements SuperEntity{
    @Id
    private String un;
    private String ps;


    public User() {
    }

    public User(String un, String ps) {
        this.un = un;
        this.ps = ps;

    }

    public String getUn() {
        return un;
    }

    public void setUn(String un) {
        this.un = un;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

}
