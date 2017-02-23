 
import java.awt.Color;
import static java.awt.Color.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cardaccia, Sosti
 */
public class Server {

    //numero della porta
    int port;

    ServerSocket sSocket;

    Socket connection;

    Scanner streamIn;

    PrintWriter streamOut;
    
    String risposta;
    
    String yellow = "\u001B[33m";

     
    //costruttore classe Server
    public Server(int port) {
        //this.risposta = risposta.getColor(blue);
        this.port = port;   

    }

    //metto il server in ascolto
    void attendi() {
        //System.err.println("Sono su attendi.");
        try {
            //si crea il socket
            sSocket = new ServerSocket(port);
            
            //si mette in ascolto il server
            System.out.println("Server in ascolto sulla porta " + port + ".\n");
        } 
        catch (IOException e) {}
    }

    //acetto connessioni
    Socket accetta() {
        //System.err.println("Sono su accetta.");
        try {
            connection = sSocket.accept();
            //si è stabilita la connessione
            System.out.println("Connessione stabilita e richiesta ricevuta!");
        } catch (IOException ex) {
        }

        return null;
    }

    //metodo per l' invio di messaggi
    void inviaS() {
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Messaggio da inviare: .\n" + yellow);
        try {
            risposta = tastiera.readLine();
        } catch (Exception e) {
            System.err.println("Errore");
        }
        //System.err.println("Sono su inviaS.");
        try {
            //si istanzia il flusso in output
            streamOut = new PrintWriter(connection.getOutputStream());
            //risposta = streamOut.toString();
            streamOut.print( "Server: " + risposta);
            streamOut.flush();

        } 
        catch (IOException ex) {}

    }

    //metodo per ricevre messaggi
    void riceviS() {
        System.err.println("Sono su riceviS.");
        try {
            streamIn = new Scanner(connection.getInputStream());
                    //leggo la richiesta del client sullo stream di input
            
        risposta = streamIn.nextLine();
        //si riceve la risposta dal client
        System.out.print(risposta);
        //risposta.setColor(Color.blue);
        } catch (IOException ex) {
            
        }

    }

    //metodo per chiusura della connessione
    void chiudiS() {
        try {
            
                //chiusura del flusso di input
                streamIn.close();

                //chiusura del flusso di output
                streamOut.close();

                //chiusura connessione
                connection.close();
                System.out.println("Connessione chiusa");
            
        } catch (IOException e) {
            //e.printStackTrace();
            System.err.println(e);
        }

    }

}
