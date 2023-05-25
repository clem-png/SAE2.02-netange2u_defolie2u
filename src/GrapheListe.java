import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe{

    private List<String> ensNom;

    private List<Noeud> ensNoeuds;

    public GrapheListe (){
        ensNom = new ArrayList<String>();
        ensNoeuds = new ArrayList<Noeud>();
    }

    public GrapheListe(String nomFichier) throws IOException {

        ensNom = new ArrayList<String>();
        ensNoeuds = new ArrayList<Noeud>();

        BufferedReader br = new BufferedReader(new FileReader(nomFichier));
        String ligne;
        while ((ligne = br.readLine()) != null) {
            String[] tab = ligne.split("\t");
            if (tab.length == 3) {
                ajouterArc(tab[0], tab[1], Double.parseDouble(tab[2]));
            }
        }
        br.close();
    }


    @Override
    public List<String> listeNoeuds() {
        List<String> noeuds = new ArrayList<>();
        for (Noeud noeud : ensNoeuds) {
            noeuds.add(noeud.getNom());
        }
        return noeuds;
    }

    @Override
    public List<Arc> suivants(String n) {
        for(Noeud noeud : ensNoeuds){
            if(n.equals(noeud.getNom())){
                return noeud.getAdj();
            }
        }
        return null;
    }


    public void ajouterArc(String depart, String des, double cout){

        if(this.ensNom == null){
            Noeud n = new Noeud(depart);
            ensNom.add(depart);
            ensNoeuds.add(n);
        }
        if(!ensNom.contains(depart)){
            Noeud n = new Noeud(depart);
            ensNom.add(depart);
            ensNoeuds.add(n);
        }
        /*
        if (!ensNom.contains(des)){
            Noeud ne = new Noeud(des);
            ensNom.add(des);
            ensNoeuds.add(ne);
        }
        */


        boolean t = false;
        int i = 0;

        while (!t){
            if(ensNom.get(i).equals(depart)){
                ensNoeuds.get(i).ajouterArc(des,cout);
                t = true;
            }

            i++;
        }
    }

    public String toString(){
        String aff = "graphe : ";

        for (int i = 0; i < ensNoeuds.size(); i++){
            aff += "\n" + ensNoeuds.get(i).getNom() + " -> ";

            List<Arc> a =  suivants(ensNoeuds.get(i).getNom());

            for(int j = 0; j < a.size(); j++){
                    aff += a.get(j).getDest() + "(" + a.get(j).getCout() + ") ";
            }
        }
        return aff;
    }

    public String toGraphviz(){

        String aff = "digraph X { \n";

        for (int i = 0; i < ensNoeuds.size(); i++){


            List<Arc> a =  suivants(ensNoeuds.get(i).getNom());

            for(int j = 0; j < a.size(); j++){
                aff += "\n" + ensNoeuds.get(i).getNom() + " -> " + a.get(j).getDest() + " [label" + " = " + a.get(j).getCout() + "]";
            }
        }
        return aff += "\n}";
    }

}
