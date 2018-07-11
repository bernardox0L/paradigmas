import java.util.ArrayList;
import java.util.Random;

public class Bolachas {
    private ArrayList<Circle> bolCirc;
    private ArrayList<Retangulo> bolRet;
    private ArrayList<Triangulo> bolTri;

    public Bolachas(){
        bolCirc=new ArrayList<>();
        bolRet=new ArrayList<>();
        bolTri=new ArrayList<>();
    }
    public void cozinhaBolachas(){
        double x,y;
        x=6;
        y=6;
        Random rand = new Random();
        for(int i=0;i<17;i++){
            Circle circ = new Circle(rand.nextInt(3)+1,new Ponto(x,y));
            bolCirc.add(circ);
            x+=6;
            if(x>7*6){
                x=6;
                y+=6;
            }
        }
        for(int i=0;i<17;i++){
            Retangulo ret = new Retangulo(rand.nextInt(6)+1,rand.nextInt(6)+1,new Ponto(x,y));
            bolRet.add(ret);
            x+=6;
            if(x>7*6){
                x=6;
                y+=6;
            }
        }
        for(int i=0;i<16;i++){
            Triangulo tri = new Triangulo(rand.nextInt(6)+1,rand.nextInt(6)+1,new Ponto(x,y));
            bolTri.add(tri);
            x+=6;
            if(x>7*6){
                x=6;
                y+=6;
            }
        }
    }
    public void maiorBolacha(){
        Ponto ponto=new Ponto();
        double maiorArea=0;
        int imag=-1;//0 circ, 1 ret, 2 tri
        for(int i=0;i<bolCirc.size();i++){
            if(bolCirc.get(i).calculaArea()>maiorArea){
                ponto=bolCirc.get(i).getPonto();
                imag=0;
                maiorArea=bolCirc.get(i).calculaArea();
            }
        }
        for(int i=0;i<bolRet.size();i++){
            if(bolRet.get(i).calculaArea()>maiorArea){
                ponto=bolRet.get(i).getPonto();
                imag=1;
                maiorArea=bolRet.get(i).calculaArea();
            }
        }
        for(int i=0;i<bolTri.size();i++){
            if(bolTri.get(i).calculaArea()>maiorArea){
                ponto=bolTri.get(i).getPonto();
                imag=2;
                maiorArea=bolTri.get(i).calculaArea();
            }
        }
        if (imag==0){
            System.out.println("A maior bolacha é redonda, tem área de "+maiorArea+", e está no ponto ("+ponto.getX()+","+ponto.getY()+").");
        }
        else if (imag==1){
            System.out.println("A maior bolacha é retangular, tem área de "+maiorArea+", e está no ponto ("+ponto.getX()+","+ponto.getY()+").");
        }
        else if (imag==2){
            System.out.println("A maior bolacha é triângular, tem área de "+maiorArea+", e está no ponto ("+ponto.getX()+","+ponto.getY()+").");
        }
    }
}
