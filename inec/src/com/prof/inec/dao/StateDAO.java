package com.prof.inec.dao;

import com.prof.inec.common.Database;
import com.prof.inec.model.State;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Anything State related on the database
 */

public class StateDAO {

    private static Connection connection;

    public static List<State> getAll() throws SQLException {
        List<State> states = new ArrayList<>();
        connection = Database.getConnection();

        String query = "SELECT * FROM state";
        PreparedStatement ps = connection.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            State state = new State();
            state.setStateId(rs.getString("state_id"));
            state.setStateName(rs.getString("state_name"));

            states.add(state);
        }

        return states;
    }

    public static State get(String stateId) throws SQLException {
        connection = Database.getConnection();

        String query = "SELECT * FROM state WHERE state_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, stateId);

        ResultSet rs = ps.executeQuery();
        State state = null;
        while(rs.next()) {
            state = new State();
            state.setStateId(rs.getString("state_id"));
            state.setStateName(rs.getString("state_name"));

        }

        return state;
    }

}
