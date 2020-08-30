/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrsaavedra.amazonviewer;

// imports
import com.jrsaavedra.amazonviewer.models.Book;
import com.jrsaavedra.amazonviewer.models.Chapter;
import com.jrsaavedra.amazonviewer.models.Movie;
import com.jrsaavedra.amazonviewer.models.Serie;
import com.jrsaavedra.makereport.Report;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i = 7;
        char c = 'w'; 
        System.out.println((i >= 6) && (c == 'w'));
        showMenu();


    }

    public static void showMenu() {
        //select option
        int exit = 0;
        do {
            System.out.println("BIENVENIDOS AMAZON VIEWER");
            System.out.println("");
            System.out.println("Selecciona el número de la opción deseada");
            System.out.println("1. Movies");
            System.out.println("2. Series");
            System.out.println("3. Books");
            System.out.println("4. Magazines");
            System.out.println("5. Report");
            System.out.println("6. Report Today");
            System.out.println("0. Exit");

            // read response from user
            Scanner sc = new Scanner(System.in);
            int response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 0:
                    //exit
                    exit = 0;
                    break;
                case 1:
                    // movies
                    showMovies();
                    break;
                case 2:
                    // series
                    showSeries();
                    break;
                case 3:
                    //books
                    showBooks();
                    break;
                case 4:
                    //magazines
                    showMagazines();
                    break;
                case 5:
                    //Report
                    makeReport();
                    break;
                case 6:
                    //Report Today
                    makeReport(new Date());
                    break;
                default:
                    System.out.println();
                    System.out.println(":: selecciona un opción valida !! ::");
                    System.out.println();
                    break;
            }

        } while (exit != 0);
    }

    static ArrayList<Movie> movies = Movie.makeMoviesList();
    public static void showMovies() {
        int exit = 1;
        do {
            System.out.println("");
            System.out.println(":: MOVIES ::");
            System.out.println("");
            for (int i = 0; i < movies.size(); i++) {
                System.out.println(i + 1 + ": " + movies.get(i).getTitle() + " Visto: " + movies.get(i).isViewed());
            }
            System.out.println("0: Regresar al Menú anterior.");
            System.out.println("");

            // resd response user
            Scanner sc = new Scanner(System.in);
            int response = Integer.valueOf(sc.nextLine());
            if(response == 0){
                showMenu();
            }
            
            if(response > 0){
                Movie movieSelected = movies.get(response - 1);
                movieSelected.setViewed(true);
                Date dateI = movieSelected.startToSee(new Date());
                for (int i = 0; i < 10000; i++) {
                    System.out.println(".................");
                }
                // Termine de ver la peli
                movieSelected.stopToSee(dateI, new Date());
                System.out.println("");
                System.out.println("viste: " + movieSelected);
                System.out.println("Por: " + movieSelected.getTimeViewed()+ " milisegundos...");
                System.out.println("");
            }
        } while (exit != 0);
    }

    public static void showSeries() {
        int exit = 0;
        ArrayList<Serie> series = Serie.makeSeriesList();
        do {
            System.out.println("");
            System.out.println(":: SERIES ::");
            System.out.println("");
            for(int i = 0; i < series.size(); i++){
                System.out.println(i + 1 + ": " + series.get(i).getTitle() + " visto: " + series.get(i).isViewed());
            }
            System.out.println("0: Regresar al menú anterior.");
            System.out.println("");
            //read response
            Scanner sc = new Scanner(System.in);
            int response = Integer.valueOf(sc.nextLine());
            if(response==0){
                showMenu();
            }
            if(response > 0){
            //Mostramos el primer capitulo de la Serie
            showChapters(series.get(response-1).getChapter());
            }
            
        } while (exit != 0);
    }

    public static void showChapters(ArrayList<Chapter> chapters) {
        int exit = 1;
        do {
            System.out.println("");
            System.out.println(":: CHAPTERS ::");
            System.out.println("");
            for(int i = 0; i < chapters.size(); i++){
                System.out.println(i + 1 + ": " + chapters.get(i).getTitle() + " Visto: " + chapters.get(i).isViewed());
            }
            System.out.println("0: Regresar al Menú de series");
            //read response
            Scanner sc = new Scanner(System.in);
            int response = Integer.valueOf(sc.nextLine());
            //Regresar al Menú de series
            if(response == 0){
                showSeries();
            }
            if(response > 0){
            //Validaciones con el capitulo seleccionado
            Chapter selectedChapter = chapters.get(response-1);
            selectedChapter.setViewed(true);
            Date dateI = selectedChapter.startToSee(new Date());
            for(int i = 0; i < 10000; i++){
                System.out.println(".............");
            }
            selectedChapter.stopToSee(dateI, new Date());
            System.out.println("");
            System.out.println("Capitulo: " + selectedChapter);
            System.out.println("Por: " + selectedChapter.getTimeViewed() + " milisegundos ...");
            System.out.println("");
            }
        } while (exit != 0);
    }

    public static void showBooks() {
        int exit = 1;
        ArrayList<Book> books = Book.makeBooksList();
        do {
            //Mostrar listado de opciones
            System.out.println("");
            System.out.println(":: BOOKS ::");
            System.out.println("");
            for(int i = 0; i < books.size(); i++){
                System.out.println(i + 1+ ": "+ books.get(i).getTitle() + " Leido: " + books.get(i).isReaded());
            }
            System.out.println("0. Regresar al Menú anterior");
            System.out.println("");
            //Read response user
            Scanner sc = new Scanner(System.in);
            int response = Integer.valueOf(sc.nextLine());
            if(response == 0){
                showMenu();
            }
            if(response > 0){
            Book bookSelected = books.get(response - 1);
            bookSelected.setReaded(true);
            Date dateI = bookSelected.startToSee(new Date());
            for(int i = 0; i < 10000; i++){
                System.out.println("................");
            }
            //Finalizar lectura del libro
            bookSelected.stopToSee(dateI, new Date());
            System.out.println("");
            System.out.println("Leiste: " + bookSelected);
            System.out.println("Por: " + bookSelected.getTimeReaded() + " milisegundos...");
            System.out.println("");
            }
            
        } while (exit != 0);
    }

    public static void showMagazines() {
        int exit = 0;
        do {
            System.out.println("");
            System.out.println(":: MAGAZINES ::");
            System.out.println("");
        } while (exit != 0);
    }

    public static void makeReport() {
        Report report = new Report();
        report.setNameFile("reporte");
        report.setTitle(":: VISTOS ::");
        report.setExtension("txt");
        String contentReport = "";
        for(Movie movie : movies){
            if(movie.getIsViewed()){
                contentReport += movie.toString();
            }
        }
        report.setContent(contentReport);
        report.makeReport();

    }

    public static void makeReport(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = df.format(date);
        Report report = new Report();
        report.setNameFile("reporte" +dateString);
        report.setTitle(":: VISTOS ::");
        report.setExtension("txt");
        String contentReport = "";
        for(Movie movie : movies){
            if(movie.getIsViewed()){
                contentReport += movie.toString();
            }
        }
        report.setContent(contentReport);
        report.makeReport();
    }

}
