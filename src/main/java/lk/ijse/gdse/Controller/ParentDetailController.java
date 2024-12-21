package lk.ijse.gdse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class ParentDetailController {
    public ImageView img7;

    public void BtnBack4OnAction(ActionEvent actionEvent) throws IOException {
        Stage window6 =  (Stage)img7.getScene().getWindow();
        //Stage stage = new Stage();
        window6.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashBoardForm.fxml"))));
        //stage.show();
        window6.centerOnScreen();
    }

    public void AddGurdianBtnOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/AddGuradianFrom.fxml"))));
        stage.getIcons().add(new Image("D:\\Final Project\\src\\main\\resources\\img\\301169643_601572054942155_6845422374024050099_n.jpg"));
        stage.show();
        stage.centerOnScreen();
    }

    public void UpdateGuardianOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/UpdateGuardianForm.fxml"))));
        stage.getIcons().add(new Image("D:\\Final Project\\src\\main\\resources\\img\\301169643_601572054942155_6845422374024050099_n.jpg"));
        stage.show();
        stage.centerOnScreen();
    }

    public void RemoveGuardianOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/RemoveGuaridanForm.fxml"))));
        stage.getIcons().add(new Image("D:\\Final Project\\src\\main\\resources\\img\\301169643_601572054942155_6845422374024050099_n.jpg"));
        stage.show();
        stage.centerOnScreen();
    }

    public void AddGuardianwithStudent(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/AddGuardianWithStudent.fxml"))));
        stage.getIcons().add(new Image("D:\\Final Project\\src\\main\\resources\\img\\301169643_601572054942155_6845422374024050099_n.jpg"));
        stage.show();
        stage.centerOnScreen();
    }
}
