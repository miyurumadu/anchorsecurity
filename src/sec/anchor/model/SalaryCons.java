/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sec.anchor.model;

/**
 *
 * @author Miyuru Madusanka
 */
public class SalaryCons {
    private String nic;
    private double basic_salary;
    private double budget_al;
    private double otlimit;
    private double workrate;
    private double epf_empl;
    private double etf_emp;
    private double epf_company;
    private boolean deduction;

    public SalaryCons() {
    }

    public SalaryCons(String nic, double basic_salary, double budget_al, double otlimit, double workrate, double epf_empl, double etf_emp, double epf_company,boolean deduction) {
        this.nic = nic;
        this.basic_salary = basic_salary;
        this.budget_al = budget_al;
        this.otlimit = otlimit;
        this.workrate = workrate;
        this.epf_empl = epf_empl;
        this.etf_emp = etf_emp;
        this.epf_company = epf_company;
        this.deduction=deduction;
    }

    public SalaryCons(double basic_salary, double budget_al, double otlimit, double workrate, double epf_empl, double etf_emp, double epf_company,boolean deduction) {
        this.basic_salary = basic_salary;
        this.budget_al = budget_al;
        this.otlimit = otlimit;
        this.workrate = workrate;
        this.epf_empl = epf_empl;
        this.etf_emp = etf_emp;
        this.epf_company = epf_company;
        this.deduction=deduction;
    }

    public SalaryCons(double basic_salary, double budget_al) {
        this.basic_salary = basic_salary;
        this.budget_al = budget_al;
    }

    public SalaryCons(double basic_salary, double budget_al, boolean deduction) {
        this.basic_salary = basic_salary;
        this.budget_al = budget_al;
        this.deduction = deduction;
    }

    /**
     * @return the nic
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
    }

    /**
     * @return the basic_salary
     */
    public double getBasic_salary() {
        return basic_salary;
    }

    /**
     * @param basic_salary the basic_salary to set
     */
    public void setBasic_salary(double basic_salary) {
        this.basic_salary = basic_salary;
    }

    /**
     * @return the budget_al
     */
    public double getBudget_al() {
        return budget_al;
    }

    /**
     * @param budget_al the budget_al to set
     */
    public void setBudget_al(double budget_al) {
        this.budget_al = budget_al;
    }

    /**
     * @return the otlimit
     */
    public double getOtlimit() {
        return otlimit;
    }

    /**
     * @param otlimit the otlimit to set
     */
    public void setOtlimit(double otlimit) {
        this.otlimit = otlimit;
    }

    /**
     * @return the workrate
     */
    public double getWorkrate() {
        return workrate;
    }

    /**
     * @param workrate the workrate to set
     */
    public void setWorkrate(double workrate) {
        this.workrate = workrate;
    }

    /**
     * @return the epf_empl
     */
    public double getEpf_empl() {
        return epf_empl;
    }

    /**
     * @param epf_empl the epf_empl to set
     */
    public void setEpf_empl(double epf_empl) {
        this.epf_empl = epf_empl;
    }

    /**
     * @return the etf_emp
     */
    public double getEtf_emp() {
        return etf_emp;
    }

    /**
     * @param etf_emp the etf_emp to set
     */
    public void setEtf_emp(double etf_emp) {
        this.etf_emp = etf_emp;
    }

    /**
     * @return the epf_company
     */
    public double getEpf_company() {
        return epf_company;
    }

    /**
     * @param epf_company the epf_company to set
     */
    public void setEpf_company(double epf_company) {
        this.epf_company = epf_company;
    }

    public boolean isDeduction() {
        return deduction;
    }

    public void setDeduction(boolean deduction) {
        this.deduction = deduction;
    }
    
    
    
}
