package comunicazioneunicastcstcp_jacopoxu;

import java.io.*;
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
        }
        catch(UnknownHostException ex){
            System.err.println("Errone server non in ascolto nella porta");
        }
        catch (IOException e) {
            System.err.println("Errone nella fase di connessione");
        }
    }

    public void leggi() {
        InputStream i;
        BufferedReader br;
        String s;
        try {
            i = socket.getInputStream();
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
            o = socket.getOutputStream();
            pw = new PrintWriter(o);
            pw.println(s);
            System.out.println("Il messaggio scritto è " + s);
        } catch (IOException e) {
            System.out.println("Il messaggio non è stato scritto");
        }
    }

    public void chiudi(){
        if(socket!=null){
            try {
                socket.close();
                System.out.println("4)Chiusura della connessione con il server");
            } catch (IOException e) {
                System.err.println("Errore nella chiusura");
            }
        }
    }

    public void termina(){

    }
}
