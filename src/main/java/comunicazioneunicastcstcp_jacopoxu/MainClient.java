package comunicazioneunicastcstcp_jacopoxu;

public class MainClient {
    public static void main(String[] args) {
        Client c = new Client("giacopo");
        c.connetti("localhost", 1906);
        c.leggi();
        c.chiudi();
    }
}
