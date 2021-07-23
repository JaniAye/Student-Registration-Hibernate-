package ik.ijse.StudentReg.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import ik.ijse.StudentReg.bo.BOFactory;
import ik.ijse.StudentReg.bo.custom.studentBO;
import ik.ijse.StudentReg.dto.StudentDTO;
import ik.ijse.StudentReg.view.tm.CourseTM;
import ik.ijse.StudentReg.view.tm.StudentTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;

import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class StudentFormController {

    public AnchorPane root;
    public JFXComboBox cmbGender;
    public DatePicker dtp1;
    public TableColumn colSid;
    public TableView tblstudent;
    @FXML
    private JFXTextField txtStudentID;

    @FXML
    private JFXTextField txtname;

    @FXML
    private JFXTextField txtaddr;

    @FXML
    private JFXTextField txtphoneNo;

    @FXML
    private TableColumn colName;

    @FXML
    private TableColumn colAddr;

    @FXML
    private TableColumn colPhone;

    @FXML
    private TableColumn colDOB;

    @FXML
    private TableColumn colGender;

    @FXML
    private TableColumn colOPt;



    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btncancel;

    @FXML
    private ImageView imgHome;

   private studentBO student;
    public void initialize() throws Exception {
        student= BOFactory.getInstance().getBo(BOFactory.BOType.STUDENT);

        colSid.setCellValueFactory(new PropertyValueFactory("Id"));
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colAddr.setCellValueFactory(new PropertyValueFactory("addres"));
        colPhone.setCellValueFactory(new PropertyValueFactory("phone"));
        colDOB.setCellValueFactory(new PropertyValueFactory("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory("gender"));
        colOPt.setCellValueFactory(new PropertyValueFactory("opt"));

        setGender();
        genrateID();
        loadStudents();
        tblstudent.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    setData((StudentTM) newValue);
                });

    }
    private void setData(StudentTM tm) {
        txtname.setText(tm.getName());
        txtphoneNo.setText(String.valueOf(tm.getPhone()));
        txtStudentID.setText(tm.getId());
        txtaddr.setText(tm.getAddres());
        dtp1.setValue(LocalDate.parse(tm.getDob()));
        cmbGender.setValue(tm.getGender());
        btnSave.setText("Update");
    }
    public void  loadStudents() throws Exception {
        List<StudentDTO> allStudents = student.getAllStudents();
        ObservableList<StudentTM> studentTMS = FXCollections.observableArrayList();

        for (StudentDTO stdto:allStudents) {
            Button btn=new Button("Delete");
            studentTMS.add(new StudentTM(stdto.getSid(),stdto.getSname(),stdto.getAddress(),stdto.getPhone(),
                    stdto.getDate(),stdto.getGender(),btn));

            btn.setOnAction(event -> {
                try {

                    ButtonType ok = new ButtonType("OK",
                            ButtonBar.ButtonData.OK_DONE);
                    ButtonType no = new ButtonType("NO",
                            ButtonBar.ButtonData.CANCEL_CLOSE);

                    Alert alert = new Alert(Alert.AlertType.WARNING,
                            "Are You Sure ?", ok, no);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.orElse(no) == ok) {
                        if(student.deleteStudents(stdto.getSid())){
                            clrall();
                            new Alert(Alert.AlertType.CONFIRMATION,
                                    "Deleted", ButtonType.OK).show();
                            loadStudents();
                            return;
                        }
                        new Alert(Alert.AlertType.WARNING,
                                "Try Again", ButtonType.OK).show();
                    } else {

                    }

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });
        }
        tblstudent.setItems(studentTMS);

    }
    public void clrall() throws Exception {
        txtStudentID.clear();
        txtphoneNo.clear();
        txtaddr.clear();
        txtname.clear();
        cmbGender.setValue("");
        dtp1.getEditor().setText("");
        genrateID();
        btnSave.setText("Save");
    }
    public void genrateID() throws Exception {
        String s = null;
        try {
            s = student.getCustID();
        } catch (Exception e) {
            e.printStackTrace();
        }
       txtStudentID.setText(s);
    }
    private void  setGender(){
        ObservableList<String> genders= FXCollections.observableArrayList();
            genders.add("Male");
            genders.add("Female");
        cmbGender.setItems(genders);

    }

    @FXML
    void backOnAction(MouseEvent event) throws IOException {
//        initUi("HomePage.fxml");
    }

    @FXML
    void cancelOnAction(ActionEvent event) throws Exception {
        clrall();
    }

    @FXML
    void saveOnAction(ActionEvent event) throws Exception {

        if (Pattern.compile("^[0-9]{10}$").matcher(txtphoneNo.getText()).matches()) {
            if (txtname.getText().trim().length()>0){
                if (txtname.getText().trim().length()>0){
                    if (dtp1.getValue().toString().trim().length()>0){
                        if (cmbGender.getValue().toString().trim().length()>0){
                            if (btnSave.getText().equalsIgnoreCase("Save")) {
                                StudentDTO student = this.student.getStudent(txtStudentID.getText());
                                if (student==null){

                                    boolean addstudents = this.student.addStudents(new StudentDTO(txtStudentID.getText(),
                                            txtname.getText(), txtaddr.getText(), Integer.parseInt(txtphoneNo.getText()),
                                            dtp1.getValue().toString(), cmbGender.getValue().toString()));
                                    if (addstudents) {
                                        new Alert(Alert.AlertType.CONFIRMATION, "Successfull...").show();
                                        clrall();
                                        loadStudents();
                                    }else {
                                        clrall();
                                        loadStudents();
                                    }
                                }else {
                                    new Alert(Alert.AlertType.ERROR, "Wrong Id for student Try Again...").show();
                                    genrateID();
                                }

                            }else {
                                boolean studentUpdated = student.updateStudents(new StudentDTO(txtStudentID.getText(), txtname.getText(),
                                        txtaddr.getText(), Integer.parseInt(txtphoneNo.getText()),
                                        dtp1.getValue().toString(), cmbGender.getValue().toString()));
                                if (studentUpdated){
                                    new Alert(Alert.AlertType.CONFIRMATION,"Successfully Updated...").show();
                                    clrall();
                                    loadStudents();
                                }else {
                                    clrall();
                                    loadStudents();
                                }
                            }


                        }else {
                            new Alert(Alert.AlertType.ERROR, "Provide All fields...").show();
                        }

                    }else {
                        new Alert(Alert.AlertType.ERROR, "Provide All fields...").show();
                    }

                }else {
                    new Alert(Alert.AlertType.ERROR, "Provide All fields...").show();
                }

            }else {
                new Alert(Alert.AlertType.ERROR, "Provide All fields...").show();
            }

//
//
//

        }else {
            txtphoneNo.requestFocus();
            txtphoneNo.setFocusColor(Paint.valueOf("red"));
        }


    }

    @FXML
    void studentIdOnAction(ActionEvent event) throws Exception {
        StudentDTO student = this.student.getStudent(txtStudentID.getText());
        if (student!=null){
            btnSave.setText("Update");
            txtname.setText(student.getSname());
            txtaddr.setText(student.getAddress());
            txtphoneNo.setText(String.valueOf(student.getPhone()));
            cmbGender.getSelectionModel().select(student.getGender());
            dtp1.setValue(LocalDate.parse(student.getDate()));



        }else {
            btnSave.setText("Save");
        }

    }
    private void initUi(String loc) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/"+loc)));
    }

}
