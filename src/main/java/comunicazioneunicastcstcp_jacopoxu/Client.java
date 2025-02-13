package comunicazioneunicastcstcp_jacopoxu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.rmi.UnexpectedException;

public class Client {
    String nome;
    String colore;
    Socket socket;

    public Client(String nome){
        this.nome = nome;
    }

    public void connetti(String nomeServer, int porta){
        try {
            socket = new Socket(nomeServer, porta);
            System.out.println("1)Connessione avvenuta con successo");
        }
        catch(ConnectException e){
            System.err.println("Errone server non in ascolto nella porta");
            throw new RuntimeException(e);
        }
        catch(UnknownHostException ex){
            System.err.println("Errone server non in ascolto nella porta");
            throw new RuntimeException(ex);
        }
        catch (IOException e) {
            System.err.println("Errone nella fase di connessione");
            throw new RuntimeException(e);
        }
    }

    public void leggi(){

    }

    public void scrivi(){

    }

    public void chiudi(){
        if(socket!=null){
            try {
                socket.close();
                System.out.println("4)Chiusura della connessione con il server");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void termina(){

    }
}
