package ik.ijse.StudentReg.view.tm;

import javafx.scene.control.Button;

public class StudentTM {
    private String Id;
    private String name;
    private String addres;
    private int phone;
    private String dob;
    private String gender;
    private Button opt;

    public StudentTM() {
    }

    public StudentTM(String id, String name, String addres, int phone, String dob, String gender, Button opt) {
        Id = id;
        this.name = name;
        this.addres = addres;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
        this.opt = opt;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Button getOpt() {
        return opt;
    }

    public void setOpt(Button opt) {
        this.opt = opt;
    }
}
