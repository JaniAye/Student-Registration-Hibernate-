package ik.ijse.StudentReg.dto;

public class CourseDTO {
    private String code;
    private String cname;
    private double fee;
    private String duration;

    public CourseDTO() {
    }

    public CourseDTO(String code, String cname, double fee, String duration) {
        this.setCode(code);
        this.setCname(cname);
        this.setFee(fee);
        this.setDuration(duration);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
