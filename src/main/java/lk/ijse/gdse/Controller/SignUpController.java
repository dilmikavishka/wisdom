package lk.ijse.gdse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import lk.ijse.gdse.model.UserModel;

import java.io.IOException;
import java.sql.SQLException;

public class SignUpController {
    public ImageView img3;
    public JFXTextField Email_UserName;
    public JFXTextField Password;
    public JFXTextField ReType_Password;


    public void BtnBacktoOnAction(ActionEvent actionEvent) throws IOException {
        Stage window1 = (Stage) img3.getScene().getWindow();
        // Stage stage = new Stage();
        window1.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/LoginForm.fxml"))));
        //stage.show();
        window1.centerOnScreen();
    }

    public void SaveOnAction(ActionEvent actionEvent) {
        String email_username = Email_UserName.getText();
        String passwordtext = Password.getText();
        String reType_passwordText = ReType_Password.getText();

        if (!(passwordtext.equals(reType_passwordText))) {
            new Alert(Alert.AlertType.ERROR, "Password is not matching !!!").show();

        }else {

            boolean isAdded= false;
            try {
                isAdded = UserModel.add(email_username,passwordtext);

            if(isAdded){
                Email_UserName.setText("");
                Password.setText("");
                ReType_Password.setText("");

                new Alert(Alert.AlertType.CONFIRMATION,"User Added !!!").show();
            }else {
                new Alert(Alert.AlertType.ERROR,"User is not Added !!!").show();
            }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR,"User already Added !!!").show();
            }
        }
    }
}
