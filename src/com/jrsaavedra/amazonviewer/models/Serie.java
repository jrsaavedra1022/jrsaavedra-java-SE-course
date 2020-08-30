/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrsaavedra.amazonviewer.models;

import java.util.ArrayList;

public class Serie extends Film{
    // Attributes
    private int id;
    private int sessionQuantity;
    private ArrayList<Chapter> chapter;

    //constructor

    public Serie() {
    }
    // contructor sobrecargado

    public Serie(String title, String genre, String creator, int duration, int sessionQuantity, ArrayList<Chapter> chapter) {
        super(title, genre, creator, duration);
        this.sessionQuantity = sessionQuantity;
        this.chapter = chapter;
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
            series.add(new Serie("Serie " + i, "Genero " + i, "Creador " + i, 120 + i, 5, Chapter.makeChaptersList()));
        }
        return series;
    }
    
}
