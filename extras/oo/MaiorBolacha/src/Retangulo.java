public class Retangulo {
    private int altura;
    private int largura;
    private Ponto local;

    public Retangulo(int alt, int larg, Ponto ponto) {
        altura=alt;
        largura=larg;
        local= ponto;
    }

    public double calculaArea(){
        return altura*largura;
    }
    public Ponto getPonto(){
        return local;
    }
}
