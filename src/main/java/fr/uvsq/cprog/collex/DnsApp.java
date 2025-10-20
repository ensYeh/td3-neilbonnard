package fr.uvsq.cprog.collex;

public class DnsApp {
    private final DnsTUI tui;
    private final Dns dns;

    public DnsApp(){
        this.dns = new Dns();
        this.tui = new DnsTUI(dns);
    }
    
    public void run(){
        while (true) {
            Commande c = tui.nextCommande();
            if (c != null) {
                c.execute();
            }
        }
    }
}
