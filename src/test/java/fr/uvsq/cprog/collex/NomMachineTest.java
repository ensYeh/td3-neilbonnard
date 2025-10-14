package fr.uvsq.cprog.collex;

import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Unit test for NomMachine class.
 */
public class NomMachineTest {
    @Test
    public void NomMachineCorrect() {
        NomMachine roseraie = new NomMachine("www.uvsq.fr");
        assertEquals(roseraie.toString(), "www.uvsq.fr");
    }
    @Test(expected = IllegalArgumentException.class)
    public void NomMachine1Partie() {
        NomMachine lesser = new NomMachine("uvsq");
    }
    @Test(expected = IllegalArgumentException.class)
    public void NomMachinePartieVide() {
        NomMachine marley = new NomMachine(".uvsq.fr");
    }
    @Test
    public void NomMachineGetDomaine() {
        NomMachine yezi = new NomMachine("www.uvsq.fr");
        assertEquals(yezi.getDomaine(), "uvsq.fr");
    }
    @Test
    public void NomMachineGetMachine() {
        NomMachine hulkey = new NomMachine("www.uvsq.fr");
        assertEquals(hulkey.getMachine(), "www");
    }
     
}
