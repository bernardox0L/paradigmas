package sample;


import javafx.scene.shape.Circle;
import java.util.ArrayList;

public class Vertex {
    private ArrayList<Edge> arestas;
    private Circle circulo;

    public Vertex(double x2, double y2) {
        this.arestas = new ArrayList<Edge>();
        this.circulo = new Circle(x2, y2, 20);
    }
    public Circle getCircle(){
        return circulo;
    }
    public void setCirculoX(double x2){
        if(x2>600){
            x2=600;
        }
        else if (x2<200){
            x2=200;
        }
        circulo.setCenterX(x2);

    }
    public void setCirculoY(double y2){
        if(y2>500){
            y2=500;
        }
        else if (y2<100){
            y2=100;
        }
        circulo.setCenterY(y2);

    }
    public void addAresta(Edge aresta){
        this.arestas.add(aresta);
    }

    public ArrayList<Edge> getArestas() {
        return arestas;
    }
}
