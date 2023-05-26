import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestDijakstra {

    /**
     * Test de l'algorithme de Dijakstra
     * @throws IOException
     */
    @Test
    public void test_Dijakstra() throws IOException {
        GrapheListe gl = new GrapheListe("SAE2.02-netange2u_defolie2u/graphe/GrapheExemple.txt");

        Dijakstra algo = new Dijakstra();
        Valeur v = algo.resoudre(gl, "A");

        assertNull(v.getParent("A"));
        assertEquals("A",v.getParent("B"));
        assertEquals("D",v.getParent("C"));
        assertEquals("E",v.getParent("D"));
        assertEquals("B",v.getParent("E"));
    }

    /**
     * Test de l'algorithme de Dijakstra
     * @throws IOException
     */
    @Test
    public void test_Dijakstra1Noeud() throws IOException {
        GrapheListe gl = new GrapheListe("SAE2.02-netange2u_defolie2u/graphe/GrapheExemple.txt");

        Algorithme algo = new Dijakstra();
        Valeur v = algo.resoudre(gl, "A");
        assertEquals(0,v.getValeur("A"),0);
    }

}
