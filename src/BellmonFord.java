import java.util.ArrayList;
import java.util.List;

public class BellmonFord implements Algorithme{

    public Valeur resoudre(Graphe g, String depart){
        //point fixe utiliser la classe Valeur
        Valeur v = new Valeur();
        for (String noeud : g.listeNoeuds()) {
            v.setValeur(noeud, Double.MAX_VALUE);
        }

        v.setValeur(depart, 0.0);

        Valeur vprec = null;

        int index = 0;
        //tant que v change
        while (v != vprec) {

            for (int i = 0; i < g.listeNoeuds().size(); i++) {
                String n = g.listeNoeuds().get(i);
                for (int j = 0; j< g.suivants(n).size(); j++) {
                    Arc arc = g.suivants(n).get(j);
                    double DEstimation = v.getValeur(n) + arc.getCout();
                    String dest= arc.getDest();
                    if (DEstimation < v.getValeur(dest)) {
                        vprec = v;
                        v.setValeur(dest, DEstimation);
                        v.setParent(dest, n);
                        index ++;
                        System.out.println(index + ". valeur de " + dest + " est " + v.getValeur(dest));
                    }
                }
            }
        }
        System.out.println("nombre d'itération : "+index);
        return v;
    }
}
