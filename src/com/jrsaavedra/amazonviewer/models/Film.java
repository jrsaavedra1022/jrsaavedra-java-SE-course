/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrsaavedra.amazonviewer.models;

/**
 *
 * @author Bios-hp
 */
public class Film {
    //Attributes
    private String title;
    private String genre;
    private String creator;
    private int duration;
    private short year;
    private boolean viewed;
    
    //contructor
    public Film() {    
    }

    //Constructor sobrecargado
    public Film(String title, String genre, String creator, int duration) {
        this.title = title;
        this.genre = genre;
        this.creator = creator;
        this.duration = duration;
    }
    
    
    // methods getter and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public String isViewed() {
        if(viewed == true){
            return "Si";
        }else{
            return "No";
        }
    }
    
    public boolean getIsViewed() {
        return viewed;
    }

    public void setViewed(boolean viewed) {
        this.viewed = viewed;
    }
    
    
}
