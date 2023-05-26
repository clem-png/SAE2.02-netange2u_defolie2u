import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    /**
     *Test du constructeur vide
     */
    @Test
    public void test_GrapheConstructeurVide(){
        GrapheListe g = new GrapheListe();
        assertEquals(0, g.getEnsNom().size());
        assertEquals(0, g.getEnsNoeuds().size());
    }

    /**
     * Test du constructeur avec un fichier
     * @throws IOException
     */
    @Test
    public void test_GrapheConstructeurTxt() throws IOException {
        GrapheListe g = new GrapheListe("SAE2.02-netange2u_defolie2u/graphe/Graphe1.txt");
        assertEquals(10, g.getEnsNom().size());
        assertEquals(10, g.getEnsNoeuds().size());
    }

    /**
     * Testez la méthode listeNoeuds() en créant un graphe avec quelques nœuds
     * et en vérifiant si la liste retournée contient les noms des nœuds correspondants.
     */
    @Test
    public void test_GrapheListe_listeNoeuds(){
        GrapheListe graphe = new GrapheListe();

        graphe.ajouterArc("A", "B", 1.0);
        graphe.ajouterArc("A", "C", 2.0);
        graphe.ajouterArc("B", "C", 3.0);
        graphe.ajouterArc("C", "A", 4.0);

        List<String> listeNoeuds = graphe.listeNoeuds();

        assertEquals(3, listeNoeuds.size());
        assertTrue(listeNoeuds.contains("A"));
        assertTrue(listeNoeuds.contains("B"));
        assertTrue(listeNoeuds.contains("C"));
    }

    /**
     * Test de la méthode suivants()
     */
    @Test
    public void test_Suivant(){
        GrapheListe graphe = new GrapheListe();

        graphe.ajouterArc("A", "B", 1.0);
        graphe.ajouterArc("A", "C", 2.0);
        graphe.ajouterArc("B", "C", 3.0);
        graphe.ajouterArc("C", "D", 4.0);

        List<Arc> suivants = graphe.suivants("A");

        assertEquals(2, suivants.size());

        Arc premierArc = suivants.get(0);
        assertEquals("B", premierArc.getDest());
        assertEquals(1.0, premierArc.getCout(), 0.001);

        Arc deuxiemeArc = suivants.get(1);
        assertEquals("C", deuxiemeArc.getDest());
        assertEquals(2.0, deuxiemeArc.getCout(), 0.001);
    }

    /** Test de la méthode ajouterArc()
     * @throws IOException
     */
   @Test
    public void test_ajouterArc() throws IOException {
        GrapheListe graphe = new GrapheListe("SAE2.02-netange2u_defolie2u/graphe/Graphe1.txt");

        graphe.ajouterArc("11", "12", 1.0);

        assertEquals(11, graphe.getEnsNom().size());
        assertEquals(11, graphe.getEnsNoeuds().size());
    }



}
