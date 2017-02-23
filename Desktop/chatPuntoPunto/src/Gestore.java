/**
 *
 * @author Cardaccia, Sosti
 */
public class Gestore {
    
    Server s;
    Client c;
    //costruttore
    public Gestore(Server s){
        this.s = s;
        
        
       }
    
    public Gestore(Client c){
        this.c = c;
    
}
            
    
    
    //controlla e gestisce i messaggi nella comunicazioni
    public String gestione(String risposta){
        
        //gestione caratteri speciali
        switch(risposta) {
            
            case "smile":
                return "☺";
                
            case "end":
                //Chiusura della connessione attraverso il metodo chudi implementato nella classe Server e Client
                s.chiudiS();
                c.chiudiC();
                
                break;
            
            
        }
        return risposta;
        
    }
    
    
}
