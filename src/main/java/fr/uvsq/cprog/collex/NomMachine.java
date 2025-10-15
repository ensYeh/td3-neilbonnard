package fr.uvsq.cprog.collex;

public class NomMachine {
    private final String nom;

    public NomMachine(String nom) {
        if (nom == null) { //Teste si le String est null.
            throw new IllegalArgumentException("Le nom de machine ne peut pas etre nul.");
        }
        String nomString = nom.trim(); //Enleve les espaces vides aux bords du string.

        if (nomString.isEmpty()) { //Teste si le String est vide.
            throw new IllegalArgumentException("Le nom de machine ne peut pas etre vide.");
        }
        String[] parts = nomString.split("\\."); //Separe le string en parties entre les "."

        if (parts.length < 2){  //Vérifie qu'il y a au moins deux parties
            throw new IllegalArgumentException("Le nom de machine n'est pas valide, pas deux parties.");
        }
        for (String part: parts){
            if (part.isEmpty()){ //Teste si une des parties est vide.
                throw new IllegalArgumentException("Le nom de machine n'est pas valide, partie vide.");
            }
        }
        this.nom = nom.trim();
    }
    @Override
    public String toString(){
        return nom;
    }

    public String getDomaine() {
    int index = nom.indexOf('.');
    return nom.substring(index + 1);
    }

    public String getMachine(){
    int index = nom.indexOf('.');
    return nom.substring(0, index);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NomMachine other = (NomMachine) obj;
        return this.nom.equals(other.nom);
    }
}