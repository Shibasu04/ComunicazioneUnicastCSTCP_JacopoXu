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
            throw new RuntimeException(e);
        }
    }

    public void scrivi(){
        OutputStream o;
        PrintWriter pw;
        String s;
        try {
            o = socket.getOutputStream();
            pw = new PrintWriter(o);
            pw.flush();
            System.out.println("Il messaggio scritto è " + o);
        } catch (IOException e) {
            System.out.println("Il messaggio non è stato scritto");
            throw new RuntimeException(e);
        }
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
