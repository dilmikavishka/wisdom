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
import lk.ijse.gdse.dto.Guardian;
import lk.ijse.gdse.dto.Student;
import lk.ijse.gdse.model.GuardianModel;
import lk.ijse.gdse.model.StudentModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class UpdateGuardianController implements Initializable {

    public JFXComboBox GuardianCombo;
    public JFXTextField GuardianFirstName;
    public JFXPasswordField GuardianPassword;
    public JFXTextField GuardianLastsName1;
    public JFXTextField GuardianUserName;
    public JFXPasswordField GuardianNIC;
    public JFXButton closebtn;

    public void GuardianComboOnAction(ActionEvent actionEvent) {
        String Guaridanid = (String) GuardianCombo.getSelectionModel().getSelectedItem();
        try {
            Guardian guardian = GuardianModel.getGuaridanDetails(Guaridanid);
            if (guardian != null) {
                GuardianUserName.setText(guardian.getGuardian_User_Name());
                GuardianFirstName.setText(guardian.getGuardian_First_Name());
                GuardianLastsName1.setText(guardian.getGuardian_Last_Name());
                GuardianPassword.setText(guardian.getGuardian_Password());
                GuardianNIC.setText(guardian.getGuardian_NIC());
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Something happend!!");
        }

    }
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setGuardian();
    }

    private void setGuardian() {
        try {
            List<String> ids = GuardianModel.getguardianids();
            ObservableList<String> obList = FXCollections.observableArrayList();

            for (String id : ids) {
                obList.add(id);
            }
            GuardianCombo.setItems(obList);

        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }

    public void GuardianUpdateOnAction(ActionEvent actionEvent) {
        Guardian guardian = new Guardian((String)GuardianCombo.getValue(),GuardianFirstName.getText(),GuardianLastsName1.getText(),GuardianUserName.getText(),GuardianPassword.getText(),GuardianNIC.getText(), GuardianCombo.getId());
        //Student student = new Student((String) ComboStudent1.getValue(),FirstName.getText(),txtLastName.getText(),txtUserName.getText(),txtPassword.getText());
        try {
            boolean isUpdated = GuardianModel.guardianupdate(guardian);
            //new Alert(Alert.AlertType.CONFIRMATION,"Student Updated");
            if (isUpdated ){

                new Alert(Alert.AlertType.CONFIRMATION,"Guardian" +" " +guardian.getGuardian_User_Name()+ " "+ "Updated").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //new Alert(Alert.AlertType.CONFIRMATION,"Student Updated");
        }
    }

    public void CloseBtnOnAction(ActionEvent actionEvent) {
        Stage window = (Stage) closebtn.getScene().getWindow();
        window.close();
    }

}
