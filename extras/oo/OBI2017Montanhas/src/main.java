//https://olimpiada.ic.unicamp.br/static/extras/obi2017/provas/ProvaOBI2017_f2pj.pdf OBI 2017 - MONTANHA
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Montanha montanha = new Montanha();
        int numAlt = 0;
        int num = -1;
        Scanner scanner = new Scanner(System.in);
        //while (numAlt < 3 && numAlt > 1000){
            System.out.println("Quantas alturas você deseja? ");
            numAlt = scanner.nextInt();
        //}
        System.out.println("\nEscreva as alturas desejadas ");
        for(int i=0;i<numAlt;i++){
            num= scanner.nextInt();
            if(num>=1&&num<=1000){
                montanha.addAltura(num);
            }
            else{
                i--;
            }
        }
        boolean sn= montanha.temDoisPicos();
        if(sn==true)
            System.out.println("\n S");
        else
            System.out.println("\n N");
    }
}
