/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.awt.JobAttributes;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author NguyenDuy
 */
public class Order extends Flower{
    
    protected String orderID;
    Calendar calendar = Calendar.getInstance();
    protected LocalDate date = LocalDate.of(
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH) + 1, // Tháng bắt đầu từ 0 nên cần cộng thêm 1
            calendar.get(Calendar.DAY_OF_MONTH)
    );
    protected Map<String, Integer> flowers = new HashMap<>();
    protected double totalPrice;
    protected int quatity;
    
    public Order(String orderID, double totalPrice, int quatity, String flowerID, String name, double unitPrice, LocalDate importDate) {
        super(flowerID, name, unitPrice, importDate);
        this.orderID = orderID;
        this.totalPrice = totalPrice;
        this.quatity = quatity;
    }

//    public Order(String orderID, double totalPrice, int quatity, int quality) {
//        super(quality);
//        this.orderID = orderID;
//        this.totalPrice = totalPrice;
//        this.quatity = quatity;
//    }

    
//    public Order(String orderID, double totalPrice, String flowerID, String name, LocalDate importDate, int quatity) {
//        super(flowerID, name, importDate);
//        this.orderID = orderID;
//        this.totalPrice = totalPrice;
//        this.quatity = quatity;
//    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Map<String, Integer> getFlowers() {
        return flowers;
    }

    public void setFlowers(String orderID, int quantity) {
        flowers.put(flowerID, quatity);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public void printV1(){
        System.out.printf("#%25s#%25s#%25s#", name, quatity, totalPrice);
    }
    
}
