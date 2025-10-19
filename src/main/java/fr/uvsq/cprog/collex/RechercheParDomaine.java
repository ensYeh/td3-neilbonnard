package fr.uvsq.cprog.collex;

public class RechercheParDomaine implements Commande {
    private final Dns dns;
    private final String domaine;

    public RechercheParDomaine(Dns dns, String domaine) {
        this.dns = dns;
        this.domaine = domaine;
    }

    @Override
    public void execute() {
        var items = dns.getItems(domaine);
        if (items.isEmpty()) {
            System.out.println("Aucune machine trouvée pour le domaine " + domaine);
        } else {
            items.forEach(System.out::println);
        }
    }
}

