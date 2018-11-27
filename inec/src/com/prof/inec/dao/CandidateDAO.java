package com.prof.inec.dao;

import com.prof.inec.common.Database;
import com.prof.inec.model.Candidate;
import com.prof.inec.model.Lga;
import com.prof.inec.model.Party;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidateDAO {
//    private static Connection connection;

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
//            Candidate candidates = new Candidate();
//
//            candidates.setCandidateId(rs.getString("id"));
//            candidates.setCandidateName(rs.getString("candidate_name"));
//            candidates.setPosition(rs.getString("position"));
//            candidates.setCandidateParty(rs.getString("candidate_party"));
//
//            candidate.add(candidates);
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
            cand = new Candidate();

            cand.setCandidateId(rs.getString("id"));
            cand.setCandidateName(rs.getString("full_name"));
            cand.setPosition(rs.getString("position"));
            cand.setMate(rs.getString("mate"));
            cand.setCandidateParty(PartyDAO.getById(rs.getString("candidate_party")));

            candidate.add(cand);
        }

        return candidate;
    }

    public static List<Candidate> getByParty(String partyId) throws SQLException{
//        get candidate by political Party
//
        List<Candidate> candidates = new ArrayList<>();

        connection = Database.getConnection();

        String query = "SELECT * FROM candidate WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, partyId);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            Candidate candidate = new Candidate();
            candidate.setCandidateId(rs.getString("id"));
            candidate.setCandidateName(rs.getString("full_name"));
            candidate.setPosition(rs.getString("position"));
            candidate.setMate(rs.getString("position"));
            candidate.setCandidateParty(PartyDAO.getById(rs.getString("candidate_party")));

            candidates.add(candidate);
        }

        return candidates;
    }

    public static void main(String[] args) {
        try {
//            getAll().forEach(System.out::println);
            System.out.println(getByParty("MNN"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
