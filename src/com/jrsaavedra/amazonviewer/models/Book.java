/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrsaavedra.amazonviewer.models;

//imports
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Book extends Publication implements IVisualizable{
    // Attributes
    private int id;
    private String isbn;
    private boolean readed;
    private int timeReaded;
    
    //constructor

    public Book() {
    }
  //oonstructor sobrecargado
    public Book(String title, Date edititionDate, String editorial, String[] authors, String isbn) {
        super(title, edititionDate, editorial, authors);
        this.isbn = isbn;
    }

    //Methods getter and setters

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String isReaded() {
        if(readed == true){
            return "Si";
        }else{
            return "No";
        }
    }

    public void setReaded(boolean readed) {
        this.readed = readed;
    }

    public int getTimeReaded() {
        return timeReaded;
    }

    public void setTimeReaded(int timeReaded) {
        this.timeReaded = timeReaded;
    }
    
    @Override
    public String toString() {
        return "..:: BOOK ::.." +
               "\n Title:  " + getTitle() +
               "\n Fecha de editorial: " + getEdititionDate() +
               "\n Editorial:  " + getEditorial() +
               "\n Authors: " + Arrays.toString(getAuthors()) +
               "\n Is bn:  " + getIsbn();
                
    }

    @Override
    public Date startToSee(Date dateI) {
        return dateI;
    }

    @Override
    public void stopToSee(Date dateI, Date dateF) {
        if(dateF.getTime()> dateI.getTime()){
            this.setTimeReaded((int)dateF.getTime()- (int)dateI.getTime());
        }else{
            this.setTimeReaded(0);
        }
    }
    
    // crear lista de libros
    public static ArrayList<Book> makeBooksList(){
        ArrayList<Book> books = new ArrayList();
        for(int i = 0; i < 6; i++){
            books.add(new Book("Libro "+i, new Date(), "Editotial "+1, new String[]{"Pablo Coelo", "Edgar Alan poe"}, "isbn " +i));
        }
        return books;
    }
    
}
