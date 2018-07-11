// ESTACIONAMENTO parte 2 fonte: http://www-usr.inf.ufsm.br/~andrea/elc117-2015b/trabs/t9-oo.html  PARTE 1 FOI USADA NO TRABALHO DE MAIOR BOLACHA
public class main {
    public static void main(String[] args) {
        Estacionamento est = new Estacionamento();
        Veiculo c1 = new Veiculo('c',"AAAAAA");
        Veiculo m1 = new Veiculo('m',"BBBBBB");
        est.addVeiculo(c1);
        est.addVeiculo(m1);
        try {
            Thread.sleep (5);
        }
        catch (InterruptedException ex) {}
        est.saiVeiculo(m1);
        est.saiVeiculo(c1);
    }
}
