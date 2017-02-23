
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cardaccia, Sosti
 */
public class Client {

    //numero della porta
    int port = 2000;
    //Indirizzo del server TCP
    InetAddress serverAddress;
    //oggetto da usare per realizzare la connessione TCP
    Socket connection;
    //Stream di caratteri di output
    PrintWriter streamOut;
    //oggetto Scanner per leggere il flusso di input
    Scanner streamIn;
    //stringa che serve a colorare l'output
    String blue = "\u001B[34m";
    String risposta = "";

    //costruttore
    public Client() throws IOException {

        /* si usa getLocalHost() se il server è sulla stessa macchina locale
         * altrimenti si deve conoscere l'IP del server
         */
        serverAddress = InetAddress.getByName("127.0.0.1");
        System.out.println("Indirizzo del server trovato!");

        //si apre la connessione al server sulla porta specifica
        connection = new Socket("127.0.0.1", port);
        System.out.println("Connessione aperta");
        
    }

    //invio messaggi nella comunicazione
    void inviaC() {
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Messaggio da inviare: .\n" + blue);
        try {
            risposta = tastiera.readLine();
        } catch (Exception e) {
            System.err.println("Errore");
        }
        try {
            //creazione dello stream in output
            streamOut = new PrintWriter(connection.getOutputStream(), true);     
            //risposta = streamIn.toString()
            streamOut.println("Client: " + risposta);
            streamOut.flush();
        } 
        catch (IOException ex) {}
        
        
    }

    
    //ricezione messaggi nella comunicazione
    void riceviC() {
        try {
            //creazione stream input
            streamIn = new Scanner(connection.getInputStream());
            
            //leggo risposta dal server
            risposta = streamIn.nextLine();
            
            //si riceve la risposta dal server
            System.out.println(risposta);
           
        } 
        catch (IOException ex) {}
    }

    //metodo chiusura connessione
    void chiudiC() {
        try {
            //chiusura del flusso di Input
            streamIn.close();
			
            //chiusura del flusso di Output
            streamOut.close();
            
            //chiusura connessione
            connection.close();
            System.out.println("Connessione chiusa!");
        } 
        catch (IOException ex) {}
            
    }
    
    
    
}


