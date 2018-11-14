package com.prof.inec.dao;

import com.prof.inec.common.Database;
import com.prof.inec.model.Lga;
import com.prof.inec.model.State;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LgaDAO {
    private static Connection connect;

    public static List<Lga> getAll() throws SQLException {

        List<Lga> lgas = new ArrayList<>();
        connect = Database.getConnection();

        String query = "SELECT * FROM lga";

        PreparedStatement ps = connect.prepareStatement(query);
        ResultSet result = ps.executeQuery();

        while(result.next()){
            Lga lga = new Lga();

            lga.setLgaId(result.getInt("lga_id"));
            lga.setLgaName(result.getString( "lga_name"));

            lgas.add(lga);
        }

        return lgas;
    }

    public static List<Lga> getByState(String stateId) throws SQLException{
        List<Lga> lgas = new ArrayList<>();

        connect = Database.getConnection();

        String query = "SELECT * FROM lga WHERE state_id = ?";

        PreparedStatement ps = connect.prepareStatement(query);

        ps.setString(1, stateId);

        ResultSet result = ps.executeQuery();

        while(result.next()){
            Lga lga = new Lga();

            lga.setLgaId(result.getInt("lga_id"));
            lga.setLgaName(result.getString( "lga_name"));

            lgas.add(lga);
        }

        return lgas;
    }

    public static Lga get(int id, String stateId) throws SQLException{
        String query = "SELECT * FROM lga WHERE lga_id = ? AND state_id = ?";
        connect = Database.getConnection();
        PreparedStatement ps = connect.prepareStatement(query);
        ps.setInt(1, id);
        ps.setString(2, stateId);
        ResultSet rs = ps.executeQuery();
        Lga lga = null;

        while (rs.next()){
            lga = new Lga();

            lga.setLgaId(rs.getInt("lga_id"));
            lga.setLgaName(rs.getString( "lga_name"));
            lga.setState(StateDAO.get(rs.getString("state_id")));
        }

        return lga;
    }
}
