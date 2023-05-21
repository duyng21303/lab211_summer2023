/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import controllers.AccountManager;
import java.util.Scanner;
import models.Account;
import models.Login;

/**
 *
 * @author NguyenDuy
 */
public class CommonMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String file = "accounts.txt";
        AccountManager account = new AccountManager();
        account.addAccountFromFile(file);
        System.out.println("Enter id AXXX: ");
        String id = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        Login login = new Login(id, account);
        if(login.checkLogin(id, password)){
            if(login.checkRole(id).equals("DEV")){
                new DevMenu(id);
            }else if(login.checkRole(id).equals("USER")){
                new UserMenu(id);
            }else{
                System.out.println("Can't find role!");
                return;
            }
        }
    }  
    
}
