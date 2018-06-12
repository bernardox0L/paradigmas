package sample;

import javafx.scene.shape.Line;

public class Edge {
    private Vertex inicio;
    private Vertex fim;
    private Line linha;

    public Edge(Vertex inicio2, Vertex fim2) {
        inicio = inicio2;
        fim = fim2;
        linha = new Line(inicio2.getCircle().getCenterX(), inicio2.getCircle().getCenterY(), fim2.getCircle().getCenterX(), fim2.getCircle().getCenterY());

    }
    public Vertex getInicio() {
        return inicio;
    }
    public Vertex getFim() {
        return fim;
    }
    public Line getLinha() {
        return linha;
    }
}
