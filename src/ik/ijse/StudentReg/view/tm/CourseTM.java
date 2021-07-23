package ik.ijse.StudentReg.view.tm;

import javafx.scene.control.Button;

public class CourseTM {
    private String code;
    private String cname;
    private double fee;
    private String duration;
    private Button opt;

    public CourseTM() {
    }

    public CourseTM(String code, String cname, double fee, String duration, Button opt) {
        this.code = code;
        this.cname = cname;
        this.fee = fee;
        this.duration = duration;
        this.opt = opt;
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

    public Button getOpt() {
        return opt;
    }

    public void setOpt(Button opt) {
        this.opt = opt;
    }
}
