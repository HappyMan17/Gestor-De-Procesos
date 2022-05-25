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
    
    //Constructor
    public Controlador(UvStore store){
        this.store = store;
    }
    
    //Methods
    /**
     * Imprime las opciones principales del programa y permite acceder a otros
     * menus.
     */
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
    }
    
    /**
     * Imprime el menú con las acciones relacionadas con los productos
     */
    public void productMenu(){
        byte opcion = 0;
        Scanner sc = new Scanner(System.in);
        do{ 
            
            System.out.println("Company management of "+store.getName());
            System.out.println("What do you want to do?");
            System.out.println("1. Add a product.");
            System.out.println("2. Remove a product.");
            System.out.println("3. See products.");
            System.out.println("4. Buy product.");
            System.out.println("5. leave.");
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
                case 4: store.buyProducts();
                break;
            }
        
        }while (opcion != 5);
    }
    
    /**
     * Imprime el menú con las acciones relacionadas con los clientes
     */
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
    
    /**
     * Imprime el menú con las acciones relacionadas con los proveedores.
     */
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
    
    /**
     * Imprime el menú con las acciones relacionadas con los productos
     */
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
            //opcion vs products.size()
            store.moneyRegister.addProductToSell(store.sellProduct(opcion));
            System.out.println("Do you want to buy another product?: (true/false)");
            keepGoing = sc.nextBoolean();
        }while(keepGoing);
        //Seleccionar metodo de pago / opcion = metodo de pago
        paymentMethodMenu();
    }
    
    /**
     * Permite escoger el método de pago e imprime total a pagar, impuestos,
     * descuentos y total neto.
     */
    public void paymentMethodMenu(){
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the payment method: \n"
            +"1. Cash\n"
            +"2. Check\n"
            +"3. Debit Card\n"
            +"4. Credit Card\n"
            +"5. Credit\n");
        number = sc.nextInt();
        store.moneyRegister.sells.get(0).calculateDiscount(number);
        System.out.println("----------------------------------------\n"+
            "Sale value: "
            +store.moneyRegister.sells.get(0).getSellAfterDiscount()
            +"\nTaxes value: "
            +store.moneyRegister.sells.get(0).getTaxes()
            +"\nDiscount: "
            +store.moneyRegister.sells.get(0).getDiscount()
            +"\nNet sale value: "
            +store.moneyRegister.sells.get(0).getTotalSell()+"\n");
        if(number == 1){
            Double cash;
            do{
                System.out.println("How much do you have: ");
                cash = sc.nextDouble();
            }while(!store.moneyRegister.isItEnough(cash));
            //Revisar cuando sobre pasa lo que hay en caja
            System.out.println(
                "----------------------------------------\n"+
                "Payback: "+store.moneyRegister.getPayback()
                +"\n----------------------------------------");
        }
        System.out.println("Have a nice day!");
    }
    
    /**
     * Imprime las ventas realizadas por la tienda.
     */
    public void purchasesAndSells(){
        String clientSells = "\nSells:\n";
        String supplierPurchases = "\nPurchases:\n";
        Sells sellObject;
        Supplier supObject;
        System.out.println("\nCompany management of "+store.getName());
        for( int number = 0; number < store.moneyRegister.sells.size(); 
            ++number){
            sellObject = store.moneyRegister.sells.get(number);
            clientSells += sellObject.getClientName()+": "
                +sellObject.getTotalSell()+
                "\n-----------------------------";
        }
        System.out.println(clientSells);
    }
    
    public void endShift(){
        /*
        Total de recaudo por cada forma de pago.
        Nombre de los clientes que efectuaron la mejor compra y el monto de ésta.
        */
        System.out.println("Company management of "+store.getName());
        System.out.println("Total sold: "+store.moneyRegister.getTotalSell());
        store.moneyRegister.totalForPayMethod();
        System.out.println("Higher sell: "
            +store.moneyRegister.getHigherSellClient());
        System.out.println("Total taxes: "+store.moneyRegister.getTotalTaxes());
        System.out.println("Total cash on store: "
            +store.moneyRegister.getDefaultCash());
        
    }
}
