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
import java.util.Vector;
import models.Account;

/**
 *
 * @author NguyenDuy
 */
public class AccountManager extends Vector<Account> {

    public List<Account> arr = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public AccountManager() {
        super();
    }

    public void addAccountFromFile(String fAccount) {
        try {
            File f = new File(fAccount);
            if (!f.exists()) {
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String details;
            while ((details = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ",");
                String accountID = stk.nextToken();
                String password = stk.nextToken();
                String role = stk.nextToken();
                String customerID = stk.nextToken();

                arr.add(new Account(accountID, password, role, customerID));
            }
            fr.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void saveAccountToFile(String fAcc) {
        if (arr.size() == 0) {
            System.out.println("Empty list");
            return;
        }
        try {
            File f = new File(fAcc);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Account x : arr) {
                pw.println(x.getAccountID() + "," + x.getPassword() + "," + x.getRole() + "," + x.getCustomerID());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public int findAccount(String fID) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getAccountID().equals(fID)) {
                return i;
            }
        }
        return -1;
    }

//    public void updateAccount(String id, String fAcc, String fCus) {
//        try ( Scanner accScanner = new Scanner(new File(fAcc));  Scanner cusScanner = new Scanner(new File(fCus));  PrintWriter pw = new PrintWriter(new FileWriter(fCus + "_temp.txt"))) {
//
//            boolean isFound = false;
//
//            while (accScanner.hasNextLine()) {
//                String line = accScanner.nextLine();
//                String[] tokens = line.split(",");
//
//                if (tokens.length >= 4 && tokens[0].equals(id)) {
//                    isFound = true;
//
//                    while (cusScanner.hasNextLine()) {
//                        String replaceFile = cusScanner.nextLine();
//                        String[] newTokens = replaceFile.split(",");
//
//                        if (newTokens[0].equals(tokens[3])) {
//                            System.out.println("Found account to update!");
//                            String customerId = newTokens[0];
//                            System.out.println("Input name");
//                            String name = sc.nextLine();
//                            System.out.println("Input address");
//                            String address = sc.nextLine();
//                            System.out.println("Input phone");
//                            String phone = sc.nextLine();
//
//                            // Write updated customer details to temporary file
//                            pw.println(replaceFile
//                                    .replace(newTokens[0], customerId)
//                                    .replace(newTokens[1], name)
//                                    .replace(newTokens[2], address)
//                                    .replace(newTokens[3], phone));
//                        } else {
//                            // Write unchanged customer details to temporary file
//                            pw.println(replaceFile);
//                        }
//                    }
//
//                    // Replace original customer file with temporary file
//                    File tempFile = new File(fCus + "_temp.txt");
//                    Path source = tempFile.toPath();
//                    Path dest = new File(fCus).toPath();
//                    Files.move(source, dest, StandardCopyOption.REPLACE_EXISTING);
//
//                    System.out.println("Update successfully");
//
//                    break;
//                }
//            }
//
//            if (!isFound) {
//                System.out.println("Can't find the account ID!");
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
    public void updateAccount(String id, String fAcc, String fCus) {
        boolean isFound = false;

        try ( Scanner scanner = new Scanner(new File(fAcc));  Scanner scannerFile = new Scanner(new File(fCus));  PrintWriter pw = new PrintWriter(new FileWriter(fCus + "_temp.txt"))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] tokens = line.split(",");
                if (tokens.length >= 4 && tokens[0].equals(id)) {
                    isFound = true;

                    while (scannerFile.hasNextLine()) {
                        String replaceFile = scannerFile.nextLine();
                        String[] newTokens = replaceFile.split(",");
                        if (newTokens[0].equals(tokens[3])) {
                            System.out.println("Found account to update!");
                            String customerId = newTokens[0];
                            System.out.println("Input name");
                            String name = sc.nextLine();
                            System.out.println("Input address");
                            String address = sc.nextLine();
                            System.out.println("Input phone");
                            String phone = sc.nextLine();

                            
                            pw.println(customerId + "," + name + "," + address + "," + phone);
                        } else {
                           
                            pw.println(replaceFile);
                        }
                    }
                    
                }
            }

            if (!isFound) {
                System.out.println("Can't find the account ID!");
            }
            pw.close();
            scanner.close();
            scannerFile.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        try ( Scanner scannerFileTemp = new Scanner(new File(fCus + "_temp.txt"));  PrintWriter pwf = new PrintWriter(new FileWriter(fCus))) {

            File tempFile = new File(fCus + "_temp.txt");
            while (scannerFileTemp.hasNextLine()) {
                String scannerTemp = scannerFileTemp.nextLine();
                pwf.printf("%s\n", scannerTemp);
            }
            System.out.println("Update successfully");
            pwf.close();
            scannerFileTemp.close();
            tempFile.deleteOnExit();
            
        } catch (Exception e) {
        }
    }
}
