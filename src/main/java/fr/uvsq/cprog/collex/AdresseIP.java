package fr.uvsq.cprog.collex;

public class AdresseIP {

    private final String ip;

    public AdresseIP(String ip) {
        if (ip == null) { //Teste si le String est null.
            throw new IllegalArgumentException("L'adresse IP ne peut pas etre nulle.");
        }
        
        String IPString = ip.trim(); //Enleve les espaces vides aux bords du string.

        String[] parts = IPString.split("\\."); //Separe le string en parties entre les "."
        if (parts.length != 4){  //Vérifie qu'il y a 4 parties
            throw new IllegalArgumentException("L'adresse IP n'est pas valide, pas 4 parties.");
        }
        for (String part: parts){
            try {
                Integer.parseInt(part);
            } catch (NumberFormatException e) { //Vérifie que les éléments du string sont des ints
                throw new IllegalArgumentException("L'adresse IP doit etre composée de nombres et de point.");
            }
        }

        this.ip = ip.trim();
    }
    @Override
    public String toString(){
        return ip;
    }
}
