package lk.ijse.gdse.model;

import lk.ijse.gdse.db.DBConnection;
import lk.ijse.gdse.smtp.Mail;
import lk.ijse.gdse.util.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
    public static boolean check(String userName, String password) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql ="SELECT * FROM user WHERE UserName = ?";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,userName);
        Mail mail = new Mail();
        mail.setMsg("Welcome -Welcome to the Wisdom Student Management System");
        mail.setTo(userName);
        mail.setSubject("Wisdom Login");

        Thread thread = new Thread(mail);
        thread.start();


        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()){
            if(resultSet.getString(2).equals(password)){
                return true;
            }
        }
        return false;
    }

    public static boolean add(String email_username, String passwordtext) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql="INSERT INTO user(UserName,Password) VALUES (?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,email_username);
        pstm.setString(2,passwordtext);
        int affectedRows = pstm.executeUpdate();

        return affectedRows>0;
    }

    public static Integer getCount() throws SQLException {
        String sql = "SELECT Password FROM user";
        int count = 0;
        ResultSet resultSet = CrudUtil.execute(sql);
        while (resultSet.next()){
            count++;
        }return count;
    }
}
