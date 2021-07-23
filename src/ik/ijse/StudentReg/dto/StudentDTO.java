package ik.ijse.StudentReg.dto;

public class StudentDTO {
    private String sid;
    private String sname;
    private String address;
    private int phone;
    private String date;
    private String gender;

    public StudentDTO(String sid) {
        this.sid = sid;
    }

    public StudentDTO() {
    }

    public StudentDTO(String sid, String sname, String address, int phone, String date, String gender) {
        this.setSid(sid);
        this.setSname(sname);
        this.setAddress(address);
        this.setPhone(phone);
        this.setDate(date);
        this.setGender(gender);
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
