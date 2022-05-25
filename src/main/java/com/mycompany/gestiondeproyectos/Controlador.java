/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondeproyectos;

import java.util.Scanner;

/**
 *
 * @author happy
 */
public class Controlador {
    //Attributes
    private UvStore store;
    
    //Builder
    public Controlador(UvStore store){
        this.store = store;
    }
    
    //Methods
    public void start(){
        byte opcion = 0;
        Scanner sc = new Scanner(System.in);
        do{ 
            
        System.out.println("Company management of "+store.getName());
        System.out.println("What do you want to do?");
        System.out.println("1. Product management.");
        System.out.println("2. Supplier management.");
        System.out.println("3. Client management.");
        System.out.println("4. leave.");
        opcion = sc.nextByte();
        switch(opcion){
            case 1: productMenu();
                break;
            case 2: supplierMenu();
                break;
            case 3: clientMenu();
                break;
        }
        
        }while (opcion != 4);
        System.out.println("Gracias!!!!");
    }
    
    public void productMenu(){
        byte opcion = 0;
        Scanner sc = new Scanner(System.in);
        do{ 
            
            System.out.println("Company management of "+store.getName());
            System.out.println("What do you want to do?");
            System.out.println("1. Add a product.");
            System.out.println("2. Remove a product.");
            System.out.println("3. See products.");
            System.out.println("4. leave.");
            opcion = sc.nextByte();
            switch(opcion){
                case 1: store.setProduct();
                    System.out.println("Product add");
                    break;
                case 2: store.removeProduct();
                    System.out.println("Product removed");
                    break;
                case 3: store.seeProducts();
                    break;
            }
        
        }while (opcion != 4);
    }
    public void clientMenu(){
        byte opcion = 0;
        Scanner sc = new Scanner(System.in);
        do{ 
            
            System.out.println("Company management of "+store.getName());
            System.out.println("What do you want to do?");
            System.out.println("1. Add client.");
            System.out.println("2. Remove client.");
            System.out.println("3. See client.");
            System.out.println("4. leave.");
            opcion = sc.nextByte();
            switch(opcion){
                case 1: store.setClient();
                    System.out.println("Client add");
                    break;
                case 2: store.removeClient();
                    System.out.println("Client removed");
                    break;
                case 3: store.seeClients();
                    break;
            }
        
        }while (opcion != 4);
    }
    
    public void supplierMenu(){
        byte opcion = 0;
        Scanner sc = new Scanner(System.in);
        do{ 
            
            System.out.println("Company management of "+store.getName());
            System.out.println("What do you want to do?");
            System.out.println("1. Create supplier.");
            System.out.println("2. Remove supplier.");
            System.out.println("3. See suppliers.");
            System.out.println("4. leave.");
            opcion = sc.nextByte();
            switch(opcion){
                case 1: store.createSupplier();
                    System.out.println("Supplier created");
                    break;
                case 2: store.removeProduct();
                    System.out.println("Supplier removed");
                    break;
                case 3: store.seeSupplier();
                    break;
            }
        
        }while (opcion != 4);
    }
    
    public void letsBuy(){
        store.setClient();
        String name = store.clients.get(0).getName();
        store.moneyRegister.addSell(name);
        byte opcion = 0;
        Boolean keepGoing = true;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Choose a product to buy: ");
            store.seeProducts();
            opcion = sc.nextByte();
            store.moneyRegister.addProductToSell(store.sellProduct(opcion));
            System.out.println("Do you want to buy another product?: (true/false)");
            keepGoing = sc.nextBoolean();
        }while(keepGoing);
        //Seleccionar metodo de pago / opcion = metodo de pago
        System.out.println("Total: "+store.moneyRegister.sells.get(0).calculateDiscount(opcion));
    }
    
}
