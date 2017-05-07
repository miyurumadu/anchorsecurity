/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.anchor.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import sec.anchor.db.DBConnection;
import sec.anchor.model.EmpSalary;

/**
 *
 * @author Miyuru Madusanka
 */
public class EmpSalaryController {

    public static ArrayList<EmpSalary> loadBankReport(String month, String bank,String year) throws SQLException, ClassNotFoundException {
        String sql = "select employee.nicnumber,employee.bankacc,salary.netsalary from employee inner join salary on employee.nicnumber=salary.nicnumber\n"
                + "where monthname(salary.datefrom)='" + month + "' and employee.bank='" + bank + "' and year(salary.datefrom)='" + year + "'";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<EmpSalary> bankview = new ArrayList<>();
        while (rst.next()) {

            String nic = rst.getString("employee.nicnumber");
            String bankacc = rst.getString("employee.bankacc");
            double netSalary = rst.getDouble("salary.netsalary");

            EmpSalary empSalary = new EmpSalary(nic, bankacc, netSalary);
            bankview.add(empSalary);

        }
        return bankview;
    }

    public static ArrayList<EmpSalary> loadCentralBankReport(String month,String year) throws SQLException, ClassNotFoundException {
        String sql = "select employee.name,employee.nicnumber,employee.epfno,salary.epfEmp,salary.epfcompany from employee inner join salary on employee.nicnumber=salary.nicnumber\n"
                + "where monthname(salary.datefrom)='" + month + "' and year(salary.datefrom)='" + year + "'";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<EmpSalary> centralBank = new ArrayList<>();
        while (rst.next()) {

            String name = rst.getString("employee.name");
            String nic = rst.getString("employee.nicnumber");
            int epfno = rst.getInt("employee.epfno");
            double epfemp = rst.getDouble("salary.epfEmp");
            double epfcomp = rst.getDouble("salary.epfcompany");
            double basic = 10000;//rst1.getDouble("basic_salary");
            double budget = 3500;//rst1.getDouble("budget_al");

            EmpSalary empSalary = new EmpSalary(nic, name, epfno, basic, budget, epfemp, epfcomp);
            centralBank.add(empSalary);

        }
        return centralBank;
    }

    public static ArrayList<EmpSalary> loadAllPaidSalaries(String month,String year) throws SQLException, ClassNotFoundException {
        String sql = "select employee.nicnumber,employee.name,salary.workdays,salary.total_sal,salary.uniform,salary.advance,salary.fines,salary.epfEmp,\n"
                + "salary.netsalary from employee inner join salary on employee.nicnumber=salary.nicnumber\n"
                + "where monthname(salary.datefrom)='" + month + "' and year(salary.datefrom)='" + year + "'";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<EmpSalary> centralBank = new ArrayList<>();
        while (rst.next()) {

            String name = rst.getString("employee.name");
            String nic = rst.getString("employee.nicnumber");
            int workdays = rst.getInt("salary.workdays");
            double total_sal = rst.getDouble("salary.total_sal");
            double advance = rst.getDouble("salary.advance");
            double uniform = rst.getDouble("salary.uniform");
            double fines = rst.getDouble("salary.fines");
            double epfEmp = rst.getDouble("salary.epfEmp");
            double netsalary = rst.getDouble("salary.netsalary");

            EmpSalary empSalary = new EmpSalary(nic, name, workdays, total_sal, advance, uniform, fines, epfEmp, netsalary);
            centralBank.add(empSalary);

        }
        return centralBank;
    }
    
   
}
