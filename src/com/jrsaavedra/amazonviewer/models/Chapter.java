/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrsaavedra.amazonviewer.models;

import java.util.ArrayList;

/**
 *
 * @author Bios-hp
 */
public class Chapter extends Movie{
    // Attributes
    private int id;
    private int sessionNumber;

    //contructor

    public Chapter() {
    }
    
//contructor soobrecargado

    public Chapter(String title, String genre, String creator, int duration, short year, int sessionNumber) {
        super(title, genre, creator, duration, year);
    this.sessionNumber = sessionNumber;
    }
    
   
    //Methods getters and setters
    
    //polimorfismo sobreecribir metodo dar otra funcionalidad
    @Override
    public int getId(){
        return this.id;
    }

    public int getSessionNumber() {
        return sessionNumber;
    }

    public void setSessionNumber(int sessionNumber) {
        this.sessionNumber = sessionNumber;
    }
    
    @Override
    public String toString() {
        return "..:: CHAPTER ::.." +
               "\n Title:  " + getTitle() +
               "\n Genre:  " + getGenre()+
               "\n Year:  " + getYear() +
               "\n Creator:  " + getCreator()+
               "\n Duration:  " + getDuration();
                
    }

    // Crear lista de capitulos
    public static ArrayList<Chapter> makeChaptersList(){
        ArrayList<Chapter> chapters = new ArrayList();
        for(int i = 1; i < 6; i++){
            chapters.add(new Chapter("Capitulo " + i, "Genero " + i, "Creador " + i, 120, (short)(2019+i), i));
        }
        return chapters;
    }
    
    
}
