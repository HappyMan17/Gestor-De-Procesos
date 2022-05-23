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
        System.out.println("1. product management.");
        System.out.println("2. supplier management.");
        System.out.println("3. client management.");
        System.out.println("4. leave.");
        opcion = sc.nextByte();
        switch(opcion){
            case 1: clientMenu();
                break;
            case 2: System.out.println("Paso 2");
                break;
            case 3: System.out.println("Paso 3");
                break;
        }
        
        }while (opcion != 4);
        System.out.println("Gracias!!!!");
    }
    
    public void clientMenu(){
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
                case 2: System.out.println("Paso 2");
                    break;
                case 3: System.out.println("Paso 3");
                    break;
            }
        
        }while (opcion != 4);
    }
}
