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
public class Person {
    //Attributes
    protected String name;
    
    //Methods
    /**
     * Asigna el nombre de la persona.
     * @param newName
     */
    public void setName(String newName){
        name = newName;
    }
    
    /**
     * Retorna el nombre de la persona.
     */
    public String getName(){
        return name;
    }
}
