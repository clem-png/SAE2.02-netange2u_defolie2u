import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestGrapheListe {


    /**
     * Test de la méthode toGraphviz pour le Graphe1.txt
     * @throws IOException
     */
    @Test
    public void test_GrapheViz() throws IOException {
        GrapheListe g = new GrapheListe("SAE2.02-netange2u_defolie2u/graphe/Graphe1.txt");
        String s = g.toGraphviz();
        assertEquals("digraph X { \n" +
                "\n" +
                "1 -> 2 [label = 4.0]\n" +
                "1 -> 4 [label = 15.0]\n" +
                "2 -> 1 [label = 1.0]\n" +
                "2 -> 3 [label = 9.0]\n" +
                "2 -> 4 [label = 12.0]\n" +
                "2 -> 5 [label = 8.0]\n" +
                "3 -> 1 [label = 8.0]\n" +
                "3 -> 2 [label = 20.0]\n" +
                "3 -> 4 [label = 36.0]\n" +
                "3 -> 7 [label = 19.0]\n" +
                "3 -> 8 [label = 8.0]\n" +
                "3 -> 9 [label = 3.0]\n" +
                "3 -> 10 [label = 11.0]\n" +
                "4 -> 1 [label = 7.0]\n" +
                "4 -> 2 [label = 17.0]\n" +
                "4 -> 3 [label = 4.0]\n" +
                "4 -> 5 [label = 11.0]\n" +
                "4 -> 7 [label = 5.0]\n" +
                "5 -> 4 [label = 16.0]\n" +
                "5 -> 6 [label = 13.0]\n" +
                "5 -> 7 [label = 10.0]\n" +
                "5 -> 10 [label = 9.0]\n" +
                "6 -> 2 [label = 18.0]\n" +
                "6 -> 5 [label = 2.0]\n" +
                "6 -> 7 [label = 24.0]\n" +
                "6 -> 8 [label = 10.0]\n" +
                "6 -> 10 [label = 1.0]\n" +
                "7 -> 6 [label = 16.0]\n" +
                "7 -> 8 [label = 11.0]\n" +
                "7 -> 9 [label = 5.0]\n" +
                "8 -> 5 [label = 12.0]\n" +
                "8 -> 7 [label = 20.0]\n" +
                "8 -> 9 [label = 18.0]\n" +
                "9 -> 3 [label = 13.0]\n" +
                "9 -> 5 [label = 3.0]\n" +
                "9 -> 6 [label = 8.0]\n" +
                "9 -> 8 [label = 2.0]\n" +
                "9 -> 10 [label = 11.0]\n" +
                "10 -> 9 [label = 18.0]\n" +
                "}", s);
    }


}
