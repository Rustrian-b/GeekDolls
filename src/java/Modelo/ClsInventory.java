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
public class ClsInventory 
{
    int vID_number;
    String vDescription;
    int vAmount;

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

    public ClsInventory() {
    }

    public ClsInventory(String vDescription) {
        this.vDescription = vDescription;
    }

    public int getvAmount() {
        return vAmount;
    }

    public void setvAmount(int vAmount) {
        this.vAmount = vAmount;
    }            
}
