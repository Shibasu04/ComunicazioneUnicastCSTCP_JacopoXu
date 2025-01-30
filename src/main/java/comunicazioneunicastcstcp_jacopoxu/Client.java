package comunicazioneunicastcstcp_jacopoxu;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
