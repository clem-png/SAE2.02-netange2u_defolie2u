import java.util.*;
import java.util.ArrayList;

public class Noeud {

    //attributs

    /**
     * nom du noeud
     */
    private String nom;

    /**
     * liste des arcs sortants
     */
    private List<Arc> adj;

    //constructeurs

    /**
     * constructeur par défaut
     * @param nom
     */

    public Noeud(String nom) {
        this.nom = nom;
        this.adj = new ArrayList<Arc>();
    }

    //méthodes

    /**
     * Permet de vérifier si deux noeuds sont égaux
     * @param n noeud
     */

    public boolean equals(Noeud n) {
        return this.nom.equals(n.getNom());
    }

    /**
     * Permet de récupérer le nom du noeud
     * @return nom du noeud
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Permet de récupérer la liste des arcs sortants
     * @return liste des arcs sortants
     */

    public void ajouterArc(String destination, double court){
        Arc a = new Arc(destination, court);
        this.adj.add(a);
    }

    /**
     * getter de la liste des arcs
     * @return liste des arcs sortants
     */

    public List<Arc> getAdj() {
        return this.adj;
    }


}
