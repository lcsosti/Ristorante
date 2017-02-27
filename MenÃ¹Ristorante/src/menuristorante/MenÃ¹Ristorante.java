/*
Realizza un programma che permetta di scegliere primi e secondi in un ristorante 
attraverso un menù con immagini; selezionando tre item del menù devono essere 
visualizzate tre diversi tipi di finestre di dialogo.
versione 3.0
 */

package menùristorante;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author LucaSosti
 */

public class MenùRistorante {

   
    public static void main(String[] args) {
        
        Menu m = new Menu();
        
        
        m.setTitle("Menu");
        m.pack();
        m.setVisible(true);
        m.setSize(300,300);
    }
    
}
