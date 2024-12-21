package lk.ijse.gdse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import lk.ijse.gdse.db.DBConnection;
import lk.ijse.gdse.dto.Guardian;
import lk.ijse.gdse.dto.Student;
import lk.ijse.gdse.model.StudentModel;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;


public class AddGuradianController implements Initializable {
//    private final static String URL = "jdbc:mysql://localhost:3306/wisdom";
//    private final static Properties props = new Properties();
//
//    static {
//        props.setProperty("user", "root");
//        props.setProperty("password", "1234");
//    }

    public JFXButton closeBtn;
    public JFXTextField textd1;
    public JFXTextField LastsName1;
    public JFXTextField TxtUserName;
    public JFXTextField id;
    public JFXPasswordField NIC;
    public JFXPasswordField Password;
    public JFXComboBox ComboStudent;


    public void CloseBtnOnAction(ActionEvent actionEvent) throws SQLException {
        Stage window = (Stage) closeBtn.getScene().getWindow();
        window.close();

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
            ComboStudent.setItems(obList);

        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }

    public void SaveGuradianOnAction(ActionEvent actionEvent) {
        Guardian guardian = new Guardian(id.getText(),textd1.getText(),LastsName1.getText(),TxtUserName.getText(),Password.getText(),NIC.getText(),(String)ComboStudent.getValue());

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
                new Alert(Alert.AlertType.CONFIRMATION,"Saved", ButtonType.OK).show();
            }else{
                new Alert(Alert.AlertType.WARNING,"Try again", ButtonType.OK).show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

