package lk.ijse.gdse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import lk.ijse.gdse.dto.Password;
import lk.ijse.gdse.dto.User;

import java.awt.desktop.QuitResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//public JFXTextField UserName ;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextField;
import lk.ijse.gdse.model.UserModel;
import lk.ijse.gdse.smtp.Mail;

import javax.swing.*;


public class LoginFormController  {


    public ImageView img;
    public JFXButton Sign_In;

    @FXML
    private JFXTextField UserName;

    @FXML
    private JFXTextField Password;

    private Connection connection;

//    public void initialize() {
//        // initialize the database connection
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "Username", "Password");
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//    }




    public void BtnSignOnAction(ActionEvent actionEvent) throws IOException, SQLException {
        String userName = UserName.getText();
        String password = Password.getText();

        boolean isValid = UserModel.check(userName,password);
        if(isValid) {
            this.login();
        }else {
            new Alert(Alert.AlertType.ERROR,"Incorrect User name or Password !!!").show();
        }
//        if (userName.isEmpty() || password.isEmpty()) {
//
//            new Alert(Alert.AlertType.ERROR,"Please Type Username and Password !!!").show();
//        }
    }
    private  void login() throws IOException {
        Stage window = (Stage) img.getScene().getWindow();
        //Stage stage = new Stage();
       window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashBoardForm.fxml"))));
        //stage.show();
        window.centerOnScreen();
        new Alert(Alert.AlertType.CONFIRMATION,"Sucessfully Loged").show();
//        Mail mail = new Mail();
//        mail.setMsg("Welcome -Welcome to the Wisdom Student Management System");
//        mail.setTo("raycooray32@gmail.com");
//        mail.setSubject("Wisdom Login");

//        Thread thread = new Thread(mail);
//        thread.start();

//        String userInputEmail = this.UserName.getText();
//        String username = UserName.getText();
//        String password =Password.getText();



    }


    public void BtnSignUpOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage)img.getScene().getWindow();
        //Stage stage = new Stage();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/SignUpForm.fxml"))));
        //stage.show();
        window.centerOnScreen();
    }

    public void HomeBtnOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage)img.getScene().getWindow();
        //Stage stage = new Stage();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/homeform.fxml"))));
        //stage.show();
        window.centerOnScreen();

    }


    public void PwOnAction(ActionEvent actionEvent) {
        Sign_In.fire();
    }

    public void User_NameOnAction(ActionEvent actionEvent) {
        Password.requestFocus();
    }

    public void ClosebtnOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }
}
