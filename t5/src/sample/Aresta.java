package sample;

import javafx.scene.shape.Line;

public class Aresta {
    private Line line;
    private Vertice start;
    private Vertice end;

    public Aresta(Line line, Vertice start, Vertice end) {
        this.line = line;
        this.start = start;
        this.end = end;
    }

    public Vertice getEnd() {
        return end;
    }

    public void setEnd(Vertice end) {
        this.end = end;
    }

    public double getEndX() {
        return end.getCircle().getCenterX();
    }

    public double getEndY() {
        return end.getCircle().getCenterY();
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public Vertice getStart() {
        return start;
    }

    public double getStartX() {
        return start.getCircle().getCenterX();
    }

    public double getStartY() {
        return start.getCircle().getCenterY();
    }

    public void setStart(Vertice start) {
        this.start = start;
    }

}
