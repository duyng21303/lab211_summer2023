/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import controllers.FlowerManager;
import java.time.LocalDate;
import java.util.Calendar;

/**
 *
 * @author NguyenDuy
 */
public class Flower {

    Calendar calendar = Calendar.getInstance();
    protected LocalDate date = LocalDate.of(
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH) + 1, 
            calendar.get(Calendar.DAY_OF_MONTH)
    );
    protected String flowerID;
    protected String name;
    private double unitPrice;
    protected LocalDate importDate;
    protected int quatity;

    public Flower(String flowerID, String name, double unitPrice, LocalDate importDate) {
        this.flowerID = flowerID;
        this.name = name;
        this.unitPrice = unitPrice;
        this.importDate = importDate;
    }

    public Flower(int quality) {
        this.quatity = quality;
    }

    public int getQuatity() {
        return quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity += quatity;
    }

    public String getFlowerID() {
        return flowerID;
    }

    public void setFlowerID(String flowerID) {
        this.flowerID = flowerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public LocalDate getImportDate() {
        return importDate;
    }

    public void setImportDate(LocalDate importDate) {
        this.importDate = importDate;
    }

    @Override
    public String toString() {
        return "Flower{" + "flowerID=" + flowerID + ", name=" + name + ", unitPrice=" + unitPrice + ", importDate=" + importDate + '}';
    }

    public void print() {
        System.out.printf("#%25s#%25s#%25f#%25s#\n", flowerID, name, unitPrice, importDate);
    }

    public void printCart(String id) {

        System.out.printf("#%25s#%25s#%25s#\n", id, date, flowerID);
    }

    public void printCartV2(String id) {

        System.out.printf("#%25s#%25s#%25f#\n", name, quatity, unitPrice * quatity);
    }
}
