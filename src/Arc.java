
public class Arc {
    private String dest;
    private double cout;


    public Arc(String d, double c){
        if(c<0){
            this.cout=1;
        }else {
            this.cout=c;
        }
        this.dest=d;
    }
}
