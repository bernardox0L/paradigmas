import java.util.Scanner;

public class Tabuleiro {
    private int tabuleiro[][];

    public Tabuleiro(int n){
        tabuleiro=new int[n][n];
    }
    public void addPecas(){
        Scanner scanner = new Scanner(System.in);
        for (int i=0; i<tabuleiro.length; i++)
            for (int j=0; j<tabuleiro.length; j++)
                tabuleiro[i][j]=scanner.nextInt();
    }
    public int descobreNN(){
        for (int i=1; i<tabuleiro.length; i++)
            for (int j=1; j<tabuleiro.length; j++)
                if (tabuleiro[i-1][j-1]+tabuleiro[i-1][j]+tabuleiro[i][j-1]>=2)
                    tabuleiro[i][j]=0;
                else
                    tabuleiro[i][j]=1;
        return tabuleiro[tabuleiro.length-1][tabuleiro.length-1];
    }
}
