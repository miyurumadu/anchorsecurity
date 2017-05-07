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
import sec.anchor.model.Salary;

/**
 *
 * @author Miyuru Madusanka
 */
public class SalaryController {

    public static int addSalary(Salary salary) throws ClassNotFoundException, SQLException {
        String sql = "insert into salary (nicnumber,datefrom,dateto,workdays,overtime,other_al,total_sal,advance,uniform,fines,epfEmp,etfemp,epfcompany,netsalary,payeddate)"
                + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        int res = -1;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, salary.getNicnumber());
            ps.setString(2, salary.getDatefrom());
            ps.setString(3, salary.getDateto());
            ps.setInt(4, salary.getWorkdays());
            ps.setDouble(5, salary.getOvertime());
            ps.setDouble(6, salary.getOther_al());
            ps.setDouble(7, salary.getTotal_sal());
            ps.setDouble(8, salary.getAdvance());
            ps.setDouble(9, salary.getUniform());
            ps.setDouble(10, salary.getFines());
            ps.setDouble(11, salary.getEpfEmp());
            ps.setDouble(12, salary.getEtfemp());
            ps.setDouble(13, salary.getEpfcompany());
            ps.setDouble(14, salary.getNetsalary());
            ps.setString(15, salary.getPayeddate());
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

    //list all the employees who are in the database
    public static ArrayList<Salary> viewAllSalaries(String month, String year) throws ClassNotFoundException, SQLException {
        String sql = "select * from salary where monthname(datefrom)='" + month + "' and year(datefrom)='" + year + "'";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Salary> allEmployees = new ArrayList<>();
        while (rst.next()) {
            String nic = rst.getString(2);
            String name = rst.getString(3);
            String address = rst.getString(4);
            int age = rst.getInt(5);
            double overtime = rst.getDouble(6);
            double other_al = rst.getDouble(7);
            double total_sal = rst.getDouble(8);
            double advance = rst.getDouble(9);
            double uniform = rst.getDouble(10);
            double fines = rst.getDouble(11);
            double epfEmp = rst.getDouble(12);
            double etfemp = rst.getDouble(13);
            double epfcompany = rst.getDouble(14);
            double netsalary = rst.getDouble(15);
            String payeddate = rst.getString(16);
            Salary salary = new Salary(nic, name, address, age, overtime, other_al, total_sal, advance, uniform, fines, epfEmp, etfemp, epfcompany, netsalary, payeddate);
            allEmployees.add(salary);
        }
        return allEmployees;
    }

    public static Salary viewAllSalarieswithNIC(String month, String year, String nic) throws ClassNotFoundException, SQLException {
        String sql = "select * from salary where monthname(datefrom)='" + month + "' and year(datefrom)='" + year + "' and nicnumber='" + nic + "'";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        Salary salary = null;
        while (rst.next()) {
            double overtime = rst.getDouble("overtime");
            double other_al = rst.getDouble("other_al");
            double total_sal = rst.getDouble("total_sal");
            double advance = rst.getDouble("advance");
            double uniform = rst.getDouble("uniform");
            double fines = rst.getDouble("fines");
            double epfEmp = rst.getDouble("epfEmp");
            double etfemp = rst.getDouble("etfemp");
            double epfcompany = rst.getDouble("epfcompany");
            double netsalary = rst.getDouble("netsalary");
            String payeddate = rst.getString("payeddate");
            salary = new Salary(overtime, other_al, total_sal, advance, uniform, fines, epfEmp, etfemp, epfcompany, netsalary, payeddate);

        }
        return salary;
    }

    public static int deleteSalaries(String month, String year) throws ClassNotFoundException, SQLException {
        String sql = "delete from salary where monthname(datefrom)='" + month + "' and year(datefrom)='" + year + "'";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        int res = stm.executeUpdate(sql);
        return res;
    }
    
     public static int deleteSingleSalary(String nic,String month, String year) throws ClassNotFoundException, SQLException {
        String sql = "delete from salary where nicnumber='" + nic + "' and monthname(datefrom)='" + month + "' and year(datefrom)='" + year + "'";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        int res = stm.executeUpdate(sql);
        return res;
    }
}
