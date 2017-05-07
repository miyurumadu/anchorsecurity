/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.anchor.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import sec.anchor.db.DBConnection;
import sec.anchor.model.User;

/**
 *
 * @author Miyuru Madusanka
 */
public class UserController {

    public static int addUser(User user) throws ClassNotFoundException, SQLException {
        String sql = "insert into sysuser values(?,?,?,?,?,?)";
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        int res = -1;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getDesignation());
            ps.setString(3, user.getNic());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getUsername());
            ps.setString(6, user.getPassword());

            res = ps.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            connection.setAutoCommit(true);
        }
        return res;
    }

    public static User searchUser(String nic) throws ClassNotFoundException, SQLException {
        String sql = "select * from sysuser where nic='" + nic + "'";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        User user = null;
        while (rst.next()) {
            user = new User(rst.getString("name"), rst.getString("designation"), rst.getString("nic"), rst.getString("email"), rst.getString("username"), rst.getString("password"));
        }
        return user;
    }

    public static ArrayList<User> loadNicCombo() throws SQLException, ClassNotFoundException {
        String query = "select * from sysuser";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(query);

        ArrayList<User> employeesniclist = new ArrayList<>();
        while (rst.next()) {
            String nic = rst.getString("nic");
            String name = rst.getString("name");

            User user = new User(name, nic);
            employeesniclist.add(user);

        }
        return employeesniclist;
    }

    public static int deleteUser(String nic) throws ClassNotFoundException, SQLException {
        String sql = "delete from sysuser where nic='" + nic + "'";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        int res = stm.executeUpdate(sql);
        return res;
    }

    public static int updateUser(User user) throws ClassNotFoundException, SQLException {
        String sql = "update sysuser set name=?,designation=?,email=?,username=?,password=? where nic=?";
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        int res = -1;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getDesignation());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getUsername());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getNic());

            res = ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            connection.setAutoCommit(true);
        }
        return res;
    }

    public static User authentication(String username) throws ClassNotFoundException, SQLException {
        String sql = "select password,username from sysuser where username='" + username + "'";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        User user = null;
        while (rst.next()) {
            user = new User(rst.getString("username"), rst.getString("password"));

        }
        return user;
    }
}
