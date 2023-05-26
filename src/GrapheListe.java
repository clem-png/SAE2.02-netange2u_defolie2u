import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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

    /**
     * Methode qui genere un graphe avec un nombre de noeud souhaiter et un nombre d'arc aleatoire
     * @param NbNoeud Le nombre de noeud souhaiter
     * @return Retourne un objet GrapheListe
     */
    public GrapheListe GenererGraphe(int NbNoeud) {
        //On commence par creer un graphe vide et on ajoute le nombre de noeud dans les listes
        GrapheListe g = new GrapheListe();

        for (int i = 1; i < NbNoeud+1; i++) {
            String nomNoeud = "Noeud" + i;
            g.ensNom.add(nomNoeud);
            g.ensNoeuds.add(new Noeud(nomNoeud));
        }
        //Je commence par créé un arc linéaire entre tout les noeuds (Noeud0 -> Noeud1, Noeud1 -> Noeud2, etc...) avec un cout aleatoire
        for (int k = 0; k < NbNoeud; k++) {

            Random r = new Random();
            int cout = r.nextInt(100);
            int prochainNoeud = +k + 1;
            if (prochainNoeud != k) {
                g.ajouterArc("Noeud" + k, "Noeud" + prochainNoeud, cout);
            }
        }
        //Je créé ensuite des arcs aléatoire entre les noeuds
        for (int a = 1; a < NbNoeud*3; a++) {
            Random r = new Random();

            int coutAlea = r.nextInt(100);
            int premierNoeud = r.nextInt(NbNoeud);
            int NoeudSuivant = r.nextInt(NbNoeud);
            if (premierNoeud != NoeudSuivant && !g.ensNoeuds.get(premierNoeud).getAdj().contains(NoeudSuivant)) {
                g.ajouterArc("Noeud" + premierNoeud, "Noeud" + NoeudSuivant, coutAlea);
            }
        }
        return g;

    }

    /**
     *Getter de la liste des noeuds
     * @return ensNom la liste des nom des noeuds
     */
    public List<String> getEnsNom() {
        return ensNom;
    }

    /**
     *Getter de la liste des noeuds
     * @return ensNoeuds la liste des noeuds
     */
    public List<Noeud> getEnsNoeuds() {
        return ensNoeuds;
    }
}
