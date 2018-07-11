//https://olimpiada.ic.unicamp.br/static/extras/obi2017/provas/ProvaOBI2017_f2pj.pdf QUESTÃO 1
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Cartas cartas=new Cartas();
        int i=-1,j=-1,k=-1;
        Scanner scanner = new Scanner(System.in);
        while (i>100 || i<0)
            i = scanner.nextInt();
        cartas.cartasAdd(i);
        while (j>100 || j<0)
            j = scanner.nextInt();
        cartas.cartasAdd(j);
        while (k>100 || k<0)
            k = scanner.nextInt();
        cartas.cartasAdd(k);

        int faltando;
        faltando = cartas.procuraFaltando();
        if(faltando==101)
            System.out.println("Não existem dois valores iguais no array");
        else
            System.out.println("A carta que falta é: "+faltando);

    }
}
