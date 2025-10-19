package fr.uvsq.cprog.collex;
import org.junit.Test;
import static org.junit.Assert.*;

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
}
