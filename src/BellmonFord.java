import java.util.ArrayList;
import java.util.List;

public class BellmonFord implements Algorithme{


    /**
     * Permet de résoudre le problème du plus court chemin
     * @param g un graphe
     * @param depart noeud de départ
     * @return v un objet valeur
     */

    public Valeur resoudre(Graphe g, String depart){

        //calculer le temps d'exécution
        long startTime = System.nanoTime();

        //point fixe utiliser la classe Valeur
        Valeur v = new Valeur(); //valeur de chaque noeud
        for (String noeud : g.listeNoeuds()) { //initialisation de la valeur de chaque noeud
            v.setValeur(noeud, Double.MAX_VALUE);
        }

        v.setValeur(depart, 0.0); //valeur du noeud de départ

        Valeur vprec = null; //valeur précédente

        int index = 0; //nombre d'itération
        //tant que v change
        while (v != vprec) {

            for (int i = 0; i < g.listeNoeuds().size(); i++) {  //pour chaque noeud
                String n = g.listeNoeuds().get(i);
                for (int j = 0; j< g.suivants(n).size(); j++) { //pour chaque arc sortant
                    Arc arc = g.suivants(n).get(j); //arc sortant
                    double DEstimation = v.getValeur(n) + arc.getCout(); //valeur de n + cout de l'arc
                    String dest= arc.getDest();
                    if (DEstimation < v.getValeur(dest)) { //si la valeur de dest est plus grande que la valeur de n + le cout de l'arc
                        vprec = v; //valeur précédente
                        v.setValeur(dest, DEstimation);
                        v.setParent(dest, n);
                        index ++;

                        //afficher la valeur de chaque noeud
                        //System.out.println(index + ". valeur de " + dest + " est " + v.getValeur(dest));
                    }
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
