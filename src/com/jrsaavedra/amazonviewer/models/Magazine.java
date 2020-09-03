/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrsaavedra.amazonviewer.models;

import java.util.Date;

/**
 * <h1>Magazine </h1>
 * Hereda de {@link Publication} 
 * 
 * @author jrsaavedra
 * @version 1.0
 * @since 2020
*/
public class Magazine extends Publication{
    // Attributes
    private int id;
    
    //contructor

 public Magazine() {
    }
    //contructor sobrecargado

   

    public Magazine(String title, Date edititionDate, String editorial, String[] authors) {
        super(title, edititionDate, editorial, authors);
    }
    //methods getter and setters

    public int getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return "..:: MAGAZINE ::.." +
               "\n Title:  " + getTitle();
                
    }
    
}
