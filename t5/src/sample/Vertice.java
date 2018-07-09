package sample;

import javafx.scene.shape.Circle;


public class Vertice {
    private Circle circle;

    public Vertice(Circle circle) {
        this.circle = circle;

    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }


    public boolean estaEmUmVertice(double x, double y){
        if (Math.sqrt(((x-circle.getCenterX())*(x-circle.getCenterX()))+((y-circle.getCenterY())*(y-circle.getCenterY())))<this.circle.getRadius()){
            return true;
        }
        return false;
    }
}
