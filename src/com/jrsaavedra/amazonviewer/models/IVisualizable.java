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
import java.util.Date;

public interface IVisualizable {
    
    Date startToSee(Date dateI);
    void stopToSee(Date dateI, Date dateF);
    
}
