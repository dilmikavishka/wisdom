package lk.ijse.gdse.Controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller extends Application {
    public ImageView img1;

    public static void main(String[] args) {
    launch(args);
    }

    @Override
    public void start(Stage primarystage) throws Exception {
        primarystage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/homeform.fxml"))));
        primarystage.show();
        primarystage.centerOnScreen();
        //primarystage.getIcons().add(new Image("img/icons8-login-rounded-64));
        //primarystage.getIcons().add(new Image("D:\\Final Project\\src\\main\\resources\\img\\301169643_601572054942155_6845422374024050099_n.jpg"));
        primarystage.setTitle("Get Started");


    }

    public void BtnLoginOnAction(ActionEvent actionEvent) throws IOException {
        Stage window1 = (Stage)img1.getScene().getWindow();
       // Stage stage = new Stage();
        window1 .setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/LoginForm.fxml"))));
        //stage.show()
        window1.centerOnScreen();
        window1.setTitle("Login");


    }


}
