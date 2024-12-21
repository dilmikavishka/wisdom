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
import lk.ijse.gdse.dto.Guardian;
import lk.ijse.gdse.dto.Student;
import lk.ijse.gdse.model.StudentModel;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class AddGuardianWithStudentController implements Initializable {
    public JFXTextField FirstName;
    public JFXPasswordField txtPassword;
    public JFXTextField txtLastName;
    public JFXTextField txtUserName;
    public JFXTextField id;
    public JFXPasswordField GuardianPassword;
    public JFXTextField GuardianFirstName;
    public JFXTextField GuaridanLastName;
    public JFXTextField GuaridanUSerName;
    public JFXButton closeBtn;
    public JFXTextField GuaridanId;
    public JFXPasswordField GuardianNIc;
    public JFXComboBox ComboStudent;

    public void SaveStudentAndGuardianOnAction(ActionEvent actionEvent)  {
        Guardian guardian = new Guardian(id.getText(),GuaridanId.getText(),GuaridanLastName.getText(),GuaridanUSerName.getText(),GuardianPassword.getText(),GuardianNIc.getText(),(String)ComboStudent.getValue());

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm1 = connection.prepareStatement("INSERT INTO guardian "+" VALUES (?,?,?,?,?,?,?)");
            pstm1.setString(1,guardian.getGuardian_id());
            pstm1.setString(2,guardian.getGuardian_First_Name());
            pstm1.setString(3,guardian.getGuardian_Last_Name());
            pstm1.setString(4,guardian.getGuardian_Password());
            pstm1.setString(5,guardian.getGuardian_User_Name());
            pstm1.setString(6,guardian.getGuardian_NIC());
            pstm1.setString(7,guardian.getStudent_id());
            int affected = pstm1.executeUpdate();
            if (affected>0){
                new Alert(Alert.AlertType.CONFIRMATION,"Saved", ButtonType.OK);
            }else{
                new Alert(Alert.AlertType.WARNING,"Try again", ButtonType.OK).show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /////////////////////////////////////////////////////

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
                new Alert(Alert.AlertType.CONFIRMATION,"Information Saved", ButtonType.OK).show();
            }else{
                new Alert(Alert.AlertType.WARNING,"Try again", ButtonType.OK).show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void CloseBtnOnAction(ActionEvent actionEvent) {
        Stage window = (Stage) closeBtn.getScene().getWindow();
        window.close();
    }
    private void setStudentID() {
        try {
            List<String> ids = StudentModel.getIds();
            ObservableList<String> obList = FXCollections.observableArrayList();

            for (String id : ids) {
                obList.add(id);
            }
            ComboStudent.setItems(obList);

        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setStudentID();
    }
}
