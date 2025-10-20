package fr.uvsq.cprog.collex;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Collection;
import java.util.List;

public class DnsTest {
    @Test
    public void testDnsItemCreation() {
        Dns dns = new Dns();
    }
    
    @Test
    public void testChargementDnsValide() {
        Dns dns = new Dns();
/*         System.out.println(dns.getItem(new AdresseIP("193.51.31.90")));*/
        assertNotNull(dns.getItem(new AdresseIP("193.51.31.90")));
        assertNotNull(dns.getItem(new NomMachine("www.uvsq.fr")));
        assertNotNull(dns.getItem(new AdresseIP("193.51.25.12")));
        assertNotNull(dns.getItem(new NomMachine("ecampus.uvsq.fr")));
    }

    @Test
    public void testGetNomMachine() {
        Dns dns2 = new Dns(); 
        AdresseIP ip = new AdresseIP("193.51.31.90");
        DnsItem item = dns2.getItem(ip);
        assertNotNull(dns2.getItem(new AdresseIP("193.51.31.90")));
        assertEquals("www.uvsq.fr", item.getNomMachine().toString());
    }

    @Test
    public void testGetIP() {
        Dns dns = new Dns(); 
        NomMachine nom = new NomMachine("poste.uvsq.fr");
        DnsItem item = dns.getItem(nom);
        assertNotNull("Le nom machine doit être trouvée", item);
        assertEquals("193.51.31.154", item.getIp().toString());
    }

    @Test
    public void testGetAllItems() {
        Dns dns = new Dns();
        Collection<DnsItem> items = dns.getAllItems();
        assertNotNull(items);
        assertFalse(items.isEmpty());
    }

    @Test
    public void testAddItemAndRetrieve() {
        Dns dns = new Dns();
        AdresseIP ip = new AdresseIP("10.0.0.1");
        NomMachine nom = new NomMachine("test.uvsq.fr");

        dns.addItem(ip, nom);

        // Vérifie qu'on peut retrouver l'élément ajouté
        assertEquals("test.uvsq.fr", dns.getItem(ip).getNomMachine().toString());
        assertEquals("10.0.0.1", dns.getItem(nom).getIp().toString());
    }

    @Test
    public void testGetItemsByDomain() {
        // suppose que ton fichier contient www.uvsq.fr et ecampus.uvsq.fr
        Dns dns = new Dns();
        List<DnsItem> items = dns.getItems("uvsq.fr");

        assertNotNull(items);
        assertTrue(items.size() >= 2);
    }

    @Test
    public void testCommandeAjouter() {
        Dns dns = new Dns();
        AjouterItem cmd = new AjouterItem(dns,
                new AdresseIP("193.51.25.88"),
                new NomMachine("cmdtest.uvsq.fr"));
        cmd.execute();

        assertNotNull(dns.getItem(new AdresseIP("193.51.25.88")));
    }
    
}
