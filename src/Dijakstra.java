import java.util.ArrayList;
import java.util.List;

public class Dijakstra {


    public Valeur resoudre(Graphe g, String depart) {

        List<String> noeuds = new ArrayList<String>();
        noeuds.add(depart);
        //point fixe utiliser la classe Valeur
        Valeur v = new Valeur();
        for (int k = 0; k < g.listeNoeuds().size(); k++) {
            String noeud = g.listeNoeuds().get(k);
            v.setValeur(noeud, Double.MAX_VALUE);
            if (!noeud.equals(depart)){
                noeuds.add(noeud);
            }
        }

        v.setValeur(depart, 0.0);

        int indice = 0;
        Valeur vprec = null;
        while (noeuds.size()>0){
            String u = null;
            double minDistance = Double.MAX_VALUE;
            for (String noeud : noeuds) {
                double distance = v.getValeur(noeud);
                if (distance < minDistance) {
                    minDistance = distance;
                    u = noeud;
                }
            }

            if (u == null) {
                break;
            }

            // Enlever le sommet u de la liste Q (noeuds)

            //pas finie
            noeuds.remove(u);

            for (int i = 0; i < g.suivants(u).size(); i++) {
                Arc arc = g.suivants(u).get(i);
                double DEstimation = v.getValeur(u) + arc.getCout();
                String dest = arc.getDest();
                if (DEstimation < v.getValeur(dest)) {
                    vprec = v;
                    v.setValeur(dest, DEstimation);
                    v.setParent(dest, u);
                }
            }
        }

        return v;
    }
}
