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
        Product p1 = new Product("H2OH", 2500.0, 4, false);
        Product p2 = new Product("Risadas Pollo", 2000.0, 6, false);
        Product p3 = new Product("Coca Cola", 2500.0, 4, true);
        Product p4 = new Product("importado", 5000.0, 3, true);
        
        ArrayList<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        
        ArrayList<Product> products2 = new ArrayList<>();
        
        Supplier s1 = new Supplier(1, products);
        Supplier s2 = new Supplier(1, products2);
        
        UvStore store = new UvStore("Univalle Store");
        store.setSupplier(s1);
        store.setSupplier(s2);
        
        Controlador controlador = new Controlador(store);
        
        byte opcion = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Identify yourself");
        System.out.println("1. Client.");
        System.out.println("2. Admin.");
        opcion = sc.nextByte();
        if(opcion == 2){
            controlador.start();
        }else{
            System.out.println("Menú de cliente");
        }
        
        
        
    }
}
