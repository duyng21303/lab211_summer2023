/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;
import models.Flower;

/**
 *
 * @author NguyenDuy
 */
public class AccountAuthentication {

    private Scanner sc = new Scanner(System.in);

    public void printFlower() {
        FlowerManager fm = new FlowerManager();
        int count = 0;
        for (int i = 0; i < 105; i++) {
            System.out.print("#");
        }
        System.out.printf("\n");
        System.out.printf("#%25s#%25s#%25s#%25s#\n", "id", "name", "price", "importdate");
        for (int i = 0; i < 105; i++) {
            System.out.print("#");
        }
        System.out.printf("\n");
        fm.addFlowerFromFile("flowers.txt");
        fm.printFlower();
        for (int i = 0; i < fm.arr.size(); i++) {
            count++;
        }
        for (int i = 0; i < 105; i++) {
            System.out.print("#");
        }
        System.out.printf("\n");
        System.out.printf("#%78s", " ");
        System.out.printf("Total: %3d flower type[s]#\n", count);
        for (int i = 0; i < 105; i++) {
            System.out.print("#");
        }
        System.out.printf("\n");
    }

    public void printCart(String id) {
        Calendar calendar = Calendar.getInstance();
        LocalDate date = LocalDate.of(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1, // Tháng bắt đầu từ 0 nên cần cộng thêm 1
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        FlowerManager fm = new FlowerManager();
        
        fm.addFlowerFromFile("flowers.txt");
        for (int i = 0; i < 79; i++) {
            System.out.print("#");
        }
        System.out.printf("\n");
        System.out.printf("#%25s#%25s#%25s#\n", "Orther ID", "Date", "BuyID");

        for (int i = 0; i < 79; i++) {
            System.out.print("#");
        }
        System.out.printf("\n");
        System.out.printf("#%25s#%25s#%25s#\n", "Orther ID", date, id);
        
        for (int i = 0; i < 79; i++) {
            System.out.print("#");
        }
        System.out.printf("\n");
        System.out.printf("#%25s#%25s#%25s#\n", "Flower name", "Quantity", "Price");
        for (int i = 0; i < 79; i++) {
            System.out.print("#");
        }
        System.out.printf("\n");
        new OrderManager().printV2();

    }
}
