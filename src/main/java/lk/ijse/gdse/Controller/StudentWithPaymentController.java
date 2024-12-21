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
import lk.ijse.gdse.dto.Payment;
import lk.ijse.gdse.dto.Student;
import lk.ijse.gdse.model.StudentModel;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class StudentWithPaymentController implements Initializable {
    public JFXButton Closebtn;
    public JFXTextField Payment_Amount;
    public JFXTextField Payment_UserName1;
    public JFXTextField Payment_Name;
    public JFXTextField Payment_Date1;
    public JFXTextField Payment_Date;
    public JFXTextField PaymentId;
    public JFXComboBox StudentCombo;
    public JFXTextField id;
    public JFXTextField txtUserName;
    public JFXTextField txtLastName;
    public JFXPasswordField txtPassword;
    public JFXTextField FirstName;

    public void SaveStudentOnAction(ActionEvent actionEvent) {
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
                new Alert(Alert.AlertType.CONFIRMATION,"Information Saved", ButtonType.OK);
            }else{
                new Alert(Alert.AlertType.WARNING,"Try again", ButtonType.OK);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /////////////////////////////////////////////////////////////////////////////////////////
        Payment payment = new Payment(PaymentId.getText(),Payment_Date.getText(),Payment_Date1.getText(),Payment_Name.getText(),Payment_UserName1.getText(),(String) StudentCombo.getValue(),Payment_Amount.getText());
        try{
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("INSERT INTO payment "+" VALUES (?,?,?,?,?,?,?)");
            pstm.setString(1,payment.getPayment_id());
            pstm.setString(2,payment.getPayment_date());
            pstm.setString(3,payment.getPayment_Time());
            pstm.setString(4,payment.getPayment_Amount());
            pstm.setString(5,payment.getPayment_Holders_Name());
            pstm.setString(6,payment.getPayment_Holders_UserName());
            pstm.setString(7,payment.getStudent_id());
            int affected;
            affected = pstm.executeUpdate();
            if (affected>0){
                new Alert(Alert.AlertType.CONFIRMATION,"Saved", ButtonType.OK).show();
            }else{
                new Alert(Alert.AlertType.WARNING,"Try again", ButtonType.OK).show();
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void StudentComboOnAction(ActionEvent actionEvent) {

    }

    public void CloseBtnOnAction(ActionEvent actionEvent) {
        Stage window = (Stage) Closebtn.getScene().getWindow();
        window.close();
    }

    private void setStudentID() {
        try {
            List<String> ids = StudentModel.getIds();
            ObservableList<String> obList = FXCollections.observableArrayList();

            for (String id : ids) {
                obList.add(id);
            }
            StudentCombo.setItems(obList);

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
