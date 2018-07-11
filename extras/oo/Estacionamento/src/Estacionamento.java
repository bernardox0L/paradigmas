import java.util.ArrayList;

public class Estacionamento {
    private ArrayList<Veiculo> veiculo;
    private double precoCarro = 3.0;
    private double precoMoto = 1.5;

    public Estacionamento() {
        veiculo = new ArrayList<>();
    }
    public void addVeiculo(Veiculo veiculo){
        this.veiculo.add(veiculo);
    }
    public void saiVeiculo(Veiculo veiculo){
        long horaEntrada=veiculo.getHoraEntrada();
        long horaSaida= System.currentTimeMillis();
        long tempo= horaSaida-horaEntrada;
        double preco=0;
        double tempo2= (tempo);
        if(veiculo.getTipoVeiculo()=='c'){
            preco= tempo2 *3;
        }
        else{
            preco= tempo2 * 1.5;
        }
        System.out.println("O veículo com a placa "+veiculo.getPlaca()+" irá pagar "+preco+" reais.");
        this.veiculo.remove(veiculo);
    }
}
