package lk.ijse.gdse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class TeacherDetailController {
    public ImageView img8;

    public void BtnBackOnAction(ActionEvent actionEvent) throws IOException {
        Stage window6 =  (Stage)img8.getScene().getWindow();
        //Stage stage = new Stage();
        window6.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashBoardForm.fxml"))));
        //stage.show();
        window6.centerOnScreen();

    }

    public void BtnAddTeachersOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/AddTeacherForm.fxml"))));
        stage.getIcons().add(new Image("img/icons8-login-rounded-64.png"));
        stage.show();
        stage.centerOnScreen();

    }

    public void BtnUpdateTeachersOnAction(ActionEvent actionEvent) {


    }

    public void BtnStudentSubjectOnAction(ActionEvent actionEvent) {

    }

    public void BtnClassCapcityOnAction(ActionEvent actionEvent) {

    }

    public void BtnPaymentDetailsOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/MakePaymentForm.fxml"))));
        stage.getIcons().add(new Image("D:\\Final Project\\src\\main\\resources\\img\\301169643_601572054942155_6845422374024050099_n.jpg"));
        stage.show();
        stage.centerOnScreen();
        stage.setTitle("Payments");

    }
}
