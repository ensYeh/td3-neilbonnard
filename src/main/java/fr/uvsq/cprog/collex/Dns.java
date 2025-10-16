package fr.uvsq.cprog.collex;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Dns {
    private final Map<AdresseIP, DnsItem> iPMapDns = new HashMap<>();
    private final Map<NomMachine, DnsItem> nomMapDns = new HashMap<>();

    public Dns(){
        try {
            // Charger config.properties
            Properties props = new Properties();
            try (InputStream in = getClass().getClassLoader().getResourceAsStream("config.properties")) {
                if (in == null) {
                    throw new IllegalStateException("config.properties introuvable !");
                }
                props.load(new InputStreamReader(in, StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors du chargement du DNS", e);
    }
}
}
