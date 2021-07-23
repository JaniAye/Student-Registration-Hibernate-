package ik.ijse.StudentReg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Registration  implements SuperEntity{
    @Id
    private int regNo;
    private String regdate;
    private double regfee;
    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;
    @ManyToOne(cascade = CascadeType.ALL)
    private Course course;

    public Registration() {
    }

    public Registration(int regNo, String regdate, double regfee, Student student, Course course) {
        this.setRegNo(regNo);
        this.setRegdate(regdate);
        this.setRegfee(regfee);
        this.setStudent(student);
        this.setCourse(course);
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public double getRegfee() {
        return regfee;
    }

    public void setRegfee(double regfee) {
        this.regfee = regfee;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
