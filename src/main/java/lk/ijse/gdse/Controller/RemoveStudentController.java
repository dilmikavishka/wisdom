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
import javafx.stage.Stage;
import lk.ijse.gdse.dto.Student;
import lk.ijse.gdse.model.StudentModel;


import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class RemoveStudentController implements Initializable {

    public JFXButton RemoveClose;
    public JFXComboBox ComboStudentREmove;
    public JFXTextField txtUserName;
    public JFXTextField txtLastName;
    public JFXPasswordField txtPassword;
    public JFXTextField FirstName;

    public void CloseBtnOnUpdateAction(ActionEvent actionEvent) {
        Stage window = (Stage) RemoveClose.getScene().getWindow();
        window.close();
    }

    public void RemoveStudentOnAction(ActionEvent actionEvent) {
        Student student = new Student((String) ComboStudentREmove.getValue(),FirstName.getText(),txtLastName.getText(),txtUserName.getText(),txtPassword.getText());
        try {
            boolean isRemove = StudentModel.remove(student);
            if (isRemove ){
                 new Alert(Alert.AlertType.INFORMATION,"Student " + student.getUserName() +" " +"has been removed").show();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void StudentComboOnAction(ActionEvent actionEvent) {
        String id = (String) ComboStudentREmove.getSelectionModel().getSelectedItem();
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


    @Override
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
            ComboStudentREmove.setItems(obList);

        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }
}
