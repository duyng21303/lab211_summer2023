/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import controllers.AccountAuthentication;
import java.util.ArrayList;
import java.util.Scanner;
import models.Account;
import controllers.AccountManager;
import controllers.StaffManager;
/**
 *
 * @author NguyenDuy
 */
public class DevMenu {

    public DevMenu(String id) {
        int choise = 0;
        Scanner sc = new Scanner(System.in);
        AccountManager am = new AccountManager();
        am.addAccountFromFile("accounts.txt");
//        StaffManager sm = new StaffManager(id, id, id, choise);
//        sm.addStaffFromFile("staffs.txt");
        do {
            System.out.println("DEV MENU");
            System.out.println("1 - Update Profile");
            System.out.println("2 - View Flower List");
            System.out.println("3 - Add Flower");
            System.out.println("4 - Modify Flower");
            System.out.println("5 - Remove Flower");
            System.out.println("6 - View Sorted Orders");
            System.out.println("7 - Remove Order");
            System.out.println("Orther: Quit");
            System.out.println("Enter your choise");
            choise = Integer.parseInt(sc.nextLine());

            switch (choise) {
                case 1:
                    
                    am.updateAccount(id, "accounts.txt", "staffs.txt");
                
                    break;
                case 2:
                    new AccountAuthentication().printFlower();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Input error!!!");
            }
        } while (choise > 0 && choise < 8);
    }
        
}
