import java.io.FileNotFoundException;
import java.io.IOException;

public class main  {

    public static void main(String[] args) {

        GrapheListe g = new GrapheListe();

        g.ajouterArc("A","B", 12);
        g.ajouterArc("A","D", 87);
        g.ajouterArc("B","E", 11);
        g.ajouterArc("C","A", 19);
        g.ajouterArc("D","C", 10);
        g.ajouterArc("D","B", 23);
        g.ajouterArc("E","D", 43);

        /*
        System.out.println(g.toString());
        System.out.println(g.toGraphviz());
        BellmonFord b = new BellmonFord();
        //Dijakstra b = new Dijakstra();
        Valeur v = b.resoudre(g,"A");
        System.out.println(v.toString());
        System.out.println(v.calculerChemin("E"));
        System.out.println(g.GenererGraphe(10).toGraphviz());
        */

        /*
       try {

            GrapheListe g2 = new GrapheListe("graphe/Graphe1.txt");
            //System.out.println(g2.toString());
            //System.out.println(g2.toGraphviz());

            System.out.println("\n \t---BellmonFord--- \n");

            BellmonFord b2 = new BellmonFord();
            Valeur v2 = b2.resoudre(g2,"1");
            //System.out.println(v2.toString());
            //System.out.println(v2.calculerChemin("10"));

            System.out.println("\n \t---Dijakstra--- \n");

            Dijakstra b3 = new Dijakstra();
            Valeur v3 = b3.resoudre(g2,"1");
            //System.out.println(v3.toString());
            //System.out.println(v3.calculerChemin("10"));

           //tester tous les fichiers


        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        */


           GrapheListe d0 = new GrapheListe();
           GrapheListe d1 = d0.GenererGraphe(5);
           GrapheListe d2 = d0.GenererGraphe(10);
           GrapheListe d3 = d0.GenererGraphe(20);

           Valeur v1 = new Valeur();
           Valeur v2 = new Valeur();
           Valeur v3 = new Valeur();

            Dijakstra b3 = new Dijakstra();
            BellmonFord b4 = new BellmonFord();
            //v1 = b3.resoudre(d1,"Noeud0");
            v1 = b4.resoudre(d1,"Noeud1");
            //v2 = b3.resoudre(d2,"Noeud0");
            v2 = b4.resoudre(d2,"Noeud1");
            //v3 = b3.resoudre(d3,"Noeud0");
            v3 = b4.resoudre(d3,"Noeud1");

            System.out.println(d1.toGraphviz());




    }

}
