package ik.ijse.StudentReg.controller;

import com.jfoenix.controls.JFXButton;
import com.sun.scenario.effect.InvertMask;
import ik.ijse.StudentReg.bo.BOFactory;
import ik.ijse.StudentReg.bo.custom.LoginBO;
import ik.ijse.StudentReg.dto.LoginDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {

    public PasswordField txtPassField;
    public JFXButton btnLogin1;
    public JFXButton btnRegister;
    public ImageView imgClose;
    public AnchorPane root;
    @FXML
    private ImageView showPSImg;

    @FXML
    private TextField txtUn;

    @FXML
    private ImageView imgViewPAss;

    @FXML
    private TextField txtPs;

    @FXML
    private JFXButton btnLogin;

    private LoginBO loginBO;

    public void initialize(){
        loginBO= BOFactory.getInstance().getBo(BOFactory.BOType.LOGIN);

    }
    private void clrAll(){
        txtUn.clear();
        txtPassField.clear();
    }

    @FXML
    void LoginOnAction(ActionEvent event) throws Exception {

        LoginDTO login = loginBO.getLogin(txtUn.getText());
        if (login!=null){
            if (login.getPs().equals(txtPassField.getText())){
                FXMLLoader fxmlLoader1=new FXMLLoader(getClass().getResource("../view/ChangePassswrodForm.fxml"));
                Parent root2=fxmlLoader1.load();
                ChangePassswrodFormController changePassswrodForm=fxmlLoader1.getController();
                changePassswrodForm.setUser(txtUn.getText());

                FXMLLoader fxmlLoader2=new FXMLLoader(getClass().getResource("../view/DashBoardForm.fxml"));
                Parent root3=fxmlLoader2.load();
                DashBoardFormController dashBoardFormController=fxmlLoader2.getController();
                dashBoardFormController.setUser(txtUn.getText());

                Stage stage=(Stage) root.getScene().getWindow();
                stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/HomePage.fxml"))));
                stage.centerOnScreen();
            }else {
                new Alert(Alert.AlertType.CONFIRMATION,"Wrong Password...").show();
                txtPs.clear();
                txtPs.requestFocus();
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"Invelid User Name...").show();
            clrAll();
        }


    }

    @FXML
    void showPSOnAction(MouseEvent event) {

    }

    @FXML
    void viewPassWordOnAction(MouseEvent event) {

    }

    public void RegisterOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/CreateLoginForm.fxml"))));
        stage.centerOnScreen();

    }

    public void imgCloseOnAction(MouseEvent mouseEvent) {
        System.exit(0);
    }
}
