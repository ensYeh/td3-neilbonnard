package fr.uvsq.cprog.collex;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for AdresseIP class.
 */
public class AdresseIPTest 
{  
    @Test
    public void AdresseIPCorrecte() {
        AdresseIP sdf = new AdresseIP("190.0.9.150");
        assertEquals(sdf.toString(), "190.0.9.150");
    }

    @Test(expected = IllegalArgumentException.class)
    public void AdresseIP3Nombres() {
        AdresseIP anamour = new AdresseIP("190.9.0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void AdresseIP5Nombres() {
        AdresseIP mandos = new AdresseIP("E190.F.68.9");
    }
}
