package lk.ijse.gdse.model;

import lk.ijse.gdse.db.DBConnection;
import lk.ijse.gdse.dto.Guardian;
import lk.ijse.gdse.dto.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuardianModel {
    public static List<String> getguardianids() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql="SELECT Guardian_id FROM guardian";
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement1.executeQuery();
        List<String> guardianids = new ArrayList<>();
        while (resultSet.next()){
            guardianids.add(resultSet.getString(1));
        }
        return guardianids;
    }


    public static Guardian getGuaridanDetails(String guaridanid) throws SQLException {
        String sql = "SELECT * FROM guardian WHERE Guardian_id = ?";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,guaridanid);
        ResultSet rs1 = preparedStatement.executeQuery();
        if (rs1.next()){
            return new Guardian(
                    rs1.getString(1),
                    rs1.getString(2),
                    rs1.getString(3),
                    rs1.getString(4),
                    rs1.getString(5),
                    rs1.getString(6),
                    rs1.getString(7)

            );
        }
        return null;
    }

    public static boolean guardianupdate(Guardian guardian) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE guardian SET Guardian_First_Name=?,Guardian_Last_Name=?,Guardian_User_Name=?,Guardian_Password=?,Guardian_NIC=? where Guardian_id=?;");
        pstm.setString(6,guardian.getGuardian_id());
        pstm.setString(1,guardian.getGuardian_First_Name());
        pstm.setString(2,guardian.getGuardian_Last_Name());
        pstm.setString(3,guardian.getGuardian_Last_Name());
        pstm.setString(4,guardian.getGuardian_Password());
        pstm.setString(5,guardian.getGuardian_NIC());
        return pstm.executeUpdate() > 0;

    }

    public static boolean removeguardian(Guardian guardian) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM guardian where Guardian_id=?;");
        pstm.setString(1,guardian.getStudent_id());
        return pstm.executeUpdate() > 0;
    }
}
