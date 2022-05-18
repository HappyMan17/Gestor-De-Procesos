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
public class UvStore {
    //Attributes
    private ArrayList<Supplier> suppliers = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<MoneyRegister> moneyRegister = new ArrayList<>();
    
    //Builder
    public UvStore(ArrayList<Supplier> supplier, ArrayList<Product> products, 
        ArrayList<Client> clients, ArrayList<MoneyRegister> moneyRegister){
        this.suppliers = supplier;
        this.products = products;
        this.clients = clients;
        this.moneyRegister = moneyRegister;
    }
    
    //Methods
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
