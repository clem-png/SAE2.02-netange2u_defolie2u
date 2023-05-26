import java.io.FileNotFoundException;
import java.io.FileWriter;
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


/*
           GrapheListe d0 = new GrapheListe();
           GrapheListe d1 = d0.GenererGraphe(5);
           GrapheListe d2 = d0.GenererGraphe(10);
           GrapheListe d3 = d0.GenererGraphe(200);



           Valeur v4 = new Valeur();

           Valeur v1 = new Valeur();
           Valeur v2 = new Valeur();
           Valeur v3 = new Valeur();


            Dijakstra b3 = new Dijakstra();
            BellmonFord b4 = new BellmonFord();

            System.out.println("\t ---Graphe taille 6---");

            System.out.println("->Dijakstra");

            v1 = b3.resoudre(d1,"Noeud0");

            System.out.println("->BellmonFord");

            v1 = b4.resoudre(d1,"Noeud1");

            System.out.println("\n\t ---Graphe taille 11---");

            System.out.println("->Dijakstra");

            v2 = b3.resoudre(d2,"Noeud0");

            System.out.println("->BellmonFord");

            v2 = b4.resoudre(d2,"Noeud1");


            System.out.println("\n\t ---Graphe taille 201---");

            System.out.println("->Dijakstra");

            v3 = b3.resoudre(d3,"Noeud0");

            System.out.println("\n\t->BellmonFord");

            v3 = b4.resoudre(d3,"Noeud1");

            //System.out.println(d3.toGraphviz());



            */
        /*
        GrapheListe d4 = d0.GenererGraphe(20);
        System.out.println("\n/t ---Graphe taille grande---");

        Dijakstra b3 = new Dijakstra();
        BellmonFord b4 = new BellmonFord();

        System.out.println("->Dijakstra");

        v4 = b3.resoudre(d4,"Noeud0");

        System.out.println("->BellmonFord");

        v4 = b4.resoudre(d4,"Noeud0");
        */
        /*
        String csvFile = "data.csv";

        try {
            FileWriter writer = new FileWriter(csvFile);

            // Écrire l'en-tête du CSV
            writer.append("indice,TempsDijakstra,TempsBellmonford\n");

            int nombreLignes = 1000;

            for (int i = 5; i <= nombreLignes; i++) {


                GrapheListe d0 = new GrapheListe();
                GrapheListe k = new GrapheListe();
                k = d0.GenererGraphe(i);

                Dijakstra di = new Dijakstra();
                BellmonFord be = new BellmonFord();


                long startTime = System.nanoTime();
                Valeur v4 = di.resoudre(k,"Noeud0");
                long endTime = System.nanoTime();
                long time = (endTime - startTime)/1000000;

                long startTime2 = System.nanoTime();
                Valeur v5 = be.resoudre(k,"Noeud0");
                long endTime2 = System.nanoTime();
                long time2 = (endTime2 - startTime2)/1000000;

                // Écrire une ligne dans le CSV
                writer.append(String.valueOf(i));
                writer.append(",");
                writer.append(String.valueOf(time));
                writer.append(",");
                writer.append(String.valueOf(time2));
                writer.append("\n");
            }

            writer.flush();
            writer.close();

            System.out.println("Le fichier CSV a été créé avec succès !");
        } catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de la création du fichier CSV : " + e.getMessage());
        }
        */
        /*
        String csvFile2 = "dat2.csv";

        try {
            FileWriter writer = new FileWriter(csvFile2);

            // Écrire l'en-tête du CSV
            writer.append("indice,TempsDijakstra,TempsBellmonford\n");

            int nombreLignes = 96;

            for (int i = 1; i <= nombreLignes; i = i + 10) {


                GrapheListe k = new GrapheListe("graphe/Graphe"+i+".txt");


                Dijakstra di = new Dijakstra();
                BellmonFord be = new BellmonFord();


                long startTime = System.nanoTime();
                Valeur v4 = di.resoudre(k,"1");
                long endTime = System.nanoTime();
                long time = (endTime - startTime)/1000000;

                long startTime2 = System.nanoTime();
                Valeur v5 = be.resoudre(k,"1");
                long endTime2 = System.nanoTime();
                long time2 = (endTime2 - startTime2)/1000000;

                // Écrire une ligne dans le CSV
                writer.append(String.valueOf(i));
                writer.append(",");
                writer.append(String.valueOf(time));
                writer.append(",");
                writer.append(String.valueOf(time2));
                writer.append("\n");
            }

            writer.flush();
            writer.close();

            System.out.println("Le fichier CSV a été créé avec succès !");
        } catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de la création du fichier CSV : " + e.getMessage());
        }


         */





    }

}
