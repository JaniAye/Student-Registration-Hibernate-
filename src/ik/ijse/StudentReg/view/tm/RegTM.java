package ik.ijse.StudentReg.view.tm;

public class RegTM {

    private int regNo;

    private String sid;
    private String ccode;
    private String sname;
    private int phoneNo;
    private String gender;
    private String cname;
    private String regDate;

    public RegTM() {
    }

    public RegTM(int regNo, String sid, String ccode, String sname, int phoneNo, String gender, String cname, String regDate) {
        this.setRegNo(regNo);
        this.setSid(sid);
        this.setCcode(ccode);
        this.setSname(sname);
        this.setPhoneNo(phoneNo);
        this.setGender(gender);
        this.setCname(cname);
        this.setRegDate(regDate);
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
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
