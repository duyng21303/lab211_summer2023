/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import controllers.AccountAuthentication;
import controllers.AccountManager;
import controllers.FlowerManager;
import controllers.OrderManager;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;
import models.Order;

/**
 *
 * @author NguyenDuy
 */
public class UserMenu {

    public UserMenu(String id) {
        int choise = 0;
        
        
        Scanner sc = new Scanner(System.in);
        AccountManager am = new AccountManager();
        am.addAccountFromFile("accounts.txt");
        FlowerManager fm = new FlowerManager();
        fm.addFlowerFromFile("flowers.txt");

        do {
            System.out.println("USER MENU");
            System.out.println("1 - Update Profile");
            System.out.println("2 - View Flower List");
            System.out.println("3 - Add Flower to Cart");
            System.out.println("4 - View Order");
            System.out.println("5 - Cancel Order");
            System.out.println("Orther: Quit");
            System.out.println("Enter your choise");
            choise = Integer.parseInt(sc.nextLine());

            switch (choise) {
                case 1:
                    am.updateAccount(id, "accounts.txt", "customers.txt");
                    break;
                case 2:
                    new AccountAuthentication().printFlower();
                    break;
                case 3:

                    new OrderManager().addOrderToFile(id);
                    break;
                case 4:
                    new AccountAuthentication().printCart(id);
                    break;
                case 5:
                    break;

                default:
                    System.out.println("Input error!!!");
            }
        } while (choise > 0 && choise < 7);
    }

}
