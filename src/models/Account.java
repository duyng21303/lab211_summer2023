/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author NguyenDuy
 */
public class Account {
    private String accountID;
    private String password;
    private String role;
    private String customerID;

    public Account(String accountID, String password, String role, String customerID) {
        this.accountID = accountID;
        this.password = password;
        this.role = role;
        this.customerID = customerID;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "Account{" + "accountID=" + accountID + ", password=" + password + ", role=" + role + ", customerID=" + customerID + '}';
    }
    public void printAccount(){
        System.out.printf("|%s|%s|%s|%s|", accountID, password, role, customerID);
    }
}
