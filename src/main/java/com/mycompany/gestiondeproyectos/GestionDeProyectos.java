/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.gestiondeproyectos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author happy
 */
public class GestionDeProyectos{

    public static void main(String[] args) {
        //creación de los productos
        Product p1 = new Product("H2OH", 2500.0, 4, false);
        Product p2 = new Product("Risadas Pollo", 2000.0, 6, false);
        Product p3 = new Product("Coca Cola", 2500.0, 4, true);
        Product p4 = new Product("Pringles", 10000.0, 6, true);
        
        //Productos del primer proveedor
        ArrayList<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        
        //Productos del segundo proveedor
        ArrayList<Product> products2 = new ArrayList<>();
        
        //Creación de los proveedores
        Supplier s1 = new Supplier("Supplier 1", 1020204, products);
        Supplier s2 = new Supplier("Supplier 2", 220505080, products2);

        //Creación del cajero
        MoneyRegister moneyRegister = new MoneyRegister("Camilo", 5000.0);        
        
        //Creación de la tienda
        UvStore store = new UvStore("Univalle Store");
        store.setSupplier(s1);
        store.setSupplier(s2);
        store.setMoneyRegister(moneyRegister);
        
        store.buyProducts();
        Controlador controlador = new Controlador(store);
        
        byte opcion = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Identify yourself");
        do{
            System.out.println("1. Client.");
            System.out.println("2. Admin.");
            System.out.println("3. record purchases and sales.");
            System.out.println("4. endShift."); 
            System.out.println("5. Exit.");
            opcion = sc.nextByte();
            switch(opcion){
                case 1: controlador.letsBuy();
                    break;
                case 2: controlador.start();
                    break;
                case 3: controlador.purchasesAndSells();
                    break;
                case 4: controlador.endShift();
                    break;
            }
        }while(opcion != 5);
    }
}
