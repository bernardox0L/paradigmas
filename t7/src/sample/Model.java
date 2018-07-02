package sample;

import javafx.beans.property.SimpleStringProperty;

public class Model {
        private String data;
        private String ordem;
        private String longitude;
        private String latitude;
        private String velocidade;
        private String linha;



        public Model(String data, String ordem, String linha, String latitude, String longitude, String velocidade){
            this.data= data;
            this.ordem = ordem;
            this.linha = linha;
            this.latitude = latitude;
            this.longitude = longitude;
            this.velocidade = velocidade;
        }


        public String getData() {
            return data;
        }
        public void setData(String data) {
            this.data=data;
        }
        public String getOrdem() {
            return ordem;
        }
        public void setOrdem(String ordem) {
            this.ordem=ordem;
        }
        public String getLinha() {
            return linha;
        }
        public void setLinha(String linha) {
            this.linha=linha;
        }
        public String getLatitude() {
            return latitude;
        }
        public void setLatitude(String latitude) {
            this.latitude=latitude;
        }
        public String getLongitude() {
            return longitude;
        }
        public void setLongitude(String longitude) {
            this.longitude=longitude;
        }
        public String getVelocidade() {
            return velocidade;
        }
        public void setVelocidade(String velocidade) {
            this.velocidade=velocidade;
        }
}
