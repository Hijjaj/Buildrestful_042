/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class Product {
   private String id;
   private String name;
   private int price;
   private double diskon;
   private int total;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getDiskon() {
        return diskon;
    }

    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal() {
        this.total = (int) (price - price * diskon);
    }

   
    public String getId() {
      return id;
    }
   
    public void setId(String id) {
      this.id = id;
    }
   
    public String getName() {
      return name;
    }
   
    public void setName(String name) {
      this.name = name;
    }
}
