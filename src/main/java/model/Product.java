/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
//deklarasi string, int, double
public class Product {
   private String id;
   private String name;
   private int price;
   private double diskon;
   private int total;
//mengatur fungsu get price
    public int getPrice() {
        return price;
    }
//mengatur fungsi set price
    public void setPrice(int price) {
        this.price = price;
    }
//mengatur fungsi get Diskon
    public double getDiskon() {
        return diskon;
    }
//mengatur fungsi set Diskon
    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }
//mengatur fungsi getTotal
    public int getTotal() {
        return total;
    }
//mengatur fungsi setTotal
    public void setTotal() {
        this.total = (int) (price - price * diskon);
    }
//mengatur fungsi getId
    public String getId() {
      return id;
    }
//mengatur fungsi setId
    public void setId(String id) {
      this.id = id;
    }
//mengatur fungsi getName
    public String getName() {
      return name;
    }
//mengatur fungsi setName
    public void setName(String name) {
      this.name = name;
    }
}
