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
import sec.anchor.db.DBConnection;
import sec.anchor.model.SalaryCons;

/**
 *
 * @author Miyuru Madusanka
 */
public class SalaryConstController {

    public static int addSalaryConsts(SalaryCons salaryCons) throws SQLException, ClassNotFoundException {
        String sql = "insert into salarycons values(?,?,?,?,?,?,?,?,?)";
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        int res = -1;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, salaryCons.getNic());
            ps.setDouble(2, salaryCons.getBasic_salary());
            ps.setDouble(3, salaryCons.getBudget_al());
            ps.setDouble(4, salaryCons.getOtlimit());
            ps.setDouble(5, salaryCons.getWorkrate());
            ps.setDouble(6, salaryCons.getEpf_empl());
            ps.setDouble(7, salaryCons.getEtf_emp());
            ps.setDouble(8, salaryCons.getEpf_company());
            ps.setBoolean(9, salaryCons.isDeduction());
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

    public static SalaryCons searchSalaryCons(String nic) throws ClassNotFoundException, SQLException {
        String sql = "select * from salarycons where nic='" + nic + "'";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        SalaryCons salaryCons = null;
        while (rst.next()) {
            salaryCons = new SalaryCons(rst.getString(1), rst.getDouble(2), rst.getDouble(3), rst.getDouble(4), rst.getDouble(5), rst.getDouble(6), rst.getDouble(7), rst.getDouble(8), rst.getBoolean(9));
        }
        return salaryCons;
    }

    public static SalaryCons searchBasics(String nic) throws ClassNotFoundException, SQLException {
        String sql = "select basic_salary,budget_al,deduction from salarycons where nic='" + nic + "'";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        SalaryCons salaryCons = null;
        while (rst.next()) {
            salaryCons = new SalaryCons(rst.getDouble("basic_salary"), rst.getDouble("budget_al"),rst.getBoolean("deduction"));
        }
        return salaryCons;
    }

    public static double searchBasicSal(String nic) throws ClassNotFoundException, SQLException {
        String sql = "select basic_salary,budget_al from salarycons where nic='" + nic + "'";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        double salary = 0.00;
        while (rst.next()) {
            salary = rst.getDouble("basic_salary") + rst.getDouble("budget_al");
        }
        return salary;
    }

    public static int updateSalaryCons(SalaryCons salarycons) throws ClassNotFoundException, SQLException {
        String sql = "update salarycons set basic_salary=?,budget_al=?,otlimit=?,workrate=?,epf_empl=?,etf_emp=?,epf_company=?,deduction=? where nic=?";
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        int res = -1;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1, salarycons.getBasic_salary());
            ps.setDouble(2, salarycons.getBudget_al());
            ps.setDouble(3, salarycons.getOtlimit());
            ps.setDouble(4, salarycons.getWorkrate());
            ps.setDouble(5, salarycons.getEpf_empl());
            ps.setDouble(6, salarycons.getEtf_emp());
            ps.setDouble(7, salarycons.getEpf_company());
            ps.setBoolean(8, salarycons.isDeduction());
            ps.setString(9, salarycons.getNic());
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

    public static int updateAll(SalaryCons salarycons) throws ClassNotFoundException, SQLException {
        String sql = "update salarycons set basic_salary=?,budget_al=?,otlimit=?,workrate=?,epf_empl=?,etf_emp=?,epf_company=?,deduction=?";
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        int res = -1;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1, salarycons.getBasic_salary());
            ps.setDouble(2, salarycons.getBudget_al());
            ps.setDouble(3, salarycons.getOtlimit());
            ps.setDouble(4, salarycons.getWorkrate());
            ps.setDouble(5, salarycons.getEpf_empl());
            ps.setDouble(6, salarycons.getEtf_emp());
            ps.setDouble(7, salarycons.getEpf_company());
            ps.setBoolean(8, salarycons.isDeduction());

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

    public static double searchWorkRate(String nic) throws ClassNotFoundException, SQLException {
        String sql = "select workrate from salarycons where nic='" + nic + "'";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        double wrate = 0.00;
        while (rst.next()) {
            wrate = rst.getDouble("workrate");
        }
        return wrate;
    }
}
