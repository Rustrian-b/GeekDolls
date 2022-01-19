/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author H4HG
 */
public class ClsSales 
{

    public ClsSales() {
    }
    
    int vID_number;
    int vAmount;
    int vPhone;
    int vPhone1;
    String vDescription;
    String vName;
    String vAddress;
    String vStatus;
    String vPayment;

    public int getvID_number() {
        return vID_number;
    }

    public void setvID_number(int vID_number) {
        this.vID_number = vID_number;
    }

    public String getvDescription() {
        return vDescription;
    }

    public void setvDescription(String vDescription) {
        this.vDescription = vDescription;
    }

    public String getvAddress() {
        return vAddress;
    }

    public void setvAddress(String vAddress) {
        this.vAddress = vAddress;
    }

    public String getvStatus() {
        return vStatus;
    }

    public void setvStatus(String vStatus) {
        this.vStatus = vStatus;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }    

    public int getvAmount() {
        return vAmount;
    }

    public void setvAmount(int vAmount) {
        this.vAmount = vAmount;
    }  

    public String getvPayment() {
        return vPayment;
    }

    public void setvPayment(String vPayment) {
        this.vPayment = vPayment;
    }

    public int getvPhone() {
        return vPhone;
    }

    public void setvPhone(int vPhone) {
        this.vPhone = vPhone;
    }

    public int getvPhone1() {
        return vPhone1;
    }

    public void setvPhone1(int vPhone1) {
        this.vPhone1 = vPhone1;
    }

    public ClsSales(int vID_number, int vAmount, int vPhone, int vPhone1, String vDescription, String vName, String vAddress, String vStatus, String vPayment) {
        this.vID_number = vID_number;
        this.vAmount = vAmount;
        this.vPhone = vPhone;
        this.vPhone1 = vPhone1;
        this.vDescription = vDescription;
        this.vName = vName;
        this.vAddress = vAddress;
        this.vStatus = vStatus;
        this.vPayment = vPayment;
    }

    
    
}
