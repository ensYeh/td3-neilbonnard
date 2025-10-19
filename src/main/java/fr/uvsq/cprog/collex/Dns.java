package fr.uvsq.cprog.collex;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Dns {
    private Map<AdresseIP, DnsItem> iPMapDns = new HashMap<>();
    private Map<NomMachine, DnsItem> nomMapDns = new HashMap<>();

    public Dns(){
        try {
            // Charger config.properties
            Properties props = new Properties();
            try (InputStream in = getClass().getClassLoader().getResourceAsStream("config.properties")) {
                if (in == null) {
                    throw new IllegalStateException("config.properties introuvable");
                }
                props.load(new InputStreamReader(in, StandardCharsets.UTF_8));
            }
         

        String fileName = props.getProperty("dns.file");
            if (fileName == null) {
                throw new IllegalStateException("dns.txt introuvable");
            }

            // Charger le fichier dns.txt
            Path path = Path.of(getClass().getClassLoader().getResource(fileName).toURI());
            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {
                if (line.isBlank()) continue;
                String[] parts = line.split("\\s+");
                if (parts.length != 2) {
                    throw new IllegalArgumentException("Ligne IP+Nom Machine format non correct : " + line);
                }

                AdresseIP ip = new AdresseIP(parts[0]);
                NomMachine nom = new NomMachine(parts[1]);
                DnsItem item = new DnsItem(ip, nom);

                // Remplir les deux maps
                iPMapDns.put(ip, item);
                nomMapDns.put(nom, item);
                for (DnsItem di : iPMapDns.values()) {
                        System.out.println("Chargé DnsItem : " + di.getIp().toString() + " " + di.getNomMachine().toString());
                }
                //System.out.println("Chargé : " + ip.toString());
                //System.out.println("Chargé : " + nom.toString());
            }

        } catch (IOException | URISyntaxException e) {
        throw new RuntimeException("Erreur lors du chargement du DNS", e);
        }
    }
    public DnsItem getItem(AdresseIP ip) {
    return iPMapDns.get(ip);
    }

    public DnsItem getItem(NomMachine nom) {
        return nomMapDns.get(nom);
    }

    public Collection<DnsItem> getAllItems() {
        return iPMapDns.values();
    }

    public List<DnsItem> getItems(String domaine) {
        return iPMapDns.values().stream()
                .filter(item -> item.getNomMachine().getDomaine().equals(domaine))
                .sorted((a, b) -> a.getNomMachine().toString()
                        .compareTo(b.getNomMachine().toString()))
                .toList();
    }

    public void addItem(AdresseIP ip, NomMachine nom) {
        if (iPMapDns.containsKey(ip) || nomMapDns.containsKey(nom)) {
            throw new IllegalArgumentException("L'element DNS existe deja.");
        }

        DnsItem entrée = new DnsItem(ip,nom);

        iPMapDns.put(ip, entrée);
        nomMapDns.put(nom, entrée);

        try {
            
            Properties props = new Properties();
            try (InputStream in = getClass().getClassLoader().getResourceAsStream("config.properties")) {
                if (in == null) {
                    throw new IllegalStateException("config.properties introuvable !");
                }
                props.load(new InputStreamReader(in, StandardCharsets.UTF_8));
            }
            String fileName = props.getProperty("dns.file");
            if (fileName == null) {
                throw new IllegalStateException("dns.file non défini !");
            }

            // Trouver le chemin vers dns.txt
            Path path = Path.of(getClass().getClassLoader().getResource(fileName).toURI());

            // Construire le contenu du fichier à partir des items
            List<String> lines = iPMapDns.values().stream()
                    .map(item -> item.getIp() + " " + item.getNomMachine())
                    .toList();

            Files.write(path, lines, StandardCharsets.UTF_8);

        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la sauvegarde du DNS", e);
        }
    }
}
