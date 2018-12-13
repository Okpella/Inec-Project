package com.prof.inec.dao;

import com.prof.inec.common.Database;
import com.prof.inec.model.Party;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PartyDAO {

    private static Connection connection;

//    public static void main(String[] args) throws Exception {
//
////        TO INSERT A FILE INTO THE DATABASE DIRECTLY
//        BufferedReader br = new BufferedReader
//                (new FileReader(new File(PartyDAO.class
//                        .getResource("political_parties.txt").getFile())));
//        try {
////            br.lines().forEach(System.out::println);
//            br.lines().forEach(line -> {
//                String[] content = line.split(",");
//
//                Party party = new Party(content[0].trim(), content[1].trim());
//                safeCreate(party);
//            });
//        }
//        finally {
//            br.close();
//        }
//    }
//
//    private static void safeCreate(Party party){
//        try {
//            create(party);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    public static void create(Party party) throws SQLException {
         connection = Database.getConnection();
         String query = "INSERT INTO political_parties(name,id,passport) VALUES(?,?,?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, party.getName());
        ps.setString(2, party.getId());
        ps.setString(3, party.getPassport());

        ps.executeUpdate();

        connection.close();

        //    THIS END THE INSERTION OF DATA INTO THE DATABASE

    }

    public static List<Party> getAll() throws SQLException{
        List<Party> party = new ArrayList<>();

        connection = Database.getConnection();
        String query = "SELECT * FROM political_parties";

        PreparedStatement ps = connection.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            Party parties = new Party();
            parties.setName(rs.getString("name"));
            parties.setId(rs.getString("id"));

            party.add(parties);
        }
        return party;
    }

    public static Party update(Party party) throws SQLException{
        connection = Database.getConnection();
        String query = "UPDATE political_parties SET name = ? WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, party.getName());
        ps.setString(2, party.getId());

        ps.executeUpdate();

        return party;
    }

    public static Party delete(Party party) throws SQLException{
        connection = Database.getConnection();

        String query = "DELETE FROM political_parties WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, party.getId());

        ps.executeUpdate();

        return party;
    }

    public static void main(String[] args) throws SQLException {
        getAll().forEach(System.out::println);
    }

//    Let parties show as i search
    public static List<Party> getParty(String searchText) throws SQLException {
        connection = Database.getConnection();
        List<Party> parties = new ArrayList<>();

        String sql = "SELECT * FROM political_parties WHERE name LIKE '%" + searchText + "%'";

        ResultSet rs = connection.prepareStatement(sql).executeQuery();

        while (rs.next()) {
            Party party = new Party(rs.getString("name"), rs.getString("id"), rs.getString("passport"));
            parties.add(party);
        }

        return parties;
    }

    public static Party getById(String id) throws SQLException {
        connection = Database.getConnection();
        String query = "SELECT * FROM political_parties WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, id);
        Party party = null;

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            party = new Party(rs.getString("name"), rs.getString("id"), rs.getString("passport"));
        }

        return party;
    }
}
