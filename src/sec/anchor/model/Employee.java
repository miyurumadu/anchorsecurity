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
public class Employee {

    private String nicNumber;
    private String name;
    private String address;
    private String dob;
    private int age;
    private int contactno;
    private String bank;
    private String bankAccNo;
    private String image;
    private String epfno;
    private String etfno;

    public Employee() {
    }

    public Employee(String nicNumber, String name, String address, String dob, int age, int contactno, String bank, String bankAccNo, String image,String epfno,String etfno) {
        this.nicNumber = nicNumber;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.age = age;
        this.contactno = contactno;
        this.bank = bank;
        this.bankAccNo = bankAccNo;
        this.image = image;
        this.epfno=epfno;
        this.etfno=etfno;
    }

    public Employee(String name, String address, String dob, int age, int contactno, String bank, String bankAccNo, String image,String epfno,String etfno) {
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.age = age;
        this.contactno = contactno;
        this.bank = bank;
        this.bankAccNo = bankAccNo;
        this.image = image;
        this.epfno=epfno;
        this.etfno=etfno;
    }

    public Employee(String name,String nicNumber) {
        this.name=name;
        this.nicNumber = nicNumber;
        
    }

    @Override
    public String toString() {
        return name+"-"+nicNumber;
    }

    /**
     * @return the nicNumber
     */
    public String getNicNumber() {
        return nicNumber;
    }

    /**
     * @param nicNumber the nicNumber to set
     */
    public void setNicNumber(String nicNumber) {
        this.nicNumber = nicNumber;
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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEpfno() {
        return epfno;
    }

    public void setEpfno(String epfno) {
        this.epfno = epfno;
    }

    public String getEtfno() {
        return etfno;
    }

    public void setEtfno(String etfno) {
        this.etfno = etfno;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the contactno
     */
    public int getContactno() {
        return contactno;
    }

    /**
     * @param contactno the contactno to set
     */
    public void setContactno(int contactno) {
        this.contactno = contactno;
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
     * @return the bankAccNo
     */
    public String getBankAccNo() {
        return bankAccNo;
    }

    /**
     * @param bankAccNo the bankAccNo to set
     */
    public void setBankAccNo(String bankAccNo) {
        this.bankAccNo = bankAccNo;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }
}
