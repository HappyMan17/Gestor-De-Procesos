/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondeproyectos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author happy
 */
public class Supplier {
    private int nit;
    private String name;
    private ArrayList<Product> products = new ArrayList<>();
    
    //Constructor
    public Supplier( String name, int nit, ArrayList<Product> products ){
        this.name = name;
        this.nit = nit;
        this.products = products;
    }
    /**
     * Retorna El array de los productos que tiene el proveedor.
    */
    //public ArrayList<Product> sellproducts(){
    public Product sellproducts(int number){
        return products.get(number);
    }
    
    public void seeProducts(){
        int number = 0;
        for(Product product : products){
            System.out.println(number+". "+product.getName());
            ++number;
        }
    }
    
    public int getNit(){
        return nit;
    }
    
    public String getName(){
        return name;
    }
    
    public void createProduct(){
        String name = "";
        Double price = 0.0;
        int amount = 0;
        Boolean isImported;
        Scanner sc = new Scanner(System.in);
        System.out.print("Product name: ");
        name = sc.nextLine();
        System.out.print("Price: ");
        price = sc.nextDouble();
        System.out.print("Amount: ");
        amount = sc.nextInt();
        System.out.println("Is it imported?");
        System.out.println("false. No");
        System.out.println("true. yes");
        isImported = sc.nextBoolean();
        Product product = new Product(name, price, amount, isImported);
        products.add(product);
    }
    public void removeProduct(int number){
        products.remove(number);
    }
}
