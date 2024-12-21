package lk.ijse.gdse.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.gdse.dto.Student;
import lk.ijse.gdse.model.StudentModel;
import lk.ijse.gdse.smtp.Mail;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

public class StudentDetailController implements Initializable {
    public ImageView img6;
    public AnchorPane pane;
    //public TableColumn Name;
    //public TableColumn table_id;
    //public TableColumn table_FirstName;
    //public TableColumn tbl_LastName;
    //public TableColumn tbl_UserName;


    @FXML
    private TableView<Student> table_Students;

    @FXML
    private TableColumn<?, ?> table_id;

    @FXML
    private TableColumn<?, ?> table_FirstName;

    @FXML
    private TableColumn<?, ?> tbl_LastName;

    @FXML
    private TableColumn<?, ?> tbl_UserName;

    @FXML
    private TableColumn<?, ?> tblPass;



    public void BtnBack3OnAction(ActionEvent actionEvent) throws IOException {
        Stage window5 =  (Stage)img6.getScene().getWindow();
        //Stage stage = new Stage();
        window5.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashBoardForm.fxml"))));
        //window5.setMaxHeight(768);
        //window5.setMaxHeight(1150);
        //stage.show();
        window5.centerOnScreen();
    }

    public void AddStudnetBtnOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/AddStudentForm.fxml"))));
        stage.getIcons().add(new Image("D:\\Final Project\\src\\main\\resources\\img\\301169643_601572054942155_6845422374024050099_n.jpg"));
        stage.show();
        stage.centerOnScreen();

    }

    public void UpdateStudentOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/UpdateStudentForm.fxml"))));
        stage.getIcons().add(new Image("D:\\Final Project\\src\\main\\resources\\img\\301169643_601572054942155_6845422374024050099_n.jpg"));
        stage.show();
        stage.centerOnScreen();
    }

    public void PaymentofStudentOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/MakePaymentForm.fxml"))));
        stage.getIcons().add(new Image("D:\\Final Project\\src\\main\\resources\\img\\301169643_601572054942155_6845422374024050099_n.jpg"));
        stage.show();
        stage.centerOnScreen();
    }

    public void RemoveofStudentOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/RemoveStudenform.fxml"))));
        stage.getIcons().add(new Image("D:\\Final Project\\src\\main\\resources\\img\\301169643_601572054942155_6845422374024050099_n.jpg"));
        stage.show();
        stage.centerOnScreen();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        populateStudentTbl();
        //getAll();
    }

    private void populateStudentTbl() {
        try {
            ObservableList<Student> data = (ObservableList<Student>) StudentModel.getAll();
            table_Students.setItems(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void setCellValueFactory() {
         table_id.setCellValueFactory(new PropertyValueFactory<>("id"));
         table_FirstName.setCellValueFactory(new PropertyValueFactory<>("fName"));
         tbl_LastName.setCellValueFactory(new PropertyValueFactory<>("lName"));
         tbl_UserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
         tblPass.setCellValueFactory(new PropertyValueFactory<>("password"));

    }

    public void SendMailOnAction(ActionEvent actionEvent) {
        Mail mail = new Mail();
        mail.setMsg("Welcome -Welcome to the Wisdom Student Management System");
        mail.setTo("raycooray32@gmail.com");
        mail.setSubject("Wisdom");

        Thread thread = new Thread(mail);
        thread.start();

    }

    public void SendStudentReportOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/SendReportForm.fxml"))));
        stage.getIcons().add(new Image("D:\\Final Project\\src\\main\\resources\\img\\301169643_601572054942155_6845422374024050099_n.jpg"));
        stage.show();
        stage.centerOnScreen();
    }

    public void AddStudentwithPayment(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Studentwithpayment.fxml"))));
        stage.getIcons().add(new Image("D:\\Final Project\\src\\main\\resources\\img\\301169643_601572054942155_6845422374024050099_n.jpg"));
        stage.show();
        stage.centerOnScreen();
    }
//    void getAll() {
//        ObservableList<Student> obList = FXCollections.observableArrayList();
//        List<Student> StuList = StudentModel.getAll();
//
//        for(Student student : StuList) {
//            obList.add(new Student(
////                        customer.getId(),
////                        customer.getName(),
////                        customer.getAddress(),
////                        customer.getSalary()
//                    student.getStudent_id(),
//                    student.getStudent_First_Name(),
//                    student.getStudent_Last_Name(),
//                    student.getStudent_UserName(),
//                    student.getPassword()
//
//            ));
//        }
//        table_Students.setItems(obList);
//    }
}
