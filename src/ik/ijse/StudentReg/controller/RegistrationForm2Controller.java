package ik.ijse.StudentReg.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import ik.ijse.StudentReg.bo.BOFactory;
import ik.ijse.StudentReg.bo.custom.courseBO;
import ik.ijse.StudentReg.bo.custom.regBO;
import ik.ijse.StudentReg.bo.custom.studentBO;
import ik.ijse.StudentReg.dto.CourseDTO;
import ik.ijse.StudentReg.dto.StudentDTO;
import ik.ijse.StudentReg.dto.joinDTO;
import ik.ijse.StudentReg.dto.regDTO;
import ik.ijse.StudentReg.view.tm.RegTM;
import ik.ijse.StudentReg.view.tm.StudentTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RegistrationForm2Controller {

    public TableView tblreg;
    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtRegno;

    @FXML
    private JFXComboBox cmbSid;

    @FXML
    private DatePicker dtpregdate;

    @FXML
    private JFXTextField txtFee;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXComboBox cmbCcode;

    @FXML
    private JFXTextField txtname;

    @FXML
    private JFXTextField txtaddr;

    @FXML
    private JFXTextField txtphoneNo;

    @FXML
    private JFXTextField txtFee1;

    @FXML
    private JFXTextField txtCnAme;

    @FXML
    private JFXTextField txtDuration;

    @FXML
    private JFXTextField txtgender;

    @FXML
    private JFXTextField txtDOB;

    @FXML
    private TableColumn<?, ?> colsid;

    @FXML
    private TableColumn<?, ?> colCode;

    @FXML
    private TableColumn<?, ?> colregNo;

    @FXML
    private TableColumn<?, ?> colstName;

    @FXML
    private TableColumn<?, ?> colPhoneno;

    @FXML
    private TableColumn<?, ?> colgender;

    @FXML
    private TableColumn<?, ?> colcourseName;

    @FXML
    private TableColumn<?, ?> colRegDate;

    @FXML
    private TextField txtSrch;

    @FXML
    private JFXButton btnSearch;

    private regBO reg;
    private ik.ijse.StudentReg.bo.custom.studentBO studentBO;
    private ik.ijse.StudentReg.bo.custom.courseBO courseBO;
    public void initialize() throws Exception {
        reg= BOFactory.getInstance().getBo(BOFactory.BOType.REG);
        studentBO= BOFactory.getInstance().getBo(BOFactory.BOType.STUDENT);
        courseBO= BOFactory.getInstance().getBo(BOFactory.BOType.COURSES);


        loadALl();

        setSIdS();
        setCourseIDs();
        dtpregdate.setValue(LocalDate.now());
        genRegNO();
    }

    public void loadALl() throws Exception {
        colsid.setCellValueFactory(new PropertyValueFactory<>("sid"));
        colCode.setCellValueFactory(new PropertyValueFactory<>("ccode"));
        colregNo.setCellValueFactory(new PropertyValueFactory<>("regNo"));
        colRegDate.setCellValueFactory(new PropertyValueFactory<>("regDate"));
        colstName.setCellValueFactory(new PropertyValueFactory<>("sname"));

        colPhoneno.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        colgender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colcourseName.setCellValueFactory(new PropertyValueFactory<>("cname"));
        ObservableList<RegTM> tms=FXCollections.observableArrayList();
        List<regDTO> aLlRegs = reg.getALlRegs();
        tms.clear();
        for (regDTO dto: aLlRegs) {
            StudentDTO studentDTO=dto.getStudentDTO();
            CourseDTO courseDTO = dto.getCourseDTO();
            tms.add(new RegTM(dto.getRegNO(),studentDTO.getSid(),courseDTO.getCode(),
                    studentDTO.getSname(),studentDTO.getPhone(),studentDTO.getGender(),
                    courseDTO.getCname(),dto.getRegDate()));
        }
        tblreg.setItems(tms);

    }
    public void genRegNO() throws Exception {
        List<regDTO> aLlRegs = reg.getALlRegs();
        if (aLlRegs.isEmpty()){
            txtRegno.setText(String.valueOf(1));
        }else {
            int regNO = reg.getRegNO();
                txtRegno.setText(String.valueOf(regNO));
        }


    }
    public void clrALl() throws Exception {
        cmbSid.setValue("");
        txtname.clear();
        txtaddr.clear();
        txtphoneNo.clear();
        txtDOB.clear();
        txtgender.clear();
        txtSrch.clear();

        cmbCcode.setValue("");
        txtCnAme.clear();
        txtFee1.clear();
        txtDuration.clear();
        txtRegno.clear();
        genRegNO();
        txtFee.clear();
        dtpregdate.setValue(LocalDate.now());

    }
    public void setSIdS() throws Exception {
        List<String> allIDs = studentBO.getAllIDs();
        ObservableList<String> stdIDS=FXCollections.observableArrayList();
        for (String dto:allIDs) {
            stdIDS.add(dto);
        }
        cmbSid.setItems(stdIDS);

    }
    public void setCourseIDs() throws Exception {
        List<String> allIDs = courseBO.getAllIDS();
        ObservableList<String> courseIDS=FXCollections.observableArrayList();
        for (String dto:allIDs) {
            courseIDS.add(dto);
        }
        cmbCcode.setItems(courseIDS);

    }
    public void srch() throws Exception {
        regDTO regdt = this.reg.getReg(Integer.parseInt(txtSrch.getText()));
        if (regdt!=null){
            StudentDTO studentDTO = regdt.getStudentDTO();
            CourseDTO courseDTO = regdt.getCourseDTO();
            StudentDTO student = studentBO.getStudent(studentDTO.getSid());
            CourseDTO course = courseBO.getCourse(courseDTO.getCode());

            cmbSid.setValue(student.getSid());
            txtname.setText(student.getSname());
            txtaddr.setText(student.getAddress());
            txtphoneNo.setText(String.valueOf(student.getPhone()));
            txtDOB.setText(student.getDate());
            txtgender.setText(student.getGender());

            cmbCcode.setValue(course.getCode());
            txtCnAme.setText(course.getCname());
            txtFee1.setText(String.valueOf(course.getFee()));
            txtDuration.setText(course.getDuration());

            txtRegno.setText(String.valueOf(regdt.getRegNO()));
            dtpregdate.setValue(LocalDate.parse(regdt.getRegDate()));
            txtFee.setText(String.valueOf(regdt.getRegFee()));
            System.out.println(regdt.getRegFee());

        }else {
            new Alert(Alert.AlertType.ERROR,"Wrong Registration Number...").show();
        }
    }

    @FXML
    void SearchOnActionn(ActionEvent event) throws Exception {

    }

    @FXML
    void cancelOnAction(ActionEvent event) throws Exception {
        clrALl();
    }

    @FXML
    void courseCodeOnAction(ActionEvent event) throws Exception {

        colsid.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colPhoneno.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colstName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colgender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        CourseDTO course = courseBO.getCourse(cmbCcode.getValue().toString());
        if (course!=null){
            ObservableList<StudentTM> tms=FXCollections.observableArrayList();

            txtCnAme.setText(course.getCname());
            txtFee1.setText(String.valueOf(course.getFee()));
            txtDuration.setText(course.getDuration());

            List<StudentDTO> joins = studentBO.getJoins(cmbCcode.getValue().toString());
            for (StudentDTO dto: joins) {
                Button button=new Button("");
                tms.add(new StudentTM(dto.getSid(),dto.getSname(),dto.getAddress(),
                        dto.getPhone(),dto.getDate(),dto.getGender(),button));
            }
            tblreg.setItems(tms);


        }
    }

    @FXML
    void saveOnAction(ActionEvent event) throws Exception {
        if (btnSave.getText().equalsIgnoreCase("Save")) {
            StudentDTO student = studentBO.getStudent(cmbSid.getValue().toString());
            CourseDTO course = courseBO.getCourse(cmbCcode.getValue().toString());
            boolean regadd = reg.addReg(new regDTO(Integer.parseInt(txtRegno.getText()), dtpregdate.getValue().toString(),
                    Double.parseDouble(txtFee.getText()),
                    student, course));
            if (regadd) {
                new Alert(Alert.AlertType.CONFIRMATION,"Registration Successful..").show();
            }
        }

        clrALl();
        loadALl();
    }

    @FXML
    void studentIDOnAction(ActionEvent event) throws Exception {
        StudentDTO student = studentBO.getStudent(cmbSid.getValue().toString());
        if (student!=null){
            txtname.setText(student.getSname());
            txtaddr.setText(student.getAddress());
            txtphoneNo.setText(String.valueOf(student.getPhone()));
            txtDOB.setText(student.getDate());
            txtgender.setText(student.getGender());
        }
    }

    public void regNoOnAction(ActionEvent actionEvent) {
    }

    public void SearchOnaction(ActionEvent actionEvent) throws Exception {
        srch();
    }

    public void RegistrationnewOnAction(ActionEvent actionEvent) throws Exception {
        genRegNO();
    }

    public void SearchOnActionReleased(KeyEvent keyEvent) throws Exception {
        if (txtSrch.getText().trim().length()==0){
            clrALl();
        }

    }
}
