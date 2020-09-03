/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrsaavedra.amazonviewer.models;

import java.util.Date;

/**
 * <h1>Publication </h1>
 * Publication Clase padre
 * <p>
 * Esta clase es la clase base de la familia Publicstions.
 * 
 * 
 * @author jrsaavedra
 * @version 1.0
 * @since 2020
*/
public class Publication {
    //Attributes
    private String title;
    private Date edititionDate;
    private String editorial;
    private String [] authors;
    
    // contructor

    public Publication() {
    }
    // contructor sobrecargado
    public Publication(String title, Date edititionDate, String editorial, String[] authors) {
        this.title = title;
        this.edititionDate = edititionDate;
        this.editorial = editorial;
        this.authors = authors;
    }
    //Methods getter and setter

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getEdititionDate() {
        return edititionDate;
    }

    public void setEdititionDate(Date edititionDate) {
        this.edititionDate = edititionDate;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }
    
    
    
}
