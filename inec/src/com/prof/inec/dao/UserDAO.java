package com.prof.inec.dao;

import com.prof.inec.common.Database;
import com.prof.inec.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static Connection connection;

    public static boolean login(User user) throws Exception{
        //verify my user exists and has correct credentials
        User dbUser = getUser(user.getUsername());
        if (dbUser == null){
            return false;
        }

        if (dbUser.getPassword().equals(user.getPassword())){
            return true;
        }

        return false;
    }

    public static User create(User user) throws Exception{

        connection = Database.getConnection();

        String query = "INSERT INTO user(username, password, email, full_name) VALUES(?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getFullName());

        ps.executeUpdate();

        return user;
    }

    public static User getUser(String username) throws Exception{
        connection = Database.getConnection();
        User user = null;

        String query = "SELECT * FROM user WHERE username= ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, username);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            user = new User();
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setFullName(rs.getString("full_name"));
            user.setPassword(rs.getString("password"));
        }

        return user;
    }

    public static List<User> getAll() throws Exception{
        connection = Database.getConnection();
        List<User> users = new ArrayList<>();

        String query = "SELECT * FROM user";
        PreparedStatement ps = connection.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            User user = new User();
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setFullName(rs.getString("full_name"));
            user.setPassword(rs.getString("password"));

            users.add(user);
        }

        connection.close();

        return users;
    }

    public static void main(String[] args) {
        try {
            for (User user : getAll()){
                System.out.println("User with username: " + user.getUsername() + " exists!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
