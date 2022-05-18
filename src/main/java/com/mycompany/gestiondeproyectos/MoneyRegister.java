/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondeproyectos;

//import java.util.ArrayList;
import java.util.LinkedList;
//import java.util.Objects;

/**
 *
 * @author happy
 */
public class MoneyRegister extends Person{
    //Attibute
    private Double defaultCash;
    private LinkedList<Double> sells;
    private LinkedList<Client> clients;
    private Double taxes;
    private Double clientPayback;
    
    //Builder
    public MoneyRegister(String name, Double defaultCash){
        this.name = name;
        this.defaultCash = defaultCash;
        clients = new LinkedList<>();
        taxes = 0.0;
        clientPayback = 0.0;
    }
    
    //Methods
    public void setClient( Client client ){
        clients.addFirst(client);
    }
    
    public Double calculateDiscount(int paymentMethod){
        Double total = 0.0;
        switch(paymentMethod){
            case 1: //Efectivo 20%
                total = calculateTotalSell()*0.80;
                return total;
            case 2: //Cheque 15%
                total = calculateTotalSell()*0.85;
                return total;
            case 3: //Tarjeta débito 17%
                total = calculateTotalSell()*0.83;
                return total;
            case 4: //Tarjeta crédito 10%
                total = calculateTotalSell()*0.90;
                return total;
            case 5: //A crédito 0%
                total = calculateTotalSell();
                return total;
        }
        return total;
    }
    public Double calculateTotalSell(){
        Double totalSell = 0.0;
        for( int product = 0; product < clients.getFirst().getProductSize(); 
            ++product){
            Product clientProduct = clients.getFirst().getProduct(product);
            totalSell += clientProduct.getPrice();
            calculatetaxes(clientProduct);
        }
        sells.addFirst(totalSell);
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
    
    public Boolean isItEnough(Double clientCash){
        if( calculateTotalSell() > clientCash ){
            return false;
        }else {
            defaultCash += clientCash;
            clientPayback = clientCash - calculateTotalSell();
            return true;
        }
    }
    
    public Double getPayback(Double clientCash){
        defaultCash -= clientPayback;
        return clientPayback;
    }
}
