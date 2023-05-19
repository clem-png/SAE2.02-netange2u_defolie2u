import java.util.*;

public interface Graphe {
    public List<String> listeNoeuds();
    public List<Arc> suivants(String n);

}