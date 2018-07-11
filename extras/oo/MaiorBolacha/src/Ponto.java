import static java.lang.StrictMath.sqrt;

public class Ponto {
    private double x;
    private double y;
    public Ponto() {
        x=0.0;
        y=0.0;
    }
    public Ponto(double x,double y) {
        this.x=x;
        this.y=y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void desloca(double dx, double dy){
        x= x+dx;
        y= y+dy;
    }
    public double calculaDistancia(double x1,double x2,double y2,double y1){
        double dx = x2 - x1;
        double dy = y2 - y1;
        double dist = sqrt(dx*dx + dy*dy);
        return dist;
    }
}
