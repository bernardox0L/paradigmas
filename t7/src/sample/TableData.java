package sample;

import javafx.beans.property.SimpleStringProperty;

public class TableData {
    private final SimpleStringProperty data;
    private final SimpleStringProperty ordem;
    private final SimpleStringProperty longitude;
    private final SimpleStringProperty latitude;
    private final SimpleStringProperty velocidade;
    private final SimpleStringProperty linha;



    public TableData(String data, String ordem, String linha, String latidude, String longitude, String velocidade){
        this.data= new SimpleStringProperty(data);
        this.ordem = new SimpleStringProperty(ordem);
        this.linha = new SimpleStringProperty(linha);
        this.latitude = new SimpleStringProperty(latidude);
        this.longitude = new SimpleStringProperty(longitude);
        this.velocidade = new SimpleStringProperty(velocidade);
    }

    public SimpleStringProperty dataProperty() {
        return data;
    }
    public String getData() {
        return data.get();
    }
    public void setData(String data) {
        this.data.set(data);
    }
    public SimpleStringProperty ordemProperty() {
        return ordem;
    }
    public String getOrdem() {
        return ordem.get();
    }
    public void setOrdem(String ordem) {
        this.ordem.set(ordem);
    }
    public SimpleStringProperty linhaProperty() {
        return linha;
    }
    public String getLinha() {
        return linha.get();
    }
    public void setLinha(String linha) {
        this.linha.set(linha);
    }
    public SimpleStringProperty latitudeProperty() {
        return latitude;
    }
    public String getLatitude() {
        return latitude.get();
    }
    public void setLatitude(String latitude) {
        this.latitude.set(latitude);
    }
    public SimpleStringProperty longitudeProperty() {
        return longitude;
    }
    public String getLongitude() {
        return longitude.get();
    }
    public void setLongitude(String longitude) {
        this.longitude.set(longitude);
    }
    public SimpleStringProperty velocidadeProperty() {
        return velocidade;
    }
    public String getVelocidade() {
        return velocidade.get();
    }
    public void setVelocidade(String velocidade) {
        this.velocidade.set(velocidade);
    }
}
