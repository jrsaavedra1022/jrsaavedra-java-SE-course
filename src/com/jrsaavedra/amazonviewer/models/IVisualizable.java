/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrsaavedra.amazonviewer.models;

/**
 * <h1>Interface IVisalizable </h1>
 * 
 * @author jrsaavedra
 * @version 1.0
 * @since 2020
*/
import java.util.Date;

public interface IVisualizable {
    
    /**
     * 
     * Este método captura el tiempo exacto de visaulización
     * @param dateI Es un objeto {@code Date } con el tiempo de inicio exacto
     * @return Devuelve la fecha y hora capturada
    */
    Date startToSee(Date dateI);
    /**
     * 
     * Este método captura el tiempo exacto inicio y fin de visualización.
     * @param dateI Es un objeto {@code Date } con el tiempo de inicio exacto
     * @param dateF Es un objeto {@code Date } con el tiempo de fin exacto
    */
    void stopToSee(Date dateI, Date dateF);
    
}
