package ik.ijse.StudentReg.controller;

import com.jfoenix.controls.JFXButton;
import ik.ijse.StudentReg.bo.BOFactory;
import ik.ijse.StudentReg.bo.custom.LoginBO;
import ik.ijse.StudentReg.dto.LoginDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateLoginFormContrller {

    public ImageView imgClose;
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtUn;

    @FXML
    private TextField txtpss;

    @FXML
    private TextField txtFUllName;

    @FXML
    private TextField txtretype;

    @FXML
    private JFXButton btnRegister;

    @FXML
    private JFXButton btnLogin;

    private LoginBO loginBO;

    public void initialize(){
        loginBO= BOFactory.getInstance().getBo(BOFactory.BOType.LOGIN);
    }

    @FXML
    void LoginOnAction(ActionEvent event) throws IOException {
        iniUi("loginForm.fxml");
    }
    private void crlAll(){
        txtUn.clear();
        txtpss.clear();
        txtretype.clear();
    }
    @FXML
    void RegisterOnAction(ActionEvent event) throws Exception {

        LoginDTO login = loginBO.getLogin(txtUn.getText());

        if (login==null){
            String un=txtpss.getText();

            if (un.equals(txtretype.getText())){
                boolean b = loginBO.addLogin(new LoginDTO(txtUn.getText(), txtpss.getText()));
                if (b){
                    new Alert(Alert.AlertType.CONFIRMATION,"Created Successfully...").show();
                    crlAll();
                }else {
                    new Alert(Alert.AlertType.ERROR,"Faild To Create Try Again...").show();
                    crlAll();
                }
            }else {
                new Alert(Alert.AlertType.ERROR,"Password Dissmatch Try Again...").show();
                txtpss.clear();
                txtretype.clear();
                txtpss.requestFocus();
            }

        }else {
            new Alert(Alert.AlertType.ERROR,"This User Name Already Registered...").show();
            txtUn.clear();
            txtUn.requestFocus();
        }



    }
    private void iniUi(String loc) throws IOException {
        Stage stage=(Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/"+loc))));
        stage.centerOnScreen();
    }

    public void imgCloseOnAction(MouseEvent mouseEvent) {

        System.exit(0);
    }
}
