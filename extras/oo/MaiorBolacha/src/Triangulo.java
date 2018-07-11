public class Triangulo {
    private int altura;
    private int largura;
    private Ponto local;

    public Triangulo(int alt, int larg, Ponto ponto) {
        altura=alt;
        largura=larg;
        local= ponto;
    }

    public double calculaArea(){
        return altura*largura/2;
    }
    public Ponto getPonto(){
        return local;
    }
}
