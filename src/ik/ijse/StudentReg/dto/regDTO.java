package ik.ijse.StudentReg.dto;

public class regDTO {
    private int regNO;
    private String regDate;
    private double regFee;
   private StudentDTO studentDTO;
   private  CourseDTO courseDTO;

    public regDTO() {
    }

    public regDTO(int regNO, String regDate, double regFee, StudentDTO studentDTO, CourseDTO courseDTO) {
        this.regNO = regNO;
        this.regDate = regDate;
        this.regFee = regFee;
        this.studentDTO = studentDTO;
        this.courseDTO = courseDTO;
    }

    public int getRegNO() {
        return regNO;
    }

    public void setRegNO(int regNO) {
        this.regNO = regNO;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public double getRegFee() {
        return regFee;
    }

    public void setRegFee(double regFee) {
        this.regFee = regFee;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public CourseDTO getCourseDTO() {
        return courseDTO;
    }

    public void setCourseDTO(CourseDTO courseDTO) {
        this.courseDTO = courseDTO;
    }
}
