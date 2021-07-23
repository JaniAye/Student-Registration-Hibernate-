package ik.ijse.StudentReg.entity;

public class joinEntity {
    private String sid;
    private String ccode;
    private String sname;
    private int phoneNo;
    private String gender;
    private String cname;
    private String regDate;


    public joinEntity(String sid, String ccode, String sname, int phoneNo, String gender, String cname, String regDate) {
        this.sid = sid;
        this.ccode = ccode;
        this.sname = sname;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.cname = cname;
        this.regDate = regDate;
    }

    public joinEntity() {
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
}
