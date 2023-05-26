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
        */

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



        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }



    }

}
