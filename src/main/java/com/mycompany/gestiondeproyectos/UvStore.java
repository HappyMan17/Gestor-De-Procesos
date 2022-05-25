/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondeproyectos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
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
    protected LinkedList<Client> clients;
    protected MoneyRegister moneyRegister;
    
    //Constructor
    public UvStore(String companyName){
        this.companyName = companyName;
        suppliers = new ArrayList<>();
        products  = new ArrayList<>();
        clients  = new LinkedList<>();
    }
    
    //Methods
    /**
     * Retorna el nombre o razón social de la compañia
     */
    public String getName(){
        return companyName;
    }
    
    /**
     * Añade un proveedor a la compañía
     */
    public void setSupplier(Supplier newSupplier){
        suppliers.add(newSupplier);
    }
    
    /**
     * Crea un proveedor en para la compañia
     */
    public void createSupplier(){
        int nit = 0;
        ArrayList<Product> products = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Supplier nit: ");
        nit = sc.nextInt();
        Supplier supplierNew = new Supplier(nit,products);
        supplierNew.createProduct();
    }
    
    public void seeSupplier(){
        int number = 0;
        for(Supplier supplier : suppliers){
            System.out.println(number+". "+supplier.getNit());
            ++number;
        }
    }
    
    /**
     * Crea y añade un cliente
     */    
    public void setClient(){
        String name = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("Client name: ");
        name = sc.nextLine();
        Client client = new Client(name);
        clients.addFirst(client);
        System.err.println("Añadido");
    }
    
    /**
     * Elimina uno de los clientes.
     */
    public void removeClient(){
        System.out.println("Choose the client to remove it: ");
        seeClients();
        int client;
        Scanner sc = new Scanner(System.in);
        client = sc.nextInt();
        clients.remove(client); //Probar
    }
    
    /**
     * Retorna un listado con los clientes.
     */
    public void seeClients(){
        int number = 0;
        for(Client client : clients){
            System.out.println(number+". "+client.getName());
            ++number;
        }
    }
    
    public Client getClient(){
        return clients.getFirst();
    }
    
    /**
     * Asigna un cajero
     */
    public void setMoneyRegister(MoneyRegister m1){
        moneyRegister = m1;
    }
    
    /**
     * Añade un producto a la tienda.
     */
    public void setProduct(){
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
    
    /**
     * Elimina un producto de la tienda
     */
    public void removeProduct(){
        System.out.println("Choose the product to remove it: ");
        seeProducts();
        int product;
        Scanner sc = new Scanner(System.in);
        product = sc.nextInt();
        products.remove(product);
    }
    
    /**
     * Retorna un listado con los productos en la tienda.
     */
    public void seeProducts(){
        int number = 0;
        for(Product product : products){
            System.out.println("\n"+number+". "+product.getName());
            ++number;
        }
    }
    
    
    public Product sellProduct(int number){
        if(products.get(number).getAmount()>=1){
            products.get(number).setAmount(products.get(number).getAmount()-1);
            return products.get(number);
        }else{
            System.out.println("Out of Stock");
            products.remove(number);
        }
        return products.get(number);
    }
    /*
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
    */
    public void buyProducts(){
        //int opcion = 0;
        int number = 0;
        int productNumber = 0;
        Boolean keepGoing = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a supplier: ");
        
        for(Supplier supplier : suppliers){
            System.out.println(number+". "+supplier.getNit());
            ++number;
        }
        number = sc.nextInt();
        do{
            System.out.println("Choose a product: ");
            suppliers.get(number).seeProducts();
            productNumber = sc.nextInt();
            products.add(suppliers.get(number).sellproducts(productNumber));
            System.out.println("Do you wanna buy another: (true/false) ");
            keepGoing = sc.nextBoolean();
            suppliers.get(number).removeProduct(productNumber);
        }while(keepGoing);
    }
    
}
