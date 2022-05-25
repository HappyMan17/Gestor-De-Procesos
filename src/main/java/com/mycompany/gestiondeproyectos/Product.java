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
    private String productName;
    private Double price;
    private int amount;
    private Boolean isImported;
    
    //Builder
    public Product(){
        productName = "";
        price = 0.0;
        amount = 0;
        isImported = false;
    }
    public Product(String productName, Double price, int amount, Boolean isImported){
        this.price = price;
        this.amount = amount;
        this.isImported = isImported;
        this.productName = productName;
    }
    //Methods
    /**
     * @param newPrice. Nuevo precio para el producto.
     * Asigna el precio ingresado al producto.
     */
    public void setPrice(Double newPrice){
        price = newPrice;
    }
    
    /**
     * Retorna el precio que tiene el producto.
     */
    public Double getPrice(){
        return price;
    }
    /**
     * @param newAmount. Nueva cantidad que se tiene del producto.
     * Asigna la cantidad de producto que hay.
     */
    public void setAmount(int newAmount){
        amount = newAmount;
    }
    
    /**
     * Retorna la cantidad de producto que hay.
     */
    public int getAmount(){
        return amount;
    }
    
    /**
     * Retorna true si es importado y false si no es así.
     */
    public Boolean getKind(){
        return isImported;
    }
    
    /**
     * Retorna el nombre del producto.
     */
    public String getName(){
        return productName;
    }
}
