import java.util.ArrayList;
import java.util.List;

public class BellmonFord implements Algorithme{

    /*
    * Algorithme de Bellmon-Ford
    *
    * Algorithme pointFixe(Graphe G, Noeud A) :

    Pour chaque noeud X dans G
	X.distance <- Infini
	X.parent <- NULL
    Fin pour

	A.distance <- 0

    Tant que g converge
	pour chaque noeud X dans G faire
		pour chaque noeud N adjacent à X
		    coutNoeudCourant <- L[X].getCout() + L[N].getCout()
			destination <- L[N].getDest();
			Si nouveauCout > CoutNoeudCourant faire
				N.distance <- nouveauCout
				N.parent <- X
			FSi
		Fpour
	Fpour
     FTant

Fin Algorithme


     */


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

        //tant que v change
        while (v != vprec) {

            for (int i = 0; i < g.listeNoeuds().size(); i++) {  //pour chaque noeud
                String n = g.listeNoeuds().get(i);
                for (int j = 0; j< g.suivants(n).size(); j++) { //pour chaque arc sortant
                    //System.out.println("noeud : "+n);
                    Arc arc = g.suivants(n).get(j); //arc sortant
                    double DEstimation = v.getValeur(n) + arc.getCout(); //valeur de n + cout de l'arc
                    String dest= arc.getDest();
                    //System.out.println("destination : " + dest);
                    if (DEstimation < v.getValeur(dest)) { //si la valeur de dest est plus grande que la valeur de n + le cout de l'arc
                        vprec = v; //valeur précédente
                        v.setValeur(dest, DEstimation);
                        v.setParent(dest, n);
                        System.out.println(v.toString());
                    }
                }
            }
        }

        return v;
    }
}
