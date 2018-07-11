public class Circle {
    private int raio;
    private Ponto local;

    public Circle(int raio, Ponto ponto) {
        this.raio=raio;
        local= ponto;
    }

    public double calculaArea(){
        return raio*raio*3.14;
    }
    public Ponto getPonto(){
        return local;
    }
}
