package lk.ijse.gdse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import lk.ijse.gdse.db.DBConnection;
import lk.ijse.gdse.dto.Student;
import lk.ijse.gdse.model.StudentModel;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class UpdateStudentController implements Initializable {
    public JFXButton UpdateCloset;
    public JFXComboBox<String> ComboStudent1;
    public JFXTextField FirstName;
    public JFXPasswordField txtPassword;
    public JFXTextField txtLastName;
    public JFXTextField txtUserName;

    public void CloseBtnOnUpdateAction(ActionEvent actionEvent) {
        Stage window = (Stage) UpdateCloset.getScene().getWindow();
        window.close();
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        setStudentID();
    }

    private void setStudentID() {
        try {
            List<String> ids = StudentModel.getIds();
            ObservableList<String> obList = FXCollections.observableArrayList();

            for (String id : ids) {
                obList.add(id);
            }
            ComboStudent1.setItems(obList);

        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }



    public void SaveUpdateOnAction(ActionEvent actionEvent) {
        Student student = new Student((String) ComboStudent1.getValue(),FirstName.getText(),txtLastName.getText(),txtUserName.getText(),txtPassword.getText());
        try {
            boolean isUpdated = StudentModel.update(student);
            //new Alert(Alert.AlertType.CONFIRMATION,"Student Updated");
            if (isUpdated ){

                new Alert(Alert.AlertType.CONFIRMATION,"Student Updated").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //new Alert(Alert.AlertType.CONFIRMATION,"Student Updated");
        }
    }

    public void StudentComboOnAction(ActionEvent actionEvent) {
       String id = ComboStudent1.getSelectionModel().getSelectedItem();
        try {
            Student student = StudentModel.getDetails(id);
            if (student != null){
                txtUserName.setText(student.getUserName());
                FirstName.setText(student.getFName());
                txtLastName.setText(student.getLName());
                txtPassword.setText(student.getPassword());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Something happend!!");
        }
    }
}
