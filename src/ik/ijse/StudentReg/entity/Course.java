package ik.ijse.StudentReg.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Course implements SuperEntity {
    @Id
    private String code;
    private String name;
    private double fee;
    private String duaration;
    @OneToMany(mappedBy = "course")
    private List<Registration> registrations;

    public Course() {
    }

    public Course(String code, String name, double fee, String duaration, List<Registration> registrations) {
        this.code = code;
        this.name = name;
        this.fee = fee;
        this.duaration = duaration;
        this.setRegistrations(registrations);
    }

    public Course(String code, String name, double fee, String duaration) {
        this.setCode(code);
        this.setName(name);
        this.setFee(fee);
        this.setDuaration(duaration);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getDuaration() {
        return duaration;
    }

    public void setDuaration(String duaration) {
        this.duaration = duaration;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }
}
