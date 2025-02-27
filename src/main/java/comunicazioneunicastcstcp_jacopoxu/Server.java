package comunicazioneunicastcstcp_jacopoxu;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket serverSocket;
    Socket clientSocket;
    int porta;

    public Server(int porta){
        this.porta = porta;
        try {
            serverSocket = new ServerSocket(porta);
            System.out.println("1) Server in ascolto sulla porta" + porta);
        } catch (IOException e) {
            System.err.println("Errore del server nella fase di binding");
        }
    }

    public Socket attendi(){
        try {
            clientSocket = serverSocket.accept();
            System.out.println("2) Connessione con il client avvenuta e data socket creato");
        } catch (IOException e) {
            System.err.println("Problemi di connessione con il client");
        }
        return clientSocket;
    }

    public void leggi(){
        InputStream i;
        BufferedReader br;
        String s;
        try {
            i = clientSocket.getInputStream();
            br = new BufferedReader(new InputStreamReader(i));
            s = br.readLine();
            System.out.println("Il messaggio ricevuto è " + s);
        } catch (IOException e) {
            System.out.println("Il messaggio non è stato ricevuto");
        }
    }

    public void scrivi(){
        OutputStream o;
        PrintWriter pw;
        String s;
        try {
            s = "Tamponbox";
            o = clientSocket.getOutputStream();
            pw = new PrintWriter(o);
            pw.println(s);
            System.out.println("Il messaggio scritto è " + o);
        } catch (IOException e) {
            System.out.println("Il messaggio non è stato scritto");
        }
    }

    public void chiudi(){
        try {
            clientSocket.close();
            System.out.println("5) Chiusura comunicazione con il client");
        } catch (IOException e) {
            System.err.println("Errore nella chiusura3");
        }
    }

    public void termina(){

    }
}

