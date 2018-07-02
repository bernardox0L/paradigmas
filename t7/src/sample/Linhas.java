package sample;

public class Linhas {
    private String nome;
    private int quant;

    public Linhas(String nome, int quant){
        this.nome = nome;
        this.quant = quant;
    }
    public String getNome(){
        return this.nome;
    }
    public int getQuant(){
        return this.quant;
    }
    public void incrementa(){
        this.quant++;
    }

}
