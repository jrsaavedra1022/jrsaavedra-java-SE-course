/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrsaavedra.amazonviewer.models;

import com.jrsaavedra.amazonviewer.dao.MovieDAO;
import java.util.ArrayList;
import java.util.Date;

/**
 * <h1>Movie </h1>
 * Hereda de {@link Film} 
 * Implementa de {@link IVisualizable} 
 * 
 * @author jrsaavedra
 * @version 1.0
 * @since 2020
*/

public class Movie extends Film implements IVisualizable, MovieDAO {

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
    
    public void setId(int id) {
        this.id = id;
    }

    public int getTimeViewed() {
        return timeViewed;
    }

    public void setTimeViewed(int timeViewed) {
        this.timeViewed = timeViewed;
    }

    @Override
    public String toString() {
        return "..:: MOVIE ::.."
                + "\n Title:  " + getTitle()
                + "\n Genre:  " + getGenre()
                + "\n Year:  " + getYear()
                + "\n Creator:  " + getCreator()
                + "\n Duration:  " + getDuration();

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
            this.setTimeViewed((int) dateF.getTime() - (int) dateI.getTime());
        } else {
            this.setTimeViewed(0);
        }
    }

    public static ArrayList<Movie> makeMoviesList() {
        Movie movie = new Movie();
        return movie.read();
    }
    
    public static ArrayList<Movie> makeMoviesList(String dateString) {
        Movie movie = new Movie();
        return movie.read(dateString);
    }
    
    /**
     * {@inheritDoc}
    */
    @Override
    public void view() {
        this.setViewed(true);
        Movie movie = new Movie();
        movie.setMovieViewed(this);
        
        Date dateI = this.startToSee(new Date());
        for (int i = 0; i < 10000; i++) {
            System.out.println(".................");
        }
        // Termine de ver la peli
        this.stopToSee(dateI, new Date());
        System.out.println("");
        System.out.println("viste: " + this.toString());
        System.out.println("Por: " + this.getTimeViewed() + " milisegundos...");
        System.out.println("");
    }

}
