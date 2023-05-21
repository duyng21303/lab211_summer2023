/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import models.Account;
import models.Flower;

/**
 *
 * @author NguyenDuy
 */
public class FlowerManager extends Vector<Flower> {
    
    public List<Flower> arr = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    Calendar calendar = Calendar.getInstance();
    protected LocalDate date = LocalDate.of(
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH) + 1, // Tháng bắt đầu từ 0 nên cần cộng thêm 1
            calendar.get(Calendar.DAY_OF_MONTH)
    );
    public FlowerManager() {
        super();
    }
    
    public void addFlowerFromFile(String fFlower) {
        try {
            File f = new File(fFlower);
            if (!f.exists()) {
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while ((details = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ",");
                
                String flowerID = stk.nextToken().toUpperCase();
                String name = stk.nextToken().toUpperCase();
                double unitPrice = Double.parseDouble(stk.nextToken());
                String dateString = stk.nextToken();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDate importDate = LocalDate.parse(dateString, formatter);
                Flower emp = new Flower(flowerID, name, unitPrice, importDate);
                arr.add(emp);
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void saveFlowerToFile(String fFlower) {
        if (arr.size() == 0) {
            System.out.println("Empty list");
            return;
        }
        try {
            File f = new File(fFlower);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Flower x : arr) {
                pw.println(x.getFlowerID() + "," + x.getName() + "," + x.getUnitPrice() + "," + x.getImportDate());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    private int findFlower(String fID) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getFlowerID().equals(fID)) {
                return i;
            }
        }
        return -1;
    }
    
    public void addNewEmpFlower() {
        String flowerID, name;
        double unitPrice;
        LocalDate importDate;
        int pos;
        boolean valid = true;
        System.out.println("Enter new flower. Detail: ");
        do {
            System.out.println("  code E000:");
            flowerID = sc.nextLine().toUpperCase();
            pos = findFlower(flowerID);
            valid = flowerID.matches("E\\d(3)$");
            if (pos >= 0) {
                System.out.println(" The code is duplicated");
            }
            if (!valid) {
                System.out.println(" The code: E and 3 digits");
            }
        } while (pos >= 0 || (!valid));
        String dateString = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(" name:");
        name = sc.nextLine().toUpperCase();
        System.out.println(" unit price:");
        unitPrice = Double.parseDouble(sc.nextLine());
        System.out.println(" import date");
        importDate = LocalDate.parse(dateString, formatter);
        arr.add(new Flower(flowerID, name, unitPrice, importDate));
        System.out.println("New flower has been added");
    }
    
    public void removeEmpFlower() {
        String fID;
        System.out.println("Enter the ID of remove flower: ");
        fID = sc.nextLine().toUpperCase();
        int pos = findFlower(fID);
        if (pos < 0) {
            System.out.println("This code does not exist");
        } else {
            arr.remove(pos);
            System.out.println("The flower " + fID + " has been removed");
        }
    }
    
    public void printFlower() {
        for (Flower flower : arr) {
            flower.print();
        }
    }
//    public void printToCart(){
//        System.out.printf("#%25s#%25s#%25s#\n", arr., "Date", "BuyID");
//    }
    public void addToCart(String fFlower, String ortherID,int quality) {
        
        try {
            File f = new File(fFlower);
            if (!f.exists()) {
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getFlowerID().equals(ortherID)) {
//                    if (arr.get(i).getQuality() == 0) {
//                        arr.get(i).setQuality(quality,0);
//                    } else {
//                        arr.get(i).setQuality(quality);
//                    }
                    arr.get(i).setQuatity(quality);
                }
                
            }
            
            fr.close();
            bf.close();
        } catch (Exception e) {
        }
    }
    public void printCart(String id,String ortherID){
        for (Flower flower : arr) {
            if(flower.getFlowerID().equals(ortherID)){
                flower.printCart(id);
            }
            
        }
    }
    public void printCartV2(String id, String ortherID){
        for (Flower flower : arr) {
            if(flower.getFlowerID().equals(ortherID)){
                flower.printCartV2(id);
            }
            
        }
    }
}
