package lk.ijse.gdse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import lk.ijse.gdse.db.DBConnection;
import lk.ijse.gdse.model.StudentModel;
import lk.ijse.gdse.model.UserModel;
import lombok.SneakyThrows;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StaffDetailController implements Initializable {

    public ImageView img5;
    public BarChart Chart1;

    public void BtnBack2onAction(ActionEvent actionEvent) throws IOException {
        Stage window4 =  (Stage)img5.getScene().getWindow();
        //Stage stage = new Stage();
        window4.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashBoardForm.fxml"))));
        //stage.show();
        window4.centerOnScreen();

    }

    public void Generate_ReportOnAction(ActionEvent actionEvent) throws SQLException, JRException {
//        InputStream jasDesign = JRXmlLoader.load("src/main/resources/Report/Invoice_Table_Based.jrxml");
//        JasperReport jasReport = JasperCompileManager.compileReport(jasDesign);
//        JasperPrint jasPrint = JasperFillManager.fillReport(jasReport, null, DBConnection.getInstance().getConnection());
//        JasperViewer.viewReport(jasPrint,false);

        JasperDesign load = JRXmlLoader.load("D:\\Final Project\\src\\main\\resources\\Report\\userReport.jrxml");
        JasperReport compileReport = JasperCompileManager.compileReport(load);
        JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport,null, DBConnection.getInstance().getConnection());
        JasperViewer.viewReport(jasperPrint,false);



    }


    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        XYChart.Series<String, Number>[] series1 = new XYChart.Series[2];

        series1[0] = new XYChart.Series<>();
        series1[0].getData().add(new XYChart.Data<>("", StudentModel.getCount()));
        series1[0].setName("Students");

        series1[1] = new XYChart.Series<>();
        series1[1].getData().add(new XYChart.Data<>("", UserModel.getCount()));
        series1[1].setName("Users");

        Chart1.getData().addAll(series1);
    }

    public void Generate_Student_ReportOnAction(ActionEvent actionEvent) throws JRException, SQLException {
        JasperDesign load = JRXmlLoader.load("D:\\Final Project\\src\\main\\resources\\Report\\Student.jrxml");
        JasperReport compileReport = JasperCompileManager.compileReport(load);
        JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport,null, DBConnection.getInstance().getConnection());
        JasperViewer.viewReport(jasperPrint,false);
    }
}
