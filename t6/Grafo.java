package sample;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;

public class Grafo {
    public ArrayList<Vertex> vertices;
    public ArrayList<Edge> arestas;

    public Grafo() {
        vertices = new ArrayList<Vertex>();
        arestas = new ArrayList<Edge>();
    }

    public Vertex addVertex(double x, double y) {
        Vertex vertice = new Vertex(x, y);
        vertices.add(vertice);
        return vertice;
    }

    public void addAresta(Vertex inicio, Vertex fim) {
        if(!existeAresta(inicio,fim)) {
            Edge aresta = new Edge(inicio, fim);
            arestas.add(aresta);
            inicio.addAresta(aresta);
            fim.addAresta(aresta);
        }
    }
    public void escolheNivel(Object lvl, Object dific){
        //if(dific=="Médio"){
          //  if(lvl=="1"){
                addVertices(7);
                addArestas(5);
            //}
        //}
    }
    public void addVertices(int numV){
        for(int i=0;i<numV;i++){
            addVertex(0,0);
        }
        espalhaVertices();
    }

    public void addArestas(int numA) {
        Random rand = new Random();
        int num1,num2;
        for(int i=0;i<numA;i++) {
            num1= i;
            num2= rand.nextInt(vertices.size());
            if(num1!=num2 && !existeAresta(vertices.get(num1),vertices.get(num2)))
                addAresta(vertices.get(num1),vertices.get(num2));
            else
                i--;
        }
    }
    public Vertex procuraVertice(double x, double y) {
        for (Vertex vertice : vertices) {
            Shape circulo = Shape.intersect(vertice.getCircle(), new Circle(x, y, 1));
            if (circulo.getBoundsInLocal().getWidth() != -1)
                return vertice;
        }
        return null;
    }

    public void espalhaVertices() {
        Random rand = new Random();
        for (Vertex vertice : vertices) {
            vertice.setCirculoX(rand.nextInt(800));
            vertice.setCirculoY(rand.nextInt(600));
        }
    }
    public boolean existeAresta(Vertex inicio, Vertex fim){
        for (Edge aresta : arestas) {
            if(inicio==aresta.getInicio()&& fim==aresta.getFim()){
                return true;
            }
            else if(inicio==aresta.getFim() && fim == aresta.getInicio()){
                return true;
            }
        }
        return false;
    }

    public int interseccaoArestas() {
        int asobre=0;
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.get(i).getArestas().size(); j++) {
                for (int k = 0; k < vertices.size(); k++) {
                    for (int l = 0; l < vertices.get(k).getArestas().size(); l++) {
                        Edge a1 = vertices.get(i).getArestas().get(j);
                        Edge a2 = vertices.get(k).getArestas().get(l);
                        if (a1.getInicio() != a2.getInicio() && a1.getInicio()!= a2.getFim() && a1.getFim()!=a2.getInicio() && a1.getFim()!= a2.getFim() && Line2D.linesIntersect(a1.getLinha().getStartX(), a1.getLinha().getStartY(), a1.getLinha().getEndX(), a1.getLinha().getEndY(), a2.getLinha().getStartX(), a2.getLinha().getStartY(), a2.getLinha().getEndX(), a2.getLinha().getEndY())){
                            asobre++;
                        }
                    }
                }
            }
        }
        return asobre/2;

    }
}