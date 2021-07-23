package ik.ijse.StudentReg.controller;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Formatter;

public class HomePageFormController {

    public Label lbltime;
    public ImageView imgAppCancel;
    public JFXButton btnlogout;
    public JFXButton btnSettings;
    public JFXButton btnHome;
    @FXML
    private JFXButton btnstudent;

    @FXML
    private JFXButton btnCourse;

    @FXML
    private JFXButton btnReg;

    @FXML
    private AnchorPane root;

    public void initialize() throws IOException {
        SimpleDateFormat formatter=new SimpleDateFormat("MM/dd/YYYY");

        lbltime.setText(String.valueOf(LocalDate.now()));
        initiUi("DashBoardForm.fxml");
    }

    @FXML
    void StudentOnAction(ActionEvent event) throws IOException {
        initiUi("StudentForm.fxml");
    }

    @FXML
    void courseOnAction(ActionEvent event) throws IOException {
        initiUi("CoursesForm.fxml");
    }

    @FXML
    void registrationOnAction(ActionEvent event) throws IOException {
        initiUi("RegistrationForm2.fxml");
    }
    private void initiUi(String loc) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/"+loc)));
    }


    public void imgCLoseOnAction(MouseEvent mouseEvent) {
        System.exit(0);
    }

    public void LogOutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/loginForm.fxml"))));
        stage.centerOnScreen();
    }

    public void SettingOnAction(ActionEvent actionEvent) throws IOException {
        initiUi("ChangePassswrodForm.fxml");
    }

    public void HomeOnAction(ActionEvent actionEvent) throws IOException {
        initiUi("DashBoardForm.fxml");
    }
}
