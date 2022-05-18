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
public class Supplier {
    private int number;
    private ArrayList<Product> products = new ArrayList<>();
    
    //Builder
    public Supplier( int number, ArrayList<Product> products ){
        this.number = number;
        this.products = products;
    }
    
    public ArrayList<Product> sellproducts(){
        return products;
    }
    
}
