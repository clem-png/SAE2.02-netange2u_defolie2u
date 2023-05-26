import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestCalculerChemin {

    /**
     * Test de la méthode calculerChemin
     */
    @Test
    public void test_CalculerValeur(){
        Valeur valeur = new Valeur();
        valeur.setParent("A", null);
        valeur.setValeur("A", 0.0);
        valeur.setParent("B", "A");
        valeur.setValeur("B", 1.0);
        valeur.setParent("C", "B");
        valeur.setValeur("C", 3.0);
        valeur.setParent("D", "C");
        valeur.setValeur("D", 6.0);
        valeur.setParent("E", "D");
        valeur.setValeur("E", 10.0);

        List<String> chemin = valeur.calculerChemin("E");

        assertEquals(5, chemin.size());
        assertEquals("A", chemin.get(0));
        assertEquals("B", chemin.get(1));
        assertEquals("C", chemin.get(2));
        assertEquals("D", chemin.get(3));
        assertEquals("E", chemin.get(4));
    }
}
