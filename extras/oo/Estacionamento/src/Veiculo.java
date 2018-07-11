public class Veiculo {
    private char tipoVeiculo; //c = carro m = moto
    private String placa;
    private long horaEntrada;

    public Veiculo(char tipoVeiculo, String placa) {
        this.tipoVeiculo = tipoVeiculo;
        this.placa = placa;
        this.horaEntrada = System.currentTimeMillis();
    }

    public long getHoraEntrada() {
        return horaEntrada;
    }

    public char getTipoVeiculo() {
        return tipoVeiculo;
    }

    public String getPlaca() {
        return placa;
    }
}
