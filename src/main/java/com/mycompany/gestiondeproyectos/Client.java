/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondeproyectos;

import java.util.ArrayList;

/**
 *
 * @author happy
 */
public class Client extends Person{
    //Attribute
    private ArrayList<Product> products;
    /**
     *
     * @param name
     */
    public Client(String name){
        this.name = name;
        products = new ArrayList<>();
    }
    //Methods
    public void productToBuy(Product product, int productAmount){
        product.setAmount(productAmount);
        products.add(product);
    }
    public int getProductSize(){
        return products.size();
    }
    public void addProduct(Product product) {
        products.add(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Product getProduct(int number) {
        return products.get(number);
    }
}
