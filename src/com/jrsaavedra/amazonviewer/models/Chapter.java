/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrsaavedra.amazonviewer.models;

import java.util.ArrayList;

/**
 * <h1>Chapter </h1>
 * Hereda de {@link Movie} 
 * @see Film
 * 
 * @author jrsaavedra
 * @version 1.0
 * @since 2020
*/
public class Chapter extends Movie{
    // Attributes
    private int id;
    private int sessionNumber;
    //models
    private Serie serie;

    //contructor

    public Chapter() {
    }
    
//contructor soobrecargado

    public Chapter(String title, String genre, String creator, int duration, short year, int sessionNumber, Serie serie) {
        super(title, genre, creator, duration, year);
    this.sessionNumber = sessionNumber;
    this.serie = serie;
    }
    
   
    //Methods getters and setters
    
    //polimorfismo sobreecribir metodo dar otra funcionalidad
    /**
     * {@inheritDoc}
    */
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

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
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
    public static ArrayList<Chapter> makeChaptersList(Serie serie){
        ArrayList<Chapter> chapters = new ArrayList();
        for(int i = 1; i < 6; i++){
            chapters.add(new Chapter("Capitulo " + i, "Genero " + i, "Creador " + i, 120, (short)(2019+i), i, serie));
        }
        return chapters;
    }
    /**
     * {@inheritDoc}
    */
    @Override
    public void view() {
        super.view(); 
        ArrayList<Chapter> chapters = this.getSerie().getChapter();
        int chapterViewedCounter = 0;
        for(Chapter chapter : chapters){
            if(chapter.getIsViewed()){
                chapterViewedCounter++;
            }        
        }
        
        if(chapterViewedCounter == chapters.size()){
            this.getSerie().view();
        }
    }
    
    
    
    
}
