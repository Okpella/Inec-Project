package com.prof.inec.dao;

import com.prof.inec.common.Database;
import com.prof.inec.model.Candidate;
import com.prof.inec.model.Lga;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidateDAO {
//    private static Connection connection;
//
//    public static List<Candidate> getAll() throws SQLException {
//        List<Candidate> candidate = new ArrayList<>();
//        connection = Database.getConnection();
//        String query = "SELECT * FROM candidate";
//
//        PreparedStatement ps = connection.prepareStatement(query);
//
//        ResultSet rs = ps.executeQuery();
//
//        while (rs.next()){
//            Candidate cand = new Candidate();
//
//            cand.setCandidate_id(rs.getString("id"));
//            cand.setCandidate_name(rs.getString("candidate_name"));
//            cand.setPosition(rs.getString("position"));
//            cand.setCandidate_party(rs.getString("candidate_party"));
//
//            candidate.add(cand);
//        }
//
//        return candidate;
//    }

    private static Connection connection;

    public static List<Candidate> getAll() throws SQLException {

        List<Candidate> candidate = new ArrayList<>();
        connection = Database.getConnection();

        String query = "SELECT * FROM candidate";

        PreparedStatement ps = connection.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        Candidate cand = null;
        while(rs.next()){
            cand = new Candidate("", "", "", "");

            cand.setCandidateId(rs.getString("id"));
            cand.setCandidateName(rs.getString("full_name"));
            cand.setPosition(rs.getString("position"));
            cand.setCandidateParty(rs.getString("candidate_party"));

            candidate.add(cand);
        }

        return candidate;
    }

//    public static void main(String[] args) {
//        try {
//            getAll().forEach(System.out::println);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
