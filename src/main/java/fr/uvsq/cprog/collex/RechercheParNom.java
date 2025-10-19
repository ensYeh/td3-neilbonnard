package fr.uvsq.cprog.collex;

public class RechercheParNom implements Commande {
    private final Dns dns;
    private final NomMachine nom;

    public RechercheParNom(Dns dns, NomMachine nom) {
        this.dns = dns;
        this.nom = nom;
    }

    @Override
    public void execute() {
        DnsItem item = dns.getItem(nom);
        if (item != null) {
            System.out.println("Résultat : " + item);
        } else {
            System.out.println("Aucun item trouvé pour " + nom);
        }
    }
}
