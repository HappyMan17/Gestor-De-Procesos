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
    Controlador(UvStore store){
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
        System.out.println("4. Money register admin.");
        System.out.println("5. leave.");
        opcion = sc.nextByte();
        switch(opcion){
            case 1: productMenu();
                break;
            case 2: supplierMenu();
                break;
            case 3: clientMenu();
                break;
            case 4: moneyRegisterMenu();
                break;
        }
        
        }while (opcion != 5);
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
    public void moneyRegisterMenu(){
        byte opcion = 0;
        Scanner sc = new Scanner(System.in);
        do{ 
            
            System.out.println("Company management of "+store.getName());
            System.out.println("What do you want to do?");
            System.out.println("1. Add a money register.");
            System.out.println("2. Remove money register.");
            System.out.println("3. See money registers.");
            System.out.println("4. leave.");
            opcion = sc.nextByte();
            switch(opcion){
                case 1: store.setMoneyRegister();
                    System.out.println("Money register add");
                    break;
                case 2: store.removeMoneyRegister();
                    System.out.println("money register removed");
                    break;
                case 3: store.seeMoneyRegister();
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
                    System.out.println("Product add");
                    break;
                case 2: store.removeProduct();
                    System.out.println("Paso 2");
                    break;
                case 3: store.seeSupplier();
                    break;
            }
        
        }while (opcion != 4);
    }
}
