package fr.uvsq.cprog.collex;

import java.util.Scanner;

public class DnsTUI {
    private final Dns dns;
    private final Scanner scanner;;

    public DnsTUI(Dns dns) {
        this.dns = dns;
        this.scanner = new Scanner(System.in);
    }

    public Commande nextCommande() {
        System.out.print("> ");
        String line = scanner.nextLine().trim();
        String input = line.toLowerCase();

        if (input.isEmpty()){
            return null;
        }

        if (input.equals("quit")){
            return new Quitter();
        }
        
        if(input.startsWith("add ")) {
            String[] parts = line.split("\\s+");
            if (parts.length != 3) {
                System.out.println("Fomulation: add <ip> <nom machine>");
                return null;
            }
            return new AjouterItem(dns, new AdresseIP(parts[1]), new NomMachine(parts[2]));
        }
        if (input.startsWith("ls ")) {
            String[] parts = line.split("\\s+");
            boolean sortByIp = false;
            String domaine;

            if (parts.length == 2) {
                domaine = parts[1];
            } else if (parts.length == 3 && parts[1].equals("-a")) {
                sortByIp = true;
                domaine = parts[2];
            } else {
                System.out.println("Formulation: ls [-a] <domaine>");
                return null;
            }
            return new RechercheParDomaine(dns, domaine, sortByIp);
        }

        if (isValidIp(input)) {
            return new RechercheParIP(dns, new AdresseIP(input));
        } 
        if (input.contains(".")) {
            return new RechercheParNom(dns, new NomMachine(input));
        }
    
        System.out.println("Commande inconnue");
        return null;
    }

    private boolean isValidIp(String input) {
        String[] parts = input.split("\\.");
        if (parts.length != 4) return false;

        try {
            for (String part : parts) {
                int num = Integer.parseInt(part);
                if (num < 0) return false;
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void affiche(Object res) {
        System.out.println(res);
    }
}

