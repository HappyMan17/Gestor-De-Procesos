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
    private Double afterDiscount;
    private String discount;
    private Double cashCollection;
    private Double checkCollection;
    private Double debitCardCollection;
    private Double creditCardCollection;
    private Double CreditCollection;
            
    //Constructor
    public Sells(String clientName, 
        String moneyRegisterName){
        products = new ArrayList<>();
        this.clientName = clientName;
        this.moneyRegisterName = moneyRegisterName;
        totalSell = 0.0;
        taxes = 0.0;
        afterDiscount = 0.0;
    }
    
    //Methods
    /**
     * Retorna el nombre del cliente que realizó la compra.
     */
    public String getClientName(){
        return clientName;
    }
    
    public void addProduct(Product product){
        products.add(product);
    }
    
    /**
     * Retorna el nombre del cajero que realizó la venta.
     */
    public String getMoneyRegisterName(){
        return moneyRegisterName;
    }
    
    /**
     * Calcula el monto total a pagar por la compra de los productos con su 
     * descuento.
     * @param paymentMethod
     * @return 
     */
    public void calculateDiscount(int paymentMethod){
        switch(paymentMethod){
            case 1: //Efectivo 20%
                totalSell = calculateTotalSell()*0.80;
                discount = "20%";
                cashCollection = calculateTotalSell()*0.80;; 
            case 2: //Cheque 15%
                totalSell = calculateTotalSell()*0.85;
                discount = "15%";
                checkCollection = calculateTotalSell()*0.85;
            case 3: //Tarjeta débito 17%
                totalSell = calculateTotalSell()*0.83;
                discount = "17%";
                debitCardCollection = calculateTotalSell()*0.83;
            case 4: //Tarjeta crédito 10%
                totalSell = calculateTotalSell()*0.90;
                discount = "10%";
                creditCardCollection = calculateTotalSell()*0.90;
            case 5: //A crédito 0%
                totalSell = calculateTotalSell();
                discount = "0%";
                CreditCollection = calculateTotalSell();
        }
    }
    
    /**
     * Calcula el total de la venta antes del descuento. Sumatoria de los 
     * precios de los productos a comprar.
     */
    public Double calculateTotalSell(){
        for( Product product : products ){
            afterDiscount += product.getPrice();
            
            calculatetaxes(product);
            
        }
        return afterDiscount;
    }
    
    /**
     * Calcula el IVA por cada producto comprado y las va acumulando 
     * en el atributo "taxes".
     * @param product
     */
    public void calculatetaxes(Product product){
        if(product.getKind()){
            taxes += product.getPrice()*0.25;
        }else {
            taxes += product.getPrice()*0.19;
        }
    }
    
    /**
     * Retorna el total de la venta antes de impuesto.
     * @return 
     */
    public Double getTotalSell(){
        return totalSell;
    }
    
    public Double getSellAfterDiscount(){
        return afterDiscount;
    }
    
    public String getDiscount(){
        return discount;
    }
    
    /**
     * Retorna el acumulado en IVA hasta el momento.
     */
    public Double getTaxes(){
        return taxes;
    }

    public Double getCashCollection() {
        return cashCollection;
    }

    public Double getCheckCollection() {
        return checkCollection;
    }

    public Double getDebitCardCollection() {
        return debitCardCollection;
    }

    public Double getCreditCardCollection() {
        return creditCardCollection;
    }

    public Double getCreditCollection() {
        return CreditCollection;
    }
}
