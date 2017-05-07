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
import sec.anchor.model.Employee;

/**
 *
 * @author Miyuru Madusanka
 */
public class EmployeeController {

    public static int addEmployee(Employee employee) throws ClassNotFoundException, SQLException {
        String sql = "insert into employee(nicnumber,name,address,dob,age,contact,bank,bankacc,epfno,etfno)"
                + " values(?,?,?,?,?,?,?,?,?,?)";
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        int res = -1;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getNicNumber());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getAddress());
            ps.setString(4, employee.getDob());
            ps.setInt(5, employee.getAge());
            ps.setInt(6, employee.getContactno());
            ps.setString(7, employee.getBank());
            ps.setString(8, employee.getBankAccNo());
            ps.setString(9, employee.getEpfno());
            ps.setString(10, employee.getEtfno());
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

    //fill data to names combo box
    public static ArrayList<Employee> loadNicCombo() throws SQLException, ClassNotFoundException {
        String query = "select * from employee";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(query);

        ArrayList<Employee> employeesniclist = new ArrayList<>();
        while (rst.next()) {
            String nic = rst.getString("nicnumber");
            String name = rst.getString("name");

            Employee employee = new Employee(name, nic);
            employeesniclist.add(employee);

        }
        return employeesniclist;
    }

    //search employees using the nic number given
    public static Employee searchEmployee(String nic) throws ClassNotFoundException, SQLException {
        String sql = "select * from employee where nicnumber='" + nic + "'";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        Employee employee = null;
        while (rst.next()) {
            employee = new Employee(rst.getString("name"), rst.getString("address"), rst.getString("dob"), rst.getInt("age"),
                    rst.getInt("contact"), rst.getString("bank"), rst.getString("bankacc"), rst.getString("image"), rst.getString("epfno"), rst.getString("etfno"));
        }
        return employee;
    }

    //list all the employees who are in the database
    public static ArrayList<Employee> viewAllEmployees() throws ClassNotFoundException, SQLException {
        String sql = "select * from employee limit 200";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Employee> allEmployees = new ArrayList<>();
        while (rst.next()) {
            String nic = rst.getString("nicnumber");
            String name = rst.getString("name");
            String address = rst.getString("address");
            String dob = rst.getString("dob");
            int age = rst.getInt("age");
            int contact = rst.getInt("contact");
            String bank = rst.getString("bank");
            String bankacc = rst.getString("bankacc");
            String image = rst.getString("image");
            String epfno = rst.getString("epfno");
            String etfno = rst.getString("etfno");
            Employee employee = new Employee(nic, name, address, dob, age, contact, bank, bankacc, image, epfno, etfno);
            allEmployees.add(employee);
        }
        return allEmployees;
    }

    //remove employees from the database
    public static int deleteEmployee(String nic) throws ClassNotFoundException, SQLException {
        String sql = "delete from employee where nicnumber='" + nic + "'";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        int res = stm.executeUpdate(sql);
        return res;
    }

    //update employee details which were currently on the database
    public static int updateEmployee(Employee employee) throws ClassNotFoundException, SQLException {
        String sql = "update employee set name=?,address=?,dob=?,age=?,contact=?,bank=?,bankacc=?,image=?,epfno=?,etfno=? where nicnumber=?";
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        int res = -1;
        try {
            System.out.println("inside controller" + employee.getNicNumber());
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getAddress());
            ps.setString(3, employee.getDob());
            ps.setInt(4, employee.getAge());
            ps.setInt(5, employee.getContactno());
            ps.setString(6, employee.getBank());
            ps.setString(7, employee.getBankAccNo());
            ps.setString(8, employee.getImage());
            ps.setString(9, employee.getEpfno());
            ps.setString(10, employee.getEtfno());
            ps.setString(11, employee.getNicNumber());
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

    public static String searchName(String nic) throws ClassNotFoundException, SQLException {
        String sql = "select name from employee where nicnumber='" + nic + "'";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        String name = "";
        while (rst.next()) {
            name = rst.getString("name");
        }
        return name;
    }

    public static int searchEPFno(String nic) throws ClassNotFoundException, SQLException {
        String sql = "select epfno from employee where nicnumber='" + nic + "'";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        int epfno = 0;
        while (rst.next()) {
            epfno = rst.getInt("epfno");
        }
        return epfno;
    }
}
