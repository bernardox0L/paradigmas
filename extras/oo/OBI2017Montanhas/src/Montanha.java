import java.util.ArrayList;

public class Montanha {
    private ArrayList<Integer> montanha;

    public Montanha(){
        montanha=new ArrayList<>();
    }

    public void addAltura(int alt){
        if(alt>=1 && alt<=1000)
            montanha.add(alt);
    }

    public boolean temDoisPicos(){
        int a,b,c;
        if(montanha.size()>=3){
            for(int i=1; i<montanha.size()-1;i++){
                a=montanha.get(i-1);
                b=montanha.get(i);
                c=montanha.get(i+1);
                if(b<a && b<c)
                    return true;
            }
        }
        return false;
    }
}
