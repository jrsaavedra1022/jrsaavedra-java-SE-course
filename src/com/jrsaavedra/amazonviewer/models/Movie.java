/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrsaavedra.amazonviewer.models;

import java.util.ArrayList;
import java.util.Date;

public class Movie extends Film implements IVisualizable{

    // Attributes
    private int id;
    private int timeViewed;

    //constructor 

    public Movie() {
    }

    public Movie(String title, String genre, String creator, int duration, short year) {
        super(title, genre, creator, duration);
        super.setYear(year);
    }
    

    

    public void showData() {
        //System.out.println("Title: " + this.title);
        //System.out.println("Genre: " + this.genre);
        //System.out.println("Year: " + this.year);
    }
    //methods getter and setters

    public int getId() {
        return id;
    }

    public int getTimeViewed() {
        return timeViewed;
    }

    public void setTimeViewed(int timeViewed) {
        this.timeViewed = timeViewed;
    }

    @Override
    public String toString() {
        return "..:: MOVIE ::.." +
               "\n Title:  " + getTitle() +
               "\n Genre:  " + getGenre()+
               "\n Year:  " + getYear() +
               "\n Creator:  " + getCreator()+
               "\n Duration:  " + getDuration();
                
    }

    @Override
    public Date startToSee(Date dateI) {
        return dateI;
    }

    @Override
    public void stopToSee(Date dateI, Date dateF) {
        if(dateF.getTime()> dateI.getTime()){
            this.setTimeViewed((int)dateF.getTime()- (int)dateI.getTime());
        }else{
            this.setTimeViewed(0);
        }
    }
    
    public static ArrayList<Movie> makeMoviesList(){
        ArrayList<Movie> movies = new ArrayList();
        for(int i = 1; i < 6; i++){
            movies.add(new Movie("Movie " + i, "Genero " + i, "Creador " + i, 120 +i, (short)(2017+i)));
        }
        return movies;
    }
    
    
    
}
