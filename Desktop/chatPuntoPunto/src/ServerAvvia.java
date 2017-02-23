/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author informatica
 */
public class ServerAvvia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Server s = new Server(2000);
       
       s.attendi();
       s.accetta();
       
       
       s.riceviS();
       s.inviaS();
    }
    
}
