import java.util.ArrayList;

public class Cartas {
    private ArrayList<Integer> num;

    public Cartas(){
        num=new ArrayList<>();
    }
    public void cartasAdd(int num){
        if(num<=100&&num>=0){
            this.num.add(num);
        }
    }
    public int procuraFaltando(){
        if(num.get(0)==num.get(1))
            return num.get(2);
        else if(num.get(0)==num.get(2))
            return num.get(1);
        else if(num.get(1)==num.get(2))
            return num.get(0);
        return 101;
    }
}
