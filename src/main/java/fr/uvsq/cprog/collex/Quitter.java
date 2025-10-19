package fr.uvsq.cprog.collex;

public class Quitter implements Commande {
    @Override
    public void execute() {
        System.out.println("Fermeture du programme...");
        System.exit(0);
    }
}

