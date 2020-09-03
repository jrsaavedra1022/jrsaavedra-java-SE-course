/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrsaavedra.amazonviewer.dao;

import com.jrsaavedra.amazonviewer.db.IDBConnection;
import com.jrsaavedra.amazonviewer.models.Movie;
import static com.jrsaavedra.amazonviewer.db.DataBase.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Bios-hp
 */
public interface MovieDAO extends IDBConnection{
    
    //Metodo default
    default Movie setMovieViewed(Movie movie){
        try(Connection conn = connectToDB()){
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO " + TVIEWED +
                    " (" + TVIEWED_IDMATERIAL + "," + TVIEWED_IDELEMENT +"," +TVIEWED_IDUSUARIO+") " +
                    " VALUES (" + ID_TMATERIALS[0] +"," + movie.getId()+ ","+TUSER_IDUSUARIO+")";
            if(stmt.executeUpdate(query) > 0){
                System.out.println("Se marco en visto");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movie;
    }
    
    //Metodo default
    default ArrayList<Movie> read(){
        ArrayList<Movie> movies = new ArrayList();
        try(Connection connection = connectToDB()){
            String query = "SELECT * FROM " + TMOVIE;
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Movie movie = new Movie(
                        rs.getString(TMOVIE_TITLE), 
                        rs.getString(TMOVIE_GENRE),
                        rs.getString(TMOVIE_CREATOR),
                        Integer.valueOf(rs.getString(TMOVIE_DURATION)),
                        Short.valueOf(rs.getString(TMOVIE_YEAR))
                );
                movie.setId(Integer.valueOf(rs.getString(TMOVIE_ID)));
                movie.setViewed(getMovieViewed(
                        pstmt, 
                        connection, 
                        Integer.valueOf(rs.getString(TMOVIE_ID)))
                );
                movies.add(movie);
            }
        }catch(SQLException e){
        }
        return movies;
    }
    
    //consulta de peliculas por fecha de visualización
    default ArrayList<Movie> read(String dateString){
        ArrayList<Movie> movies = new ArrayList();
        try(Connection connection = connectToDB()){
            String query = "SELECT M.*, 1 AS VIEWED FROM " + TMOVIE + " AS M " +
                    " INNER JOIN " + TVIEWED + " AS V ON V." + TVIEWED_IDELEMENT + " = " + "M." + TMOVIE_ID +
                    " WHERE V." + TVIEWED_IDMATERIAL + " =?" + " AND DATE(V." + TVIEWED_UPDATED_AT + ") = ?";
            
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, ID_TMATERIALS[0]);
            pstmt.setString(2, dateString);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Movie movie = new Movie(
                        rs.getString(TMOVIE_TITLE), 
                        rs.getString(TMOVIE_GENRE),
                        rs.getString(TMOVIE_CREATOR),
                        Integer.valueOf(rs.getString(TMOVIE_DURATION)),
                        Short.valueOf(rs.getString(TMOVIE_YEAR))
                );
                movie.setId(Integer.valueOf(rs.getString(TMOVIE_ID)));  
                movie.setViewed(true);
                movies.add(movie);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return movies;
    }
    
    //private boolean getMovieViewed(){
    default boolean getMovieViewed(PreparedStatement pstmt, Connection conn, int movie_id){
        boolean viewed = false;
        String query = "SELECT * FROM " + TVIEWED +
                " WHERE " + TVIEWED_IDMATERIAL + " = ? " +
                " AND " + TVIEWED_IDELEMENT + " = ? " + 
                " AND " + TVIEWED_IDUSUARIO + " = ?";
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, ID_TMATERIALS[0]);
            pstmt.setInt(2, movie_id);
            pstmt.setInt(3, TUSER_IDUSUARIO);
            
            rs = pstmt.executeQuery();
            viewed = rs.next();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
        return viewed;
    }
    
}
