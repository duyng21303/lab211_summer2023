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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import models.Customer;
import models.Staff;

/**
 *
 * @author NguyenDuy
 */
public class CustomerManager extends Customer{
    private List<Customer> arr = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    public CustomerManager(String customerID, String name, String address, long phone) {
        super(customerID, name, address, phone);
    }
    public void addCustomerFromFile(String fCus) {
        try {
            File f = new File(fCus);
            if (!f.exists()) {
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String details;
            while ((details = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ",");
                String customerID = stk.nextToken();
                String name = stk.nextToken();
                String address = stk.nextToken();
                long phone = Long.parseLong(stk.nextToken());
                
                arr.add(new Customer(customerID, name, address, phone));
            }
            fr.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public void saveCustomerToFile(String fCus) {
        if (arr.size() == 0) {
            System.out.println("Empty list");
            return;
        }
        try {
            File f = new File(fCus);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Customer x : arr) {
                pw.println(x.getCustomerID()+ "," + x.getName()+ "," + x.getAddress()+ "," + x.getPhone());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public void print(String id){
        if (arr.size() == 0) {
            System.out.println("Empty list");
            return;
        }
        
        System.out.println("\nEMPLOYEE LIST");
        System.out.println("-----------------------------");
        
        for (Customer customer : arr) {
            if(id.equals(customer.getCustomerID())){
                customer.print();
            }
            
        }
    }
    public void addToCart(){
        
    }
}
