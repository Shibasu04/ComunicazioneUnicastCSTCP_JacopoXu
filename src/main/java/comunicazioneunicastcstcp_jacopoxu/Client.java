package comunicazioneunicastcstcp_jacopoxu;

import java.io.IOException;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
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
        catch(UnexpectedHostException e){
            System.err.println("Errone server non in ascolto nella porta");
            throw new RuntimeException(e);
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
