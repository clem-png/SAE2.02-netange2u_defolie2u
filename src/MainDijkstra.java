public class MainDijkstra {

    public static void main(String[] args){
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A","B", 12);
        g.ajouterArc("A","D", 87);
        g.ajouterArc("B","E", 11);
        g.ajouterArc("C","A", 19);
        g.ajouterArc("D","C", 10);
        g.ajouterArc("D","B", 23);
        g.ajouterArc("E","D", 43);
        Dijakstra b = new Dijakstra();
        Valeur v = b.resoudre(g,"A");
        System.out.println(v.toString());
        System.out.println(v.calculerChemin("E"));


    }
}
