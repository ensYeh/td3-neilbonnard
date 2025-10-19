package fr.uvsq.cprog.collex;

public class RechercheParIP implements Commande {
    private final Dns dns;
    private final AdresseIP ip;

    public RechercheParIP(Dns dns, AdresseIP ip) {
        this.dns = dns;
        this.ip = ip;
    }

    @Override
    public void execute() {
        DnsItem item = dns.getItem(ip);
        if (item != null) {
            System.out.println("Résultat : " + item);
        } else {
            System.out.println("Aucun item trouvé pour " + ip);
        }
    }
}