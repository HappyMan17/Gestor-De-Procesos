/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondeproyectos;

//import java.util.ArrayList;
//import java.util.Collections;
import java.util.LinkedList;
//import java.util.Objects;

/**
 *
 * @author happy
 */
public class MoneyRegister extends Person{
    //Attibutes
    private Double defaultCash;
    protected LinkedList<Sells> sells;
    private Double taxes;
    private Double clientPayback;
    
    //Builder
    public MoneyRegister(String name, Double defaultCash){
        this.name = name;
        this.defaultCash = defaultCash;
        sells = new LinkedList<>();
        clientPayback = 0.0;
    }
    
    //Methods
    
    public void addSell(String clientName){
        System.err.println("Llegamos");
        Sells sell = new Sells(clientName, name);
        System.err.println("Seguimos"); ///----------
        sells.addFirst(sell);
    }
    
    public void addProductToSell(Product product){
        sells.getFirst().addProduct(product);
    }
    
    /**
     * Retorna true si el dinero en caja alcanza para dar devuelta y false 
     * si no es así.
     * @param clientCash Double
     */
    public Boolean isItEnough(Double clientCash){
        if( sells.getFirst().calculateTotalSell() > clientCash ){
            return false;
        }else {
            defaultCash += clientCash;
            clientPayback = clientCash - sells.getFirst().calculateTotalSell();
            return true;
        }
    }
    
    /**
     * Retorna el total en devuelta.
     * @param clientCash Double
     */
    public Double getPayback(Double clientCash){
        defaultCash -= clientPayback;
        return clientPayback;
    }
    
    /**
     * Retorna el cliente con mayor compra y el total de la misma.
     */
    public String getHigherSellClient(){
        Double higher = 0.0;
        Sells sell = sells.get(0); //Jummmmm
        for( int sellNumber = 1; sellNumber < sells.size(); ++sellNumber ){
            if( sells.get(sellNumber).getTotalSell() > sells.get(sellNumber-1).getTotalSell()){
                higher = sells.get(sellNumber).getTotalSell();
                sell = sells.get(sellNumber);
            }else {
                higher = sells.get(sellNumber-1).getTotalSell();
                sell = sells.get(sellNumber-1);
            }
        }
        return sell.getClientName()+" con "+sell.getTotalSell();
    }
}
