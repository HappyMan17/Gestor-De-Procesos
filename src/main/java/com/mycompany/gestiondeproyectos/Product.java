/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondeproyectos;

/**
 *
 * @author happy
 */
public class Product {
    //Attributes
    private Double price;
    private int amount;
    private Boolean isImported;
    
    //Builder
    public Product(){
        price = 0.0;
        amount = 0;
        isImported = false;
    }
    public Product(int amount, Boolean isImported){
        price = 0.0;
        this.amount = amount;
        this.isImported = isImported;
    }
    //Methods
    public void setPrice(Double newPrice){
        price = newPrice;
    }
    public Double getPrice(){
        return price;
    }
    public void setAmount(int newAmount){
        amount = newAmount;
    }
    public int getAmount(){
        return amount;
    }
    public Boolean getKind(){
        return isImported;
    }
}
