import java.util.ArrayList;
import java.util.List;

public class Dijakstra implements Algorithme {

    /**
     * Permet de résoudre le problème du plus court chemin
     * @param g un graphe
     * @param depart noeud de départ
     * @return v un objet valeur
     */

    public Valeur resoudre(Graphe g, String depart) {

        //calculer le temps d'exécution
        long startTime = System.nanoTime();

        List<String> noeuds = new ArrayList<String>();

        noeuds.add(depart); //ajouter le noeud de départ à la liste des noeuds

        //point fixe utiliser la classe Valeur
        Valeur v = new Valeur(); //valeur de chaque noeud

        for (int k = 0; k < g.listeNoeuds().size(); k++) { //initialisation de la valeur de chaque noeud
            String noeud = g.listeNoeuds().get(k);
            v.setValeur(noeud, Double.MAX_VALUE); //valeur de chaque noeud est infinie
            if (!noeud.equals(depart)){ //si le noeud n'est pas le noeud de départ on ajoute le noeud à la liste des noeuds
                noeuds.add(noeud);
            }
        }

        v.setValeur(depart, 0.0); //valeur du noeud de départ

        int indice = 0;
        Valeur vprec = null;
        int index = 0;



        while (noeuds.size()>0){ //tant que la liste des noeuds n'est pas vide

            //calcule la distance la plus courte
            String u = null;
            double minDistance = Double.MAX_VALUE;

            for (String noeud : noeuds) { //pour chaque noeud
                double distance = v.getValeur(noeud);
                if (distance < minDistance) { //si la distance est plus petite que la distance minimale
                    minDistance = distance;
                    u = noeud;
                }
            }

            if (u == null) { //si u est null on sort de la boucle
                break;
            }


            noeuds.remove(u); //enlever le noeud u de la liste des noeuds

            for (int i = 0; i < g.suivants(u).size(); i++) { //pour chaque arc sortant

                Arc arc = g.suivants(u).get(i);
                double DEstimation = v.getValeur(u) + arc.getCout();
                String dest = arc.getDest();
                if (DEstimation < v.getValeur(dest)) { //si la valeur de dest est plus grande que la valeur de n + le cout de l'arc
                    vprec = v;
                    v.setValeur(dest, DEstimation);
                    v.setParent(dest, u);
                    index ++;
                    System.out.println(index + ". valeur de " + dest + " est " + v.getValeur(dest));
                }


            }
        }
        System.out.println("nombre d'itération : "+index);
        //calculer le temps d'exécution
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("temps d'exécution : "+duration/1000000+" milisecondes");
        return v;
    }
}
