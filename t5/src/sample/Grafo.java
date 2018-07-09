package sample;

import javafx.scene.shape.Line;

import java.awt.geom.Line2D;
import java.util.ArrayList;

public class Grafo {
    private ArrayList<Vertice> vertex;
    private ArrayList<Aresta> edges;

    public Grafo() {
        this.vertex = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
    public ArrayList<Vertice> getVertex() {
        return vertex;
    }

    public void addVertex(Vertice vert) {
        this.vertex.add(vert);
    }

    public int getNumVertices() {
        return vertex.size();
    }

    public Vertice clickVertice(double x, double y) {
        for (int i = 0; i < vertex.size(); i++) {
            if (vertex.get(i).estaEmUmVertice(x, y)) {
                return vertex.get(i);
            }
        }
        return null;
    }
    public ArrayList<Aresta> getEdges() {
        return edges;
    }
    public void addEdge(Aresta a){
        this.edges.add(a);

    }
    public boolean arestaExiste(Vertice inicio, Vertice fim) {
        Aresta temp = new Aresta(new Line(),inicio,fim);
        for(int i=0; i<edges.size();i++){
            if((temp.getStart()==edges.get(i).getStart() && temp.getEnd()==edges.get(i).getEnd())||(temp.getStart()==edges.get(i).getEnd() && temp.getEnd()==edges.get(i).getStart())){
                return true;
            }
        }
        return false;
    }
    public int getNumArestas(){
        return edges.size();
    }
    public int getNumAresSob() {
        int sobrep=0;
        for (int a = 0; a < edges.size(); a++) {
            for (int b = 0; b < edges.size(); b++) {
                Aresta aresta1 = edges.get(a);
                Aresta aresta2 = edges.get(b);
                if (aresta1.getStart() != aresta2.getStart()
                        && aresta1.getStart()!= aresta2.getEnd()
                        && aresta1.getEnd()!=aresta2.getStart()
                        && aresta1.getEnd()!= aresta2.getEnd()
                        && Line2D.linesIntersect(aresta1.getLine().getStartX(), aresta1.getLine().getStartY(), aresta1.getLine().getEndX(), aresta1.getLine().getEndY(), aresta2.getLine().getStartX(), aresta2.getLine().getStartY(), aresta2.getLine().getEndX(), aresta2.getLine().getEndY()))
                    sobrep++;
            }
        }
        return sobrep/2;
    }
}
