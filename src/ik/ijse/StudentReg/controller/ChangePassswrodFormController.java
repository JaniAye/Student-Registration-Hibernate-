package ik.ijse.StudentReg.controller;

import com.jfoenix.controls.JFXButton;
import ik.ijse.StudentReg.bo.BOFactory;
import ik.ijse.StudentReg.bo.custom.LoginBO;
import ik.ijse.StudentReg.dto.LoginDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class ChangePassswrodFormController {

    public JFXButton btnChange;
    public JFXButton btnCancel;
    @FXML
    private TextField txtUn;

    @FXML
    private TextField txtOldPs;

    @FXML
    private TextField txtNewPass;

    private  LoginBO loginBO;


    public static String  user;
    public void initialize(){
        loginBO= BOFactory.getInstance().getBo(BOFactory.BOType.LOGIN);

        if (user!=null){
            txtUn.setText(user);
        }
    }
    public void setUser(String id){
        user=id;
    }
    public void ChangeOnAction(ActionEvent actionEvent) throws Exception {
        LoginDTO login = loginBO.getLogin(txtUn.getText());
        if (login.getPs().equals(txtOldPs.getText())){
            boolean b = loginBO.updateLogin(new LoginDTO(txtUn.getText(), txtNewPass.getText()));
            if (b) {
                new Alert(Alert.AlertType.CONFIRMATION, "Password Change Successfully...").show();
                txtOldPs.clear();
                txtNewPass.clear();
            }
        }else {
            new Alert(Alert.AlertType.ERROR, "Old Password is Incorrect...").show();
            txtOldPs.requestFocus();
        }

    }

    public void CancelOnAction(ActionEvent actionEvent) {
        txtNewPass.clear();
        txtOldPs.clear();
    }
}
