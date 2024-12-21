package lk.ijse.gdse.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import lk.ijse.gdse.db.DBConnection;
import lk.ijse.gdse.dto.Student;
import lk.ijse.gdse.util.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentModel {
    public static List<String> getIds() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql="SELECT Student_id FROM student";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<String> ids = new ArrayList<>();
        while (resultSet.next()){
           ids.add(resultSet.getString(1));
        }
        return ids;
    }

    public static Student getDetails(String id) throws SQLException {
        String sql = "SELECT * FROM student WHERE Student_id = ?";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,id);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()){
            return new Student(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
                    );
        }
        return null;
    }

    public static boolean update(Student student) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE student SET Student_First_Name=?,Student_Last_Name=?,Student_UserName=?,Password=? where Student_id=?;");
        pstm.setString(5,student.getId());
        pstm.setString(1,student.getFName());
        pstm.setString(2,student.getLName());
        pstm.setString(3,student.getUserName());
        pstm.setString(4,student.getPassword());
        return pstm.executeUpdate() > 0;

    }
    public static boolean remove(Student student) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM student where Student_id=?;");
        pstm.setString(1,student.getId());
        return pstm.executeUpdate() > 0;

    }

    public static List<Student> getAll() throws SQLException {
        ObservableList<Student> data = FXCollections.observableArrayList();
        String sql = "SELECT * FROM student";
        ResultSet resultSet = CrudUtil.execute(sql);
        while (resultSet.next()){
            data.add(new Student(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            ));
        }return data;
    }

    public static Integer getCount() throws SQLException {
        String sql = "SELECT Password FROM student";
        int count = 0;
        ResultSet resultSet = CrudUtil.execute(sql);
        while (resultSet.next()){
            count++;
        }return count;
    }

//    public static Object getTypes(String type) {
//        return null;
//    }
}

