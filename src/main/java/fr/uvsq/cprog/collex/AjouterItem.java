package fr.uvsq.cprog.collex;

public class AjouterItem implements Commande {
    private final Dns dns;
    private final AdresseIP ip;
    private final NomMachine nom;

    public AjouterItem(Dns dns, AdresseIP ip, NomMachine nom) {
        this.dns = dns;
        this.ip = ip;
        this.nom = nom;
    }

    @Override
    public void execute() {
        try {
            dns.addItem(ip, nom);
            System.out.println("Ajouté : " + ip + " " + nom);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}

