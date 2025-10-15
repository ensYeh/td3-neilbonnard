package fr.uvsq.cprog.collex;

public class DnsItem {
    private final AdresseIP ip;
    private final NomMachine nomMachine;

    public DnsItem(AdresseIP ip, NomMachine nomMachine) {
        if (ip == null || nomMachine == null) { //Teste si l'un des deux paramètres est null.
            throw new IllegalArgumentException("L'adresse IP et le nom de machine ne peuvent pas etre nuls.");
        }
        this.ip = ip;
        this.nomMachine = nomMachine;
    }

    public AdresseIP getIp() {
        return ip;
    }

    public NomMachine getNomMachine() {
        return nomMachine;
    }

    @Override
    public String toString() {
        return ip.toString() + " " + nomMachine.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DnsItem other = (DnsItem) obj;
        return ip.equals(other.ip) && nomMachine.equals(other.nomMachine);
    }
}
