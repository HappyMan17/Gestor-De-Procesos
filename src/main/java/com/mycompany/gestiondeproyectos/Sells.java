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
public class Sells {
    //Attributes
    private ArrayList<Product> products;
    private String clientName;
    private String moneyRegisterName;
    private Double totalSell;
    private Double taxes;
    
    //Builder
    public Sells(ArrayList<Product> products, String clientName, 
        String moneyRegisterName){
        this.products = products;
        this.clientName = clientName;
        this.moneyRegisterName = moneyRegisterName;
        totalSell = 0.0;
        taxes = 0.0;
    }
    
    //Methods
    public String getClientName(){
        return clientName;
    }
    
    public String getMoneyRegisterName(){
        return moneyRegisterName;
    }
    
    public Double calculateDiscount(int paymentMethod){
        switch(paymentMethod){
            case 1: //Efectivo 20%
                totalSell = calculateTotalSell()*0.80;
                return totalSell;
            case 2: //Cheque 15%
                totalSell = calculateTotalSell()*0.85;
                return totalSell;
            case 3: //Tarjeta débito 17%
                totalSell = calculateTotalSell()*0.83;
                return totalSell;
            case 4: //Tarjeta crédito 10%
                totalSell = calculateTotalSell()*0.90;
                return totalSell;
            case 5: //A crédito 0%
                totalSell = calculateTotalSell();
                return totalSell;
        }
        return totalSell;
    }
    
    public Double calculateTotalSell(){
        Double afterDiscount = 0.0;
        for( Product product : products ){
            afterDiscount += product.getPrice();
            calculatetaxes(product);
            
        }
        return afterDiscount;
    }
    
    public Double getTotalSell(){
        return totalSell;
    }
    
    public void calculatetaxes(Product product){
        if(product.getKind()){
            taxes += product.getPrice()*0.25;
        }else {
            taxes += product.getPrice()*0.19;
        }
    }
    
    public Double getTaxes(){
        return taxes;
    }
}
