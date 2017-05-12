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
public class Salary {

    private String nicnumber;
    private String datefrom;
    private String dateto;
    private int workdays;
    private double overtime;
    private double other_al;
    private double total_sal;
    private double advance;
    private double uniform;
    private double fines;
    private double epfEmp;
    private double etfemp;
    private double epfcompany;
    private double netsalary;
    private String payeddate;

    public Salary() {
    }

    public Salary(double overtime, double other_al, double total_sal, double advance, double uniform, double fines, double epfEmp, double etfemp, double epfcompany, double netsalary, String payeddate) {
        this.overtime = overtime;
        this.other_al = other_al;
        this.total_sal = total_sal;
        this.advance = advance;
        this.uniform = uniform;
        this.fines = fines;
        this.epfEmp = epfEmp;
        this.etfemp = etfemp;
        this.epfcompany = epfcompany;
        this.netsalary = netsalary;
        this.payeddate = payeddate;
    }
    

    public Salary(String nicnumber, String datefrom, String dateto, int workdays, double overtime, double other_al, double total_sal, double advance, double uniform, double fines, double epfEmp, double etfemp, double epfcompany, double netsalary, String payeddate) {
        this.nicnumber = nicnumber;
        this.datefrom = datefrom;
        this.dateto = dateto;
        this.workdays = workdays;
        this.overtime = overtime;
        this.other_al = other_al;
        this.total_sal = total_sal;
        this.advance = advance;
        this.uniform = uniform;
        this.fines = fines;
        this.epfEmp = epfEmp;
        this.etfemp = etfemp;
        this.epfcompany = epfcompany;
        this.netsalary = netsalary;
        this.payeddate = payeddate;
    }

    public String getNicnumber() {
        return nicnumber;
    }

    public void setNicnumber(String nicnumber) {
        this.nicnumber = nicnumber;
    }

    public String getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(String datefrom) {
        this.datefrom = datefrom;
    }

    public String getDateto() {
        return dateto;
    }

    public void setDateto(String dateto) {
        this.dateto = dateto;
    }

    public int getWorkdays() {
        return workdays;
    }

    public void setWorkdays(int workdays) {
        this.workdays = workdays;
    }

    public double getOvertime() {
        return overtime;
    }

    public void setOvertime(double overtime) {
        this.overtime = overtime;
    }

    public double getOther_al() {
        return other_al;
    }

    public void setOther_al(double other_al) {
        this.other_al = other_al;
    }

    public double getTotal_sal() {
        return total_sal;
    }

    public void setTotal_sal(double total_sal) {
        this.total_sal = total_sal;
    }

    public double getAdvance() {
        return advance;
    }

    public void setAdvance(double advance) {
        this.advance = advance;
    }

    public double getUniform() {
        return uniform;
    }

    public void setUniform(double uniform) {
        this.uniform = uniform;
    }

    public double getFines() {
        return fines;
    }

    public void setFines(double fines) {
        this.fines = fines;
    }

    public double getEpfEmp() {
        return epfEmp;
    }

    public void setEpfEmp(double epfEmp) {
        this.epfEmp = epfEmp;
    }

    public double getEtfemp() {
        return etfemp;
    }

    public void setEtfemp(double etfemp) {
        this.etfemp = etfemp;
    }

    public double getEpfcompany() {
        return epfcompany;
    }

    public void setEpfcompany(double epfcompany) {
        this.epfcompany = epfcompany;
    }

    public double getNetsalary() {
        return netsalary;
    }

    public void setNetsalary(double netsalary) {
        this.netsalary = netsalary;
    }

    public String getPayeddate() {
        return payeddate;
    }

    public void setPayeddate(String payeddate) {
        this.payeddate = payeddate;
    }

    @Override
    public String toString() {
        return nicnumber ;
    }
    

}
