/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import models.Order;

/**
 *
 * @author NguyenDuy
 */
public class OrderManager extends Vector<Order> {

    private Scanner sc = new Scanner(System.in);

    public OrderManager() {

    }

    public boolean checkOrder(String flowerID) {
        try {
            File f = new File("orderTemp.txt");

            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while ((details = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ",");
                String orderID = stk.nextToken().toUpperCase();
                String date = stk.nextToken().toUpperCase();
                String flowerIDf = stk.nextToken().toUpperCase();
                if (flowerIDf.equals(flowerID)) {
                    return true;
                }
            }
            bf.close();
            fr.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public void addOrderToFile(String id) {
        String flowerID;
        int quatity;
        System.out.println("Enter flower ID FXXX: ");
        flowerID = sc.nextLine();
        System.out.println("Enter quatity: ");
        quatity = Integer.parseInt(sc.nextLine());

        FlowerManager fm = new FlowerManager();
        fm.addFlowerFromFile("flowers.txt");
        if (new OrderManager().checkOrder(flowerID)) {

            try ( Scanner scannerFile = new Scanner(new File("orderTemp.txt"));  PrintWriter pw = new PrintWriter(new FileWriter("orderTemp_temp.txt"))) {

                while (scannerFile.hasNextLine()) {
                    String replaceFile = scannerFile.nextLine();
                    String[] newTokens = replaceFile.split(",");

                    if (newTokens[2].equals(flowerID)) {
                        int quatityTemp = Integer.parseInt(newTokens[3]) + quatity;
                        double tempToTalPrice = 0;
                        for (int i = 0; i < fm.arr.size(); i++) {
                            if (fm.arr.get(i).getFlowerID().equals(flowerID)) {
                                tempToTalPrice = (Double) (fm.arr.get(i).getUnitPrice() * (double) quatityTemp);
                            }
                        }

                        pw.println(newTokens[0] + "," + newTokens[1] + "," + newTokens[2] + "," + quatityTemp + "," + newTokens[4] + "," + tempToTalPrice + "," + newTokens[6]);
//                                for (int i = 0; i < fm.arr.size(); i++) {
//                                    if(fm.get(i).getFlowerID().equals(flowerID)){
//                                        Order order = new Order(flowerID, quatityTemp * fm.arr.get(i).getUnitPrice(), flowerID, fm.arr.get(i).getName(), fm.arr.get(i).getUnitPrice(), LocalDate.MAX);
//                                        pw.println(order.getOrderID() + "," + order.getDate() + "," + order.getFlowerID() + "," + quatityTemp + "," + order.getName() + "," + order.getTotalPrice() + "," + id);
//                                    }
//                                }
                    } else {

                        pw.println(replaceFile);
                    }
                }

                pw.close();

                scannerFile.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            try ( Scanner scannerFileTemp = new Scanner(new File("orderTemp_temp.txt"));  PrintWriter pwf = new PrintWriter(new FileWriter("orderTemp.txt"))) {

                File tempFile = new File("orderTemp_temp.txt");
                while (scannerFileTemp.hasNextLine()) {
                    String scannerTemp = scannerFileTemp.nextLine();
                    pwf.printf("%s\n", scannerTemp);
                }
                System.out.println("Update successfully");
                pwf.close();
                scannerFileTemp.close();
//                tempFile.deleteOnExit();

            } catch (Exception e) {
            }
        } else {
            for (int i = 0; i < fm.arr.size(); i++) {
                if (fm.arr.get(i).getFlowerID().equals(flowerID)) {
                    Order order = new Order(flowerID, quatity * fm.arr.get(i).getUnitPrice(), quatity, flowerID, fm.arr.get(i).getName(), fm.arr.get(i).getUnitPrice(), LocalDate.MAX);
                    File f2 = new File("orderTemp.txt");
                    try ( FileWriter fw = new FileWriter(f2, true);  PrintWriter pw = new PrintWriter(fw)) {

                        pw.println(order.getOrderID() + "," + order.getDate() + "," + order.getFlowerID() + "," + quatity + "," + order.getName() + "," + order.getTotalPrice() + "," + id);

                        System.out.println("Add successfully");
                        fw.close();
                        pw.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                }

            }
        }

    }

    public void addOrderFromFile() {
        List<Order> arr = new ArrayList<>();
        try {
            File f = new File("orderTemp.txt");
            if (!f.exists()) {
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String details;
            FlowerManager fm = new FlowerManager();
            while ((details = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ",");
                String orderID = stk.nextToken();
                LocalDate date = LocalDate.parse(stk.nextToken());
                String flowerID = stk.nextToken();
                int quatity = Integer.parseInt(stk.nextToken());
                String flowerName = stk.nextToken();
                double totalPrice = Double.parseDouble(stk.nextToken());
                arr.add(new Order(orderID, totalPrice, quatity, flowerID, flowerName, 0, date));
            }
            fr.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    public void printV1(String id) {
//        new OrderManager().addOrderFromFile();
//            Order.
//            System.out.printf("#%25s#%25s#%25s#", order.getOrderID(), order.getDate(), id);
//    }
    public void printV2(){
        new OrderManager().addOrderFromFile();
        List<Order> arr = new ArrayList<>();
        for (Order order : arr) {
            order.printV1();
            
        }
                
    }
}

//    public void addToCart(String fFlower, String ortherID,int quality) {
//        
//        try {
//            File f = new File(fFlower);
//            if (!f.exists()) {
//                return;
//            }
//            FileReader fr = new FileReader(f);
//            BufferedReader bf = new BufferedReader(fr);
//            for (int i = 0; i < arr.size(); i++) {
//                if (arr.get(i).getFlowerID().equals(ortherID)) {
////                    if (arr.get(i).getQuality() == 0) {
////                        arr.get(i).setQuality(quality,0);
////                    } else {
////                        arr.get(i).setQuality(quality);
////                    }
//                    arr.get(i).setQuatity(quality);
//                }
//                
//            }
//            
//            fr.close();
//            bf.close();
//        } catch (Exception e) {
//        }
//    }

