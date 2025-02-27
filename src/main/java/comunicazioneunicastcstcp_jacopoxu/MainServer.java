package comunicazioneunicastcstcp_jacopoxu;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class MainServer {
    public static void main(String[] args) {
       Server s = new Server(50000);
        s.attendi();
        s.leggi();
    }
}