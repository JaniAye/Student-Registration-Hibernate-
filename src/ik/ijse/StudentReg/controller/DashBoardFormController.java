package ik.ijse.StudentReg.controller;

import ik.ijse.StudentReg.bo.BOFactory;
import ik.ijse.StudentReg.bo.custom.courseBO;
import ik.ijse.StudentReg.bo.custom.studentBO;
import ik.ijse.StudentReg.dto.CourseDTO;
import ik.ijse.StudentReg.dto.StudentDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.util.List;

public class DashBoardFormController {

    @FXML
    private AnchorPane root;

    @FXML
    private Label lblun;

    @FXML
    private Label lblcountOFStd;

    @FXML
    private Label lblCountOFCourse;

    public static String un;
    private studentBO studentBO;
    private courseBO courseBO;
    private int count;
    private int countcourse;

    public void initialize() throws Exception {
        count=0;
        countcourse=0;
        if (un!=null){
            lblun.setText(un);
        }
        studentBO= BOFactory.getInstance().getBo(BOFactory.BOType.STUDENT);
        courseBO= BOFactory.getInstance().getBo(BOFactory.BOType.COURSES);
        getstudcount();
        getCountOFCourse();
    }
    public void getstudcount() throws Exception {
        List<StudentDTO> allStudents = studentBO.getAllStudents();
        for (StudentDTO studentDTO:allStudents) {
            count++;
        }

        lblcountOFStd.setText(String.valueOf(count));

    }
    public void getCountOFCourse() throws Exception {
        List<CourseDTO> allcourses = courseBO.getAllCourse();
        for (CourseDTO courseDTO:allcourses) {
            countcourse++;
        }

        lblCountOFCourse.setText(String.valueOf(countcourse));

    }
    public static void setUser(String id){
        un=id;
    }

}
