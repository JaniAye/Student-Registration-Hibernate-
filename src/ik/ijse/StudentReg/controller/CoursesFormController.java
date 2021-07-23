package ik.ijse.StudentReg.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import ik.ijse.StudentReg.bo.BOFactory;
import ik.ijse.StudentReg.bo.custom.courseBO;
import ik.ijse.StudentReg.dto.CourseDTO;
import ik.ijse.StudentReg.dto.StudentDTO;
import ik.ijse.StudentReg.view.tm.CourseTM;
import ik.ijse.StudentReg.view.tm.StudentTM;
import javafx.collections.FXCollections;
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
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class CoursesFormController {

    public ImageView imgHome;
    @FXML
    private AnchorPane root;
    @FXML
    private TableColumn colCode;

    @FXML
    private TableColumn colName;

    @FXML
    private TableColumn colFee;

    @FXML
    private TableColumn colDuration;

    @FXML
    private TableColumn colOPt;
    @FXML
    private JFXTextField txtCode;

    @FXML
    private JFXTextField txtFee;

    @FXML
    private JFXTextField txtCnAme;

    @FXML
    private JFXTextField txtDuration;

    @FXML
    private TableView tblCourseDetails;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnCancel;

    private courseBO courseBO;
    public void initialize() throws Exception {
        courseBO=BOFactory.getInstance().getBo(BOFactory.BOType.COURSES);


        colCode.setCellValueFactory(new PropertyValueFactory("code"));
        colName.setCellValueFactory(new PropertyValueFactory("cname"));
        colFee.setCellValueFactory(new PropertyValueFactory("fee"));
        colDuration.setCellValueFactory(new PropertyValueFactory("duration"));
        colOPt.setCellValueFactory(new PropertyValueFactory("opt"));

        genCode();
        loadALl();

        tblCourseDetails.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    setData((CourseTM) newValue);
                });
    }
    private void setData(CourseTM tm) {
        txtCode.setText(tm.getCode());
        txtCnAme.setText(tm.getCname());
        txtDuration.setText(tm.getDuration());
        txtFee.setText(String.valueOf(tm.getFee()));
        btnSave.setText("Update");
    }

    private void loadALl() throws Exception {
        List<CourseDTO> allcourses = courseBO.getAllCourse();
        ObservableList<CourseTM> CTMS = FXCollections.observableArrayList();

        for (CourseDTO cdto:allcourses) {
            Button btn=new Button("Delete");
            CTMS.add(new CourseTM(cdto.getCode(),
                    cdto.getCname(),cdto.getFee(),cdto.getDuration(),btn));

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
                        if(courseBO.deleteCourse(cdto.getCode())){
                            clrall();
                            new Alert(Alert.AlertType.CONFIRMATION,
                                    "Deleted", ButtonType.OK).show();
                            loadALl();
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
        tblCourseDetails.setItems(CTMS);

    }
    public void clrall(){
        txtFee.clear();
        txtDuration.clear();
        txtCnAme.clear();
        txtCode.clear();
        genCode();
        btnSave.setText("Save");
    }

    public void genCode(){
        String s = null;
        try {
            s = courseBO.genCid();
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtCode.setText(s);
    }
    @FXML
    void cancelOnAction(ActionEvent event) {

        clrall();
    }

    @FXML
    void codeOnAction(ActionEvent event) throws Exception {
        CourseDTO course = courseBO.getCourse(txtCode.getText());
        if (course!=null){
            txtCnAme.setText(course.getCname());
            txtDuration.setText(course.getDuration());
            txtFee.setText(String.valueOf(course.getFee()));

            btnSave.setText("Update");

        }else {
            btnSave.setText("Save");
        }

        System.out.println(course.getCname());

    }

    @FXML
    void saveOnAction(ActionEvent event) throws Exception {


            if (txtCnAme.getText().trim().length()>0){
                if (txtFee.getText().trim().length()>0) {
                    if (txtDuration.getText().trim().length()>0){

                        if (btnSave.getText().equalsIgnoreCase("Save")) {
                            CourseDTO course = courseBO.getCourse(txtCode.getText());
                            if (course==null){
                                boolean courseAdd = courseBO.addCourse(new CourseDTO(txtCode.getText(), txtCnAme.getText(), Double.parseDouble(txtFee.getText()),
                                        txtDuration.getText()));

                                if (courseAdd) {
                                    new Alert(Alert.AlertType.CONFIRMATION, "Successfull").show();
                                }else {
                                    new Alert(Alert.AlertType.ERROR, "Invaild Course Code.. Try Again.....").show();
                                }
                            }

                        }
                        else {
                            boolean courseAdd = courseBO.updateCourse(new CourseDTO(txtCode.getText(), txtCnAme.getText(), Double.parseDouble(txtFee.getText()),
                                    txtDuration.getText()));

                            if (courseAdd) {
                                new Alert(Alert.AlertType.CONFIRMATION, "Successfull").show();
                            }
                        }
                        clrall();
                        loadALl();
                    }else {
                        txtDuration.requestFocus();
                        new Alert(Alert.AlertType.ERROR, "Provide All fields...").show();
                    }
                }else {
                    txtFee.requestFocus();
                }
            }else {
                txtCnAme.requestFocus();
                new Alert(Alert.AlertType.ERROR, "Provide All fields...").show();
            }


    }

    public void homeOnAction(MouseEvent mouseEvent) throws IOException {
        initUi("StudentForm.fxml");
    }

    private void initUi(String loc) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/"+loc)));
    }
}
