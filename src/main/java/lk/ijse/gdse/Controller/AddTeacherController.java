package lk.ijse.gdse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import lk.ijse.gdse.db.DBConnection;
import lk.ijse.gdse.dto.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddTeacherController {
    public JFXTextField TeacherId;
    public JFXTextField TeacherUserName;
    public JFXTextField TeacherNic;
    public JFXTextField TeacherAge;
    public JFXButton CloseBtn;

    public void SaveButtonOnAction(ActionEvent actionEvent) {
        Teacher teacher = new Teacher(TeacherId.getText(),TeacherUserName.getText(),TeacherNic.getText(),TeacherAge.getText());
        try{
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("INSERT INTO teacher "+" VALUES (?,?,?,?)");
            pstm.setString(1,teacher.getTeacher_id());
            pstm.setString(2,teacher.getTeacher_UserName());
            pstm.setString(3,teacher.getNIC());
            pstm.setString(4,teacher.getAge());
            int affected = pstm.executeUpdate();
            if (affected>0){
                new Alert(Alert.AlertType.CONFIRMATION,"Saved", ButtonType.OK).show();
            }else{
                new Alert(Alert.AlertType.WARNING,"Try again", ButtonType.OK).show();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void CloseBtnOnAction(ActionEvent actionEvent) {
        Stage window = (Stage) CloseBtn.getScene().getWindow();
        window.close();
    }
}
