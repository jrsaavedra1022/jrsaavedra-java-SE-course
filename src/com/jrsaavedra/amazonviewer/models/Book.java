/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrsaavedra.amazonviewer.models;

//imports
import com.jrsaavedra.util.AmazonUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * <h1>Book </h1>
 * Hereda de {@link Publication} 
 * Implementa de {@link IVisualizable} 
 * 
 * @author jrsaavedra
 * @version 1.0
 * @since 2020
*/
public class Book extends Publication implements IVisualizable {

    // Attributes
    private int id;
    private String isbn;
    private boolean readed;
    private int timeReaded;
    private ArrayList<Page> pages;
    //constructor
    public Book() {
    }
    //oonstructor sobrecargado

    public Book(String title, Date edititionDate, String editorial, String[] authors, String isbn, ArrayList<Page> pages) {
        super(title, edititionDate, editorial, authors);
        this.isbn = isbn;
        this.pages = pages;
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
        if (readed == true) {
            return "Si";
        } else {
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

    public ArrayList<Page> getPages() {
        return pages;
    }

    public void setPages(ArrayList<Page> pages) {
        this.pages = pages;
    }
    
    

    @Override
    public String toString() {
        return "..:: BOOK ::.."
                + "\n Title:  " + getTitle()
                + "\n Fecha de editorial: " + getEdititionDate()
                + "\n Editorial:  " + getEditorial()
                + "\n Authors: " + Arrays.toString(getAuthors())
                + "\n Is bn:  " + getIsbn();

    }
    /**
     * {@inheritDoc}
    */
    @Override
    public Date startToSee(Date dateI) {
        return dateI;
    }
    /**
     * {@inheritDoc}
    */
    @Override
    public void stopToSee(Date dateI, Date dateF) {
        if (dateF.getTime() > dateI.getTime()) {
            this.setTimeReaded((int) dateF.getTime() - (int) dateI.getTime());
        } else {
            this.setTimeReaded(0);
        }
    }

    // crear lista de libros
    public static ArrayList<Book> makeBooksList() {
        ArrayList<Book> books = new ArrayList();
        String[] authors = new String[3];
        for(int i = 0; i < 3; i++){
            authors[i] = "Author "+i;
        }
        ArrayList<Page> pages = new ArrayList();
        int page = 0;
        for(int i = 0; i <3; i++){
            page = i +1;
            pages.add(new Book.Page(page, "El contenido de la página " + page));
        }
        for (int i = 0; i < 6; i++) {
            books.add(new Book("Libro " + i, new Date(), "Editotial " + 1, authors, "isbn " + i, pages));
        }
        return books;
    }

    public void view() {
        this.setReaded(true);
        Date dateI = this.startToSee(new Date());
        int i = 0;
        OUTER:
        do {
            System.out.println("..........");
            System.out.println("Page " + this.getPages().get(i).getNumber());
            System.out.println(this.getPages().get(i).getContent());
            System.out.println("..........");
            if(i != 0){
                System.out.println("1. Regresar página");
            }
            System.out.println("2. Siguiente página");
            System.out.println("0. Cerrar libro");
            System.out.println("");            
            int response = AmazonUtil.validateUserResponseMenu(0, 2);
            switch (response) {
                case 2:
                    i++;
                    break;
                case 1:
                    i--;
                    break;
                default:
                    break OUTER;
            }
        } while (i < this.getPages().size());
        //Finalizar lectura del libro
        this.stopToSee(dateI, new Date());
        System.out.println("");
        System.out.println("Leiste: " + this.toString());
        System.out.println("Por: " + this.getTimeReaded() + " milisegundos...");
        System.out.println("");
    }
    
    /**
     * Clase Anidada static Page
    */
    public static class Page{
        //Attributes
        private int id;
        private int number;
        private String content;
        
        // Conatructor
        public Page(int number, String content) {
            this.number = number;
            this.content = content;
        }
        
        // Getter and setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
        
        
    }

}
