/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import controllers.AccountManager;
import java.util.Scanner;

/**
 *
 * @author NguyenDuy
 */
public class Login {
    private String accountID;
    private AccountManager accountManager;

    public Login(String accountID, AccountManager accountManager) {
        this.accountID = accountID;
        this.accountManager = accountManager;
    }
    

//    }
    public boolean checkLogin(String username, String password) {
        for (Account account : accountManager.arr) {
            if(account.getAccountID().equals(username) && account.getPassword().equals(password)){
                System.out.println("Successfully login");
                return true;
            }
                
            }
//            account.printAccount();
            System.out.println("Login fail");
            return false;
        }
    public String checkRole(String id){
        for (Account account : accountManager.arr) {
            if(account.getAccountID().equals(id)){
                return account.getRole();
            }
        }
        return null;
    }
        
}


