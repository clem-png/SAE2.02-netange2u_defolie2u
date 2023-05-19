import java.util.ArrayList;

public class Noeud {
    private String nom;
    private ArrayList<Arc> adj;

    public Noeud(String nom) {
        this.nom = nom;
        this.adj = new ArrayList<Arc>();
    }

    public boolean equals(Noeud n) {
        return this.nom.equals(n.getNom());
    }

    public String getNom() {
        return this.nom;
    }

    public void ajouterArc(String destination, double court){
        Arc a = new Arc(destination, court);
        this.adj.add(a);
    }

    
}
