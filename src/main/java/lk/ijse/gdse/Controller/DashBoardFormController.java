package lk.ijse.gdse.Controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.gdse.db.DBConnection;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

public class DashBoardFormController implements Initializable {
    public ImageView img2;

    @FXML
    private PieChart Dashoard_Pie_Chart;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadDateandTime();
        setPieChartValues();

    }

    public void BtnClassOnAction(ActionEvent actionEvent) throws IOException {
        Stage window3 = (Stage) img2.getScene().getWindow();
        //Stage stage = new Stage();
        window3.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/ClassDetailsForm.fxml"))));
        //stage.show();
        window3.getIcons().add(new Image("D:\\Final Project\\src\\main\\resources\\img\\301169643_601572054942155_6845422374024050099_n.jpg"));
        window3.centerOnScreen();
    }

    public void BtnBack1OnAction(ActionEvent actionEvent) throws IOException {
        Stage window3 = (Stage) img2.getScene().getWindow();
        //Stage stage = new Stage();
        window3.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/LoginForm.fxml"))));
        //stage.show();
        window3.getIcons().add(new Image("D:\\Final Project\\src\\main\\resources\\img\\301169643_601572054942155_6845422374024050099_n.jpg"));
        window3.centerOnScreen();

    }

    public void BtnStaffOnAction(ActionEvent actionEvent) throws IOException {
        Stage window5 = (Stage) img2.getScene().getWindow();
        //Stage stage = new Stage();
        window5.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/StaffDetailsForm.fxml"))));
        //stage.show();
        window5.getIcons().add(new Image("D:\\Final Project\\src\\main\\resources\\img\\301169643_601572054942155_6845422374024050099_n.jpg"));
        window5.centerOnScreen();
    }

    public void BtnStudentOnAction(ActionEvent actionEvent) throws IOException {
        Stage window5 = (Stage) img2.getScene().getWindow();
        //Stage stage = new Stage();
        window5.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/StudentdetailsForm.fxml"))));
        //stage.show();
        window5.getIcons().add(new Image("D:\\Final Project\\src\\main\\resources\\img\\301169643_601572054942155_6845422374024050099_n.jpg"));

        window5.centerOnScreen();
    }


    public void BtnParentOnAction(ActionEvent actionEvent) throws IOException {
        Stage window6 = (Stage) img2.getScene().getWindow();
        //Stage stage = new Stage();
        window6.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/ParentDetailForm.fxml"))));
        //stage.show();
        window6.getIcons().add(new Image("D:\\Final Project\\src\\main\\resources\\img\\301169643_601572054942155_6845422374024050099_n.jpg"));
        window6.centerOnScreen();
    }

    public void BtnTeachersOnAction(ActionEvent actionEvent) throws IOException {
        Stage window6 = (Stage) img2.getScene().getWindow();
        //Stage stage = new Stage();
        window6.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/TeacherDetailsFrom.fxml"))));
        //stage.show();
        window6.getIcons().add(new Image("D:\\Final Project\\src\\main\\resources\\img\\301169643_601572054942155_6845422374024050099_n.jpg"));
        window6.centerOnScreen();
    }

    public void BtnPaymentsOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/MakePaymentForm.fxml"))));
        stage.getIcons().add(new Image("D:\\Final Project\\src\\main\\resources\\img\\301169643_601572054942155_6845422374024050099_n.jpg"));
        stage.show();
        stage.centerOnScreen();
        stage.setTitle("Payments");
//        Stage window6 =  (Stage)img2.getScene().getWindow();
//        Stage stage = new Stage();
//        window6.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/MakePaymentForm.fxml"))));
//        //stage.show();
//        window6.getIcons().add(new Image("img/icons8-login-rounded-64.png"));
//        window6.centerOnScreen();

    }

    private void setPieChartValues() {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Students",10),
                        new PieChart.Data("Users", 50),
                        new PieChart.Data("Active Uers", 24),
                        new PieChart.Data("Inactive Users", 36),
                        new PieChart.Data("Subjects", 40),
                        new PieChart.Data("Classes", 60));


        Dashoard_Pie_Chart.getData().addAll(pieChartData);

    }


    private void loadDateandTime() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(format.format(date));

        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter format2 = DateTimeFormatter.ofPattern("HH:mm:ss");
            lblTime.setText(LocalTime.now().format(format2));
        }), new KeyFrame(Duration.seconds(1))
        );

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
