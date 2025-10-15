package fr.uvsq.cprog.collex;
import static org.junit.Assert.*;
import org.junit.Test;

public class DnsItemTest {
    @Test
    public void DnsItemGetters() {
        DnsItem ratna = new DnsItem(new AdresseIP("99.0.0.9"), new NomMachine("www.uvsq.fr"));
        assertEquals(ratna.getIp().toString(), "99.0.0.9");
        assertEquals(ratna.getNomMachine().toString(), "www.uvsq.fr");
    }

    @Test
    public void DnsItemToString() {
        DnsItem carrouf = new DnsItem(new AdresseIP("99.0.0.9"), new NomMachine("www.uvsq.fr"));
        assertEquals(carrouf.toString(), "99.0.0.9 www.uvsq.fr");
    }

    @Test
    public void DnsItemEquals() {
        DnsItem marches = new DnsItem(new AdresseIP("99.0.0.9"), new NomMachine("www.uvsq.fr"));
        DnsItem marches2 = new DnsItem(new AdresseIP("99.0.0.9"), new NomMachine("www.uvsq.fr"));
        assertTrue(marches.equals(marches2));
    }

    @Test
    public void DnsItemEqualsIncorrect(){
        DnsItem marches = new DnsItem(new AdresseIP("99.0.0.9"), new NomMachine("www.uvsq.fr"));
        DnsItem marches2 = new DnsItem(new AdresseIP("99.0.0.0"), new NomMachine("www.uvsq.fr"));
        assertFalse(marches.equals(marches2));
    }
}