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
public class UvStore {
    //Attributes
    private String companyName;
    private ArrayList<Supplier> suppliers;
    private ArrayList<Product> products;
    private ArrayList<Client> clients;
    private ArrayList<MoneyRegister> moneyRegister;
    
    //Builder
    public UvStore(String companyName){
        this.companyName = companyName;
        suppliers = new ArrayList<>();
        products  = new ArrayList<>();
        clients  = new ArrayList<>();
        moneyRegister = new ArrayList<>();
    }
    
    //Methods
    public String getName(){
        return companyName;
    }
    
    public void setSupplier(Supplier newSupplier){
        suppliers.add(newSupplier);
    }
    public void setClients(Product newProduct){
        products.add(newProduct);
    }
    public void setClients(Client newClient){
        clients.add(newClient);
    }
    public void setMoneyRegister(MoneyRegister newMoneyRegister){
        moneyRegister.add(newMoneyRegister);
    }
    public void setProduct(){
        String name = "";
        Double price = 0.0;
        int amount = 0;
        Boolean isImported;
        Scanner sc = new Scanner(System.in);
        //Capurar los datos nombres y apellisdo
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
        //Crear un objeto de la clase empleado
        Product product = new Product(name, price, amount, isImported);
        //llamar método agregarEmpleado del objeto empresa
        products.add(product);
    }

    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public ArrayList<MoneyRegister> getMoneyRegister() {
        return moneyRegister;
    }
}
