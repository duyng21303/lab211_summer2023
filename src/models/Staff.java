/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author NguyenDuy
 */
public class Staff {
    protected String staffID;
    protected String name;
    protected String address;
    protected long phone;

    public Staff(String staffID, String name, String address, long phone) {
        this.staffID = staffID;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Staff{" + "staffID=" + staffID + ", name=" + name + ", address=" + address + ", phone=" + phone + '}';
    }
    
}
