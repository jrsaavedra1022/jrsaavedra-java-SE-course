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
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <h1>AmazonViewer </h1>
 * AmazonViewer, es un programa que permite visualizar libros, pelicalas, meagazines <br>
 * Genera reportes de lo que hemos visualizado
 * <p>Existen algunas reglas como todos los elementos pueden ser visualizados o leídos a excepción de las Magazines, estas sólo pueden ser vistas a modo de exposición sin ser leídas.</p>
 * @author jrsaavedra
 * @version 1.0
 * @since 2020
*/
public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
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

    static ArrayList<Movie> movies = new ArrayList();

    public static void showMovies() {
        movies = Movie.makeMoviesList();
        int exit = 1;
        do {
            System.out.println("");
            System.out.println(":: MOVIES ::");
            System.out.println("");
            AtomicInteger atomicInteger = new AtomicInteger(1);
            movies.forEach(m -> System.out.println(atomicInteger.getAndIncrement()+ ": " + m.getTitle() + " Visto: " + m.isViewed()));
            
//            for (int i = 0; i < movies.size(); i++) {
//                System.out.println(i + 1 + ": " + movies.get(i).getTitle() + " Visto: " + movies.get(i).isViewed());
//            }
            System.out.println("0: Regresar al Menú anterior.");
            System.out.println("");

            // resd response user
            Scanner sc = new Scanner(System.in);
            int response = Integer.valueOf(sc.nextLine());
            if (response == 0) {
                showMenu();
            }

            if (response > 0) {
                Movie movieSelected = movies.get(response - 1);
                movieSelected.view();
            }
        } while (exit != 0);
    }

    static ArrayList<Serie> series = Serie.makeSeriesList();

    public static void showSeries() {
        int exit = 0;
        do {
            System.out.println("");
            System.out.println(":: SERIES ::");
            System.out.println("");
            for (int i = 0; i < series.size(); i++) {
                System.out.println(i + 1 + ": " + series.get(i).getTitle() + " visto: " + series.get(i).isViewed());
            }
            System.out.println("0: Regresar al menú anterior.");
            System.out.println("");
            //read response
            Scanner sc = new Scanner(System.in);
            int response = Integer.valueOf(sc.nextLine());
            if (response == 0) {
                showMenu();
            }
            if (response > 0) {
                //Mostramos el primer capitulo de la Serie
                showChapters(series.get(response - 1).getChapter());
            }

        } while (exit != 0);
    }

    public static void showChapters(ArrayList<Chapter> chapters) {
        int exit = 1;
        do {
            System.out.println("");
            System.out.println(":: CHAPTERS ::");
            System.out.println("");
            for (int i = 0; i < chapters.size(); i++) {
                System.out.println(i + 1 + ": " + chapters.get(i).getTitle() + " Visto: " + chapters.get(i).isViewed());
            }
            System.out.println("0: Regresar al Menú de series");
            //read response
            Scanner sc = new Scanner(System.in);
            int response = Integer.valueOf(sc.nextLine());
            //Regresar al Menú de series
            if (response == 0) {
                showSeries();
            }
            if (response > 0) {
                //Validaciones con el capitulo seleccionado
                Chapter selectedChapter = chapters.get(response - 1);
                selectedChapter.view();
            }
        } while (exit != 0);
    }

    static ArrayList<Book> books = Book.makeBooksList();

    public static void showBooks() {
        int exit = 1;
        do {
            //Mostrar listado de opciones
            System.out.println("");
            System.out.println(":: BOOKS ::");
            System.out.println("");
            for (int i = 0; i < books.size(); i++) {
                System.out.println(i + 1 + ": " + books.get(i).getTitle() + " Leido: " + books.get(i).isReaded());
            }
            System.out.println("0. Regresar al Menú anterior");
            System.out.println("");
            //Read response user
            Scanner sc = new Scanner(System.in);
            int response = Integer.valueOf(sc.nextLine());
            if (response == 0) {
                showMenu();
            }
            if (response > 0) {
                Book bookSelected = books.get(response - 1);
                bookSelected.view();
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
        for (Movie movie : movies) {
            if (movie.getIsViewed()) {
                contentReport += movie.toString() + "\n";
            }
        }
        report.setContent(contentReport);
        report.makeReport();

    }

    public static void makeReport(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = df.format(date);
        Report report = new Report();
        report.setNameFile("reporte" + dateString);
        report.setTitle(":: VISTOS ::");
        report.setExtension("txt");
        String contentReport = "";
        movies = Movie.makeMoviesList(dateString);
        for (Movie movie : movies) {
            if (movie.getIsViewed()) {
                contentReport += movie.toString() + "\n\n";
            }
        }
        report.setContent(contentReport);
        report.makeReport();
    }

}
