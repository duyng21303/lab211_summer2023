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
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import models.Staff;

/**
 *
 * @author NguyenDuy
 */
public class StaffManager extends Staff{
    private List<Staff> arr = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    
    public StaffManager(String staffID, String name, String address, int phone) {
        super(staffID, name, address, phone);
    }
    public void addStaffFromFile(String fStaff) {
        try {
            File f = new File(fStaff);
            if (!f.exists()) {
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String details;
            while ((details = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ",");
                String staffID = stk.nextToken();
                String name = stk.nextToken();
                String address = stk.nextToken();
                long phone = Long.parseLong(stk.nextToken());
                
                arr.add(new Staff(staffID, name, address, phone));
            }
            fr.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public void saveStaffToFile(String fStaff) {
        if (arr.size() == 0) {
            System.out.println("Empty list");
            return;
        }
        try {
            File f = new File(fStaff);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Staff x : arr) {
                pw.println(x.getStaffID()+ "," + x.getName()+ "," + x.getAddress()+ "," + x.getPhone());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
