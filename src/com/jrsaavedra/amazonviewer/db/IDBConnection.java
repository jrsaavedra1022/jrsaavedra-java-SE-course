/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrsaavedra.amazonviewer.db;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
//importamos las variables de conexión
import static com.jrsaavedra.amazonviewer.db.DataBase.*;
/**
 *
 * @author Bios-hp
 */
public interface IDBConnection {
    
    default Connection connectToDB(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(URL+DB,USER,PASSWORD);
            if(connection != null){
                System.out.println("Se estableció la conexión");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            return connection;
        }
    }
    
}
