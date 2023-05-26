/**
 * Classe Arc
 * Représente un arc entre 2 arcs
 */
public class Arc {

    //attributs
    /**
     * destination de l'arc
     */
    private String dest;

    /**
     * cout de l'arc
     */
    private double cout;

    //constructeurs

    /**
     * constructeur par défaut
     * @param d destination de l'arc
     * @param c cout de l'arc
     */


    public Arc(String d, double c){
        if(c<0){//si le cout est négatif on le met à 1
            this.cout=1;
        }else {
            this.cout=c;
        }
        this.dest=d;
    }

    //méthodes

    /**
     * getter de la destination de l'arc
     * @return destination de l'arc
     */

    public String getDest() {
        return dest;
    }

    /**
     * getter du cout de l'arc
     * @return cout de l'arc
     */

    public double getCout() {
        return cout;
    }
}
