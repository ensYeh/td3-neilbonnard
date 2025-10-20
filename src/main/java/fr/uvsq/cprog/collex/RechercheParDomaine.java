package fr.uvsq.cprog.collex;

import java.util.Comparator;
import java.util.List;

public class RechercheParDomaine implements Commande {
    private final Dns dns;
    private final String domaine;
    private final boolean sortByIp;

    public RechercheParDomaine(Dns dns, String domaine, boolean sortByIp) {
        this.dns = dns;
        this.domaine = domaine;
        this.sortByIp = sortByIp;
    }

    @Override
    public void execute() {
        List<DnsItem> items = dns.getItems(domaine);

        if (sortByIp) {
            items.sort(Comparator.comparing(item -> item.getIp().toString()));
        } else {
            items.sort(Comparator.comparing(item -> item.getNomMachine().toString()));
        }

        if (items.isEmpty()) {
            System.out.println("Aucune machine trouvée pour le domaine " + domaine);
        } else {
            items.forEach(item ->
                    System.out.println(item.getIp() + " " + item.getNomMachine())
            );
        }
    }
}


