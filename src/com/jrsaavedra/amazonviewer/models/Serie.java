/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrsaavedra.amazonviewer.models;

import java.util.ArrayList;
/**
 * <h1>Serie </h1>
 * Hereda de {@link Film} 
 * 
 * @author jrsaavedra
 * @version 1.0
 * @since 2020
*/
public class Serie extends Film{
    // Attributes
    private int id;
    private int sessionQuantity;
    private ArrayList<Chapter> chapter;

    //constructor

    public Serie() {
    }
    // contructor sobrecargado

    public Serie(String title, String genre, String creator, int duration, int sessionQuantity) {
        super(title, genre, creator, duration);
        this.sessionQuantity = sessionQuantity;
    }
    
    
    // methods getters anfd setters

    public int getId() {
        return id;
    }

    public int getSessionQuantity() {
        return sessionQuantity;
    }

    public void setSessionQuantity(int sessionQuantity) {
        this.sessionQuantity = sessionQuantity;
    }

    public ArrayList<Chapter> getChapter() {
        return chapter;
    }

    public void setChapter(ArrayList<Chapter> chapter) {
        this.chapter = chapter;
    }
    
    @Override
    public String toString() {
        return "..:: SERIE ::.." +
               "\n Title:  " + getTitle() +
               "\n Genre:  " + getGenre()+
               "\n Year:  " + getYear() +
               "\n Creator:  " + getCreator()+
               "\n Duration:  " + getDuration();
                
    }
    
    //crear lista de series
    public static ArrayList<Serie> makeSeriesList(){
        ArrayList<Serie> series = new ArrayList();
        for(int i = 1; i < 6; i++){
            Serie serie = new Serie("Serie " + i, "Genero " + i, "Creador " + i, 120 + i, 5);
            serie.setChapter(Chapter.makeChaptersList(serie));
            series.add(serie);
        }
        return series;
    }
/**
     * {@inheritDoc}
    */
    @Override
    public void view() {
        super.setViewed(true);
    }
    
}
