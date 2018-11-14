package com.prof.inec.dao;

import com.prof.inec.common.Database;
import com.prof.inec.model.RegistrationPoint;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationPointDAO {

    private static Connection connection;

    public static RegistrationPoint create(RegistrationPoint registrationPoint) throws SQLException {

        String query = "INSERT INTO registration_point(reg_point,lga, state) VALUES(?,?,?)";

        connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, registrationPoint.getRegPoint());
        ps.setInt(2, registrationPoint.getLga().getLgaId());
        ps.setString(3, registrationPoint.getLga().getState().getStateId());

        ps.executeUpdate();

        return registrationPoint;
    }

    public static RegistrationPoint update(RegistrationPoint registrationPoint) throws SQLException{
        String query = "UPDATE registration_point SET reg_point = ? WHERE id = ?";

        connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, registrationPoint.getRegPoint());
        ps.setInt(2, registrationPoint.getId());

        ps.executeUpdate();

        return registrationPoint;
    }

    public static List<RegistrationPoint> getAll() throws SQLException {
        List<RegistrationPoint> registrationPoints = new ArrayList<>();
        String query = "SELECT * FROM registration_point";

        connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        extractData(rs, registrationPoints);

        return registrationPoints;
    }

    public static List<RegistrationPoint> getByLga(int lgaId, String state) throws SQLException {
        List<RegistrationPoint> registrationPoints = new ArrayList<>();
        connection = Database.getConnection();

        String query = "SELECT * FROM registration_point WHERE lga = ? AND state=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, lgaId);
        ps.setString(2, state);

        ResultSet rs = ps.executeQuery();

        extractData(rs, registrationPoints);

        return registrationPoints;
    }

    public static void delete(RegistrationPoint registrationPoint) throws SQLException{
        connection = Database.getConnection();
        String query = "DELETE FROM registration_point WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, registrationPoint.getId());

        ps.executeUpdate();
    }

    private static void extractData(ResultSet rs, List<RegistrationPoint> registrationPoints) throws SQLException{
        while(rs.next()) {
            RegistrationPoint point = new RegistrationPoint();
            point.setRegPoint(rs.getString("reg_point"));
            point.setId(rs.getInt("id"));
            point.setLga(LgaDAO.get(rs.getInt("lga"), rs.getString("state")));

            registrationPoints.add(point);
        }
    }

    public static void main(String[] args) {
        try{
            getAll().forEach(System.out::println);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
