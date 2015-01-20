/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package toernooileider;

import javax.swing.*;

/**
 *
 * @author jannedevos
 */
public class ToernooiLeider {

    private static ToernooiLeiderView window;
    
    
    public static void main(String[] args) {
        window = new ToernooiLeiderView();
        window.setLocation(100,50);
        window.setVisible(true);
        
    }
    
    public static void showDBError (Exception e) {
        JOptionPane.showMessageDialog(window, "<html>Er is een fout opgetreden bij de communicatie met de database.<br>"
                        + "Controleer of U verbinding met het internet heeft.<br>"
                        + "Contacteer uw beheerder als deze fout zich blijft voordoen", "Database error", JOptionPane.ERROR_MESSAGE);
        System.out.println(e);
    }
    
    public static String addZeroes (String s, int length) {
        while (s.length() < length) {
            s = "0" + s;
        }
        return s;
    }
}
