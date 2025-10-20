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
        

    }


    public void affiche(Object res) {
        System.out.println(res);
    }
    //Reste a faire le main.
}

