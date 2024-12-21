package lk.ijse.gdse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lk.ijse.gdse.db.DBConnection;
import lk.ijse.gdse.dto.Student;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class AddStudentController implements Initializable {
//    private final static String URL = "jdbc:mysql://localhost:3306/wisdom";
//    private final static Properties props = new Properties();
//
//    static {
//        props.setProperty("user", "root");
//        props.setProperty("password", "1234");
//    }


    public JFXTextField txtId;
    public JFXTextField txtLastName;
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public JFXTextField FirstName;
    public JFXTextField id;
    @FXML
    private JFXButton closebtn;

    @FXML
    void CloseBtnOnAction(ActionEvent event) {
        Stage window = (Stage) closebtn.getScene().getWindow();
        window.close();
    }


     @FXML
     void SaveStudentOnAction(ActionEvent actionEvent)  {
         Student student = new Student(id.getText(),FirstName.getText(),txtLastName.getText(),txtUserName.getText(),txtPassword.getText());
         try {
             Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement pstm = connection.prepareStatement("INSERT INTO student "+" VALUES (?,?,?,?,?)");
             pstm.setString(1,student.getId());
             pstm.setString(2,student.getFName());
             pstm.setString(3,student.getLName());
             pstm.setString(4,student.getUserName());
             pstm.setString(5,student.getPassword());
             int affected = pstm.executeUpdate();
             if (affected>0){
                 new Alert(Alert.AlertType.CONFIRMATION,"Saved", ButtonType.OK).show();
             }else{
                 new Alert(Alert.AlertType.WARNING,"Try again", ButtonType.OK).show();
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}



