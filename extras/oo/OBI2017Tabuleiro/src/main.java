//https://olimpiada.ic.unicamp.br/static/extras/obi2017/provas/ProvaOBI2017_f2pj.pdf OBI 2017- Tabuleiro
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        int tam=0;
        System.out.println("Qual o tamanho do tabuleiro? ");
        Scanner scanner = new Scanner(System.in);
        while (tam>100 || tam<2)
            tam = scanner.nextInt();
        Tabuleiro tabuleiro=new Tabuleiro(tam);
        tabuleiro.addPecas();
        int cor=tabuleiro.descobreNN();
        System.out.println(cor);
    }
}
