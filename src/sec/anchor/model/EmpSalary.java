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
public class EmpSalary {

    private String nic;
    private String name;
    private String bank;
    private String bankacc;
    private int epf;
    private int etf;
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

    public EmpSalary() {
    }

    public EmpSalary(String nic, String name, String bank, String bankacc, int epf, int etf, int workdays, double overtime, double other_al, double total_sal, double advance, double uniform, double fines, double epfEmp, double etfemp, double epfcompany, double netsalary, String payeddate) {
        this.nic = nic;
        this.name = name;
        this.bank = bank;
        this.bankacc = bankacc;
        this.epf = epf;
        this.etf = etf;
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

    public EmpSalary(String nic, String bankacc, double netsalary) {
        this.nic = nic;
        this.bankacc = bankacc;
        this.netsalary = netsalary;
    }

    public EmpSalary(String nic, String name, int epf, double uniform, double fines, double epfEmp, double epfcompany) {
        this.nic = nic;
        this.name = name;
        this.epf = epf;
        this.uniform = uniform;
        this.fines = fines;
        this.epfEmp = epfEmp;
        this.epfcompany = epfcompany;
    }

    public EmpSalary(String nic, String name, int workdays, double total_sal, double advance, double uniform, double fines, double epfEmp, double netsalary) {
        this.nic = nic;
        this.name = name;
        this.workdays = workdays;
        this.total_sal = total_sal;
        this.advance = advance;
        this.uniform = uniform;
        this.fines = fines;
        this.epfEmp = epfEmp;
        this.netsalary = netsalary;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the bank
     */
    public String getBank() {
        return bank;
    }

    /**
     * @param bank the bank to set
     */
    public void setBank(String bank) {
        this.bank = bank;
    }

    /**
     * @return the bankacc
     */
    public String getBankacc() {
        return bankacc;
    }

    /**
     * @param bankacc the bankacc to set
     */
    public void setBankacc(String bankacc) {
        this.bankacc = bankacc;
    }

    /**
     * @return the epf
     */
    public int getEpf() {
        return epf;
    }

    /**
     * @param epf the epf to set
     */
    public void setEpf(int epf) {
        this.epf = epf;
    }

    /**
     * @return the etf
     */
    public int getEtf() {
        return etf;
    }

    /**
     * @param etf the etf to set
     */
    public void setEtf(int etf) {
        this.etf = etf;
    }

    /**
     * @return the workdays
     */
    public int getWorkdays() {
        return workdays;
    }

    /**
     * @param workdays the workdays to set
     */
    public void setWorkdays(int workdays) {
        this.workdays = workdays;
    }

    /**
     * @return the overtime
     */
    public double getOvertime() {
        return overtime;
    }

    /**
     * @param overtime the overtime to set
     */
    public void setOvertime(double overtime) {
        this.overtime = overtime;
    }

    /**
     * @return the other_al
     */
    public double getOther_al() {
        return other_al;
    }

    /**
     * @param other_al the other_al to set
     */
    public void setOther_al(double other_al) {
        this.other_al = other_al;
    }

    /**
     * @return the total_sal
     */
    public double getTotal_sal() {
        return total_sal;
    }

    /**
     * @param total_sal the total_sal to set
     */
    public void setTotal_sal(double total_sal) {
        this.total_sal = total_sal;
    }

    /**
     * @return the advance
     */
    public double getAdvance() {
        return advance;
    }

    /**
     * @param advance the advance to set
     */
    public void setAdvance(double advance) {
        this.advance = advance;
    }

    /**
     * @return the uniform
     */
    public double getUniform() {
        return uniform;
    }

    /**
     * @param uniform the uniform to set
     */
    public void setUniform(double uniform) {
        this.uniform = uniform;
    }

    /**
     * @return the fines
     */
    public double getFines() {
        return fines;
    }

    /**
     * @param fines the fines to set
     */
    public void setFines(double fines) {
        this.fines = fines;
    }

    /**
     * @return the epfEmp
     */
    public double getEpfEmp() {
        return epfEmp;
    }

    /**
     * @param epfEmp the epfEmp to set
     */
    public void setEpfEmp(double epfEmp) {
        this.epfEmp = epfEmp;
    }

    /**
     * @return the etfemp
     */
    public double getEtfemp() {
        return etfemp;
    }

    /**
     * @param etfemp the etfemp to set
     */
    public void setEtfemp(double etfemp) {
        this.etfemp = etfemp;
    }

    /**
     * @return the epfcompany
     */
    public double getEpfcompany() {
        return epfcompany;
    }

    /**
     * @param epfcompany the epfcompany to set
     */
    public void setEpfcompany(double epfcompany) {
        this.epfcompany = epfcompany;
    }

    /**
     * @return the netsalary
     */
    public double getNetsalary() {
        return netsalary;
    }

    /**
     * @param netsalary the netsalary to set
     */
    public void setNetsalary(double netsalary) {
        this.netsalary = netsalary;
    }

    /**
     * @return the payeddate
     */
    public String getPayeddate() {
        return payeddate;
    }

    /**
     * @param payeddate the payeddate to set
     */
    public void setPayeddate(String payeddate) {
        this.payeddate = payeddate;
    }

    
}
