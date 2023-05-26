import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


//génere la javadoc


public class GrapheListe implements Graphe{

    //attributs

    /**
     * ensemble des noms des noeuds
     */

    private List<String> ensNom;

    /**
     * ensemble des noeuds
     */

    private List<Noeud> ensNoeuds;


    //constructeurs

    /**
     * constructeur par défaut
     */

    public GrapheListe (){
        ensNom = new ArrayList<String>();
        ensNoeuds = new ArrayList<Noeud>();
    }

    /**
     * constructeur à partir d'un fichier
     * @param nomFichier
     * @throws IOException
     */
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

    /**
     * constructeur à partir d'un graphe
     * @return noeuds les noeuds du graphe
     */


    @Override
    public List<String> listeNoeuds() {
        List<String> noeuds = new ArrayList<>();
        for (Noeud noeud : ensNoeuds) {
            noeuds.add(noeud.getNom());
        }
        return noeuds;
    }

    /**
     * retourne les noeuds suivants
     *
     * @param n le nom du noeud
     * @return les noeuds suivants
     */

    @Override
    public List<Arc> suivants(String n) {
        for(int i = 0 ; i < ensNoeuds.size(); i++){
            Noeud noeud = ensNoeuds.get(i);
            if(n.equals(noeud.getNom())){
                return noeud.getAdj();
            }
        }
        return null;
    }

    /**
     * Permet d'ajouter un arc au graphe
     *
     * @param depart noeud de départ
     * @param des noeud de destination
     * @param cout cout de l'arc
     */
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

    /**
     * Permet d'afficher le graphe
     * @return aff l'affichage du graphe
     */

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

    /**
     * Permet d'afficher le graphe au format Graphviz
     * @return aff l'affichage du graphe
     */

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
