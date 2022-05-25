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
    private Double clientCash;
    
    //Builder
    public MoneyRegister(String name, Double defaultCash){
        this.name = name;
        this.defaultCash = defaultCash;
        sells = new LinkedList<>();
        clientPayback = 0.0;
        clientCash = 0.0;
    }
    
    //Methods
    /**
     * Crea y añade una venta en el cajero.
     * @param clientName
     */
    public void addSell(String clientName){
        Sells sell = new Sells(clientName, name);
        sells.addFirst(sell);
    }
    
    /**
     * Añade un producto a la ultima venta creada.
     * @param product
     */
    public void addProductToSell(Product product){
        sells.getFirst().addProduct(product);
    }
    
    /**
     * Retorna true si el dinero en caja alcanza para dar devuelta y false 
     * si no es así.
     * @param clientCash Double
     * @return Boolean
     */
    public Boolean isItEnough(Double clientCash){
        if( sells.getFirst().getTotalSell() > clientCash ){
            System.out.println("This isn't enought");
            return false;
        }else {
            this.clientCash += clientCash;
            defaultCash += clientCash;
            clientPayback = clientCash - sells.getFirst().getTotalSell();
            return true;
        }
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
    
    /**
     * Retorna el total en devuelta.
     * @return 
     */
    public Double getPayback(){
        defaultCash -= clientPayback;
        return clientPayback;
    }
    
    /**
     * Retorna el valor de las ventas realizadas hasta el cierre.
     */
    public Double getTotalSell(){
        Double totalSell = 0.0;
        for(Sells sell : sells){
            totalSell += sell.getTotalSell();
        }
        return totalSell;
    }
    
    /**
     * Retorna el valor de lo recaudado en IVA hasta el cierre.
     */
    public Double getTotalTaxes(){
        Double totalTaxes = 0.0;
        for(Sells sell : sells){
            totalTaxes += sell.getTaxes();
        }
        return totalTaxes;
    }
    
    /**
     * Retorna el dinero que hay en caja.
     */
    public Double getDefaultCash(){
        return defaultCash;
    }
    
    public void totalForPayMethod(){
        Double cash = 0.0;
        Double check = 0.0;
        Double debitCard = 0.0;
        Double creditCard = 0.0;
        Double credit = 0.0;
        for(Sells sell : sells){
            cash = sell.getCashCollection();
            check = sell.getCheckCollection();
            debitCard = sell.getDebitCardCollection();
            creditCard = sell.getCreditCollection();
            credit = sell.getCreditCollection();
        }
        System.out.println("Cash: "+cash+"\nCheck: "+check+"\nDebit card: "
            +debitCard+"\nCredit Card: "+creditCard+"\nCredit: "
            +credit+"\n");
    }
}
