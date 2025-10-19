package fr.uvsq.cprog.collex;

import java.util.Scanner;

public class DnsTUI {
    private final Dns dns;
    private final Scanner scanner = new Scanner(System.in);

    public DnsTUI(Dns dns) {
        this.dns = dns;
    }

    public Commande nextCommande() {
        System.out.print("> ");
        String line = scanner.nextLine().trim();
        String[] parts = line.split("\\s+");

        if (parts.length == 0) return null;

        switch (parts[0].toLowerCase()) {
            case "ip":
                return new RechercheParIP(dns, new AdresseIP(parts[1]));
            case "nom":
                return new RechercheParNom(dns, new NomMachine(parts[1]));
            case "domaine":
                return new RechercheParDomaine(dns, parts[1]);
            case "add":
                return new AjouterItem(dns, new AdresseIP(parts[1]), new NomMachine(parts[2]));
            case "quit":
                return new Quitter();
            default:
                System.out.println("Commande inconnue !");
                return null;
        }
    }

    public void affiche(Object res) {
        System.out.println(res);
    }
}

