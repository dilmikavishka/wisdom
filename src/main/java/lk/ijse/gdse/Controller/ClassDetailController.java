package lk.ijse.gdse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



import java.io.IOException;

public class ClassDetailController {
    public ImageView img4;

    public void BtnBackOnAction(ActionEvent actionEvent) throws IOException {
        Stage window3 = (Stage)img4.getScene().getWindow();
        //Stage stage = new Stage();
        window3.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashBoardForm.fxml"))));
        window3.centerOnScreen();
    }
}
