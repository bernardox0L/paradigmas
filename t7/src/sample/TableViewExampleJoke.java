package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;

public class TableViewExampleJoke extends Application {

    private HttpJSONService http = new HttpJSONService();

    private Label nv = new Label("-");
    private Label datarec = new Label("-");
    private Label dataant = new Label("-");
    private Label dataatt = new Label("-");

    private TableView<TableData> table = new TableView<TableData>();

    private final ObservableList<TableData> data =
            FXCollections.observableArrayList();
    public String numeroVeiculos="-";
    public ArrayList<Model> model;
    public ObservableList<PieChart.Data> pieChartData;
    public PieChart chart;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {


        Scene scene = new Scene(new Group());

        final Label label = new Label("Linhas de bus");
        label.setFont(new Font("Calibri", 20));

        TableColumn<TableData, String> fstCol = new TableColumn<TableData, String>("DATA/HORA");
        fstCol.setCellValueFactory(cellData -> cellData.getValue().dataProperty());
        TableColumn<TableData, String> sndCol = new TableColumn<TableData, String>("ORDEM");
        sndCol.setCellValueFactory(cellData -> cellData.getValue().ordemProperty());
        TableColumn<TableData, String> trdCol = new TableColumn<TableData, String>("LINHA");
        trdCol.setCellValueFactory(cellData -> cellData.getValue().linhaProperty());
        TableColumn<TableData, String> fthCol = new TableColumn<TableData, String>("LATITUDE");
        fthCol.setCellValueFactory(cellData -> cellData.getValue().latitudeProperty());
        TableColumn<TableData, String> fth5Col = new TableColumn<TableData, String>("LONGITUDE");
        fth5Col.setCellValueFactory(cellData -> cellData.getValue().longitudeProperty());
        TableColumn<TableData, String> sthCol = new TableColumn<TableData, String>("VELOCIDADE");
        sthCol.setCellValueFactory(cellData -> cellData.getValue().velocidadeProperty());


        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getColumns().add(fstCol);
        table.getColumns().add(sndCol);
        table.getColumns().add(trdCol);
        table.getColumns().add(fthCol);
        table.getColumns().add(fth5Col);
        table.getColumns().add(sthCol);
        table.setItems(data);

        pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Movimento", 0),
                        new PieChart.Data("Parado",0));

        Button btn = new Button("Baixar dados");
        Button btn2 = new Button("Abrir dados");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Map json = null;
                try {
                    json = http.sendGet("http://dadosabertos.rio.rj.gov.br/apiTransporte/apresentacao/rest/index.cfm/obterTodasPosicoes");
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning");
                    alert.setHeaderText("Connection failed");
                    alert.setContentText("Please check your Internet connection!");
                    alert.showAndWait();
                }
                if (json != null){
                    model = new ArrayList<>();
                    List<List> dados = (List<List>) json.get("DATA");
                    for(int i=0;i<dados.size();i++){
                        data.add(new TableData(dados.get(i).get(0).toString(),dados.get(i).get(1).toString(),dados.get(i).get(2).toString(),dados.get(i).get(3).toString(),(String)dados.get(i).get(4).toString(),dados.get(i).get(5).toString()));
                        model.add(new Model(dados.get(i).get(0).toString(),dados.get(i).get(1).toString(),dados.get(i).get(2).toString(),dados.get(i).get(3).toString(),dados.get(i).get(4).toString(),dados.get(i).get(5).toString()));
                    }
                    numeroVeiculos=numeroVeiculos(model);
                    nv.setText(numeroVeiculos);
                    dataant.setText(menosRecente(model));
                    datarec.setText(maisRecente(model));
                    String hatt= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
                    dataatt.setText(hatt);
                    pieChartData =
                            FXCollections.observableArrayList(
                                    new PieChart.Data("Movimento", numeroVeiculosMovimento(model)),
                                    new PieChart.Data("Parado",100-numeroVeiculosMovimento(model)));
                    chart.setData(pieChartData);
                }
            }
        });
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Map json=null;
                final FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Abrir JSON");
                fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
                fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JSON", "*.json"));
                File file = fileChooser.showOpenDialog(stage);
                try {
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    JSONParsing jp = new JSONParsing();
                    json = jp.parseJSON(br.readLine());
                    data.clear();
                } catch (Exception ex) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Erro");
                    alert.setHeaderText("Não foi possível ler o arquivo");
                    alert.setContentText("Por favor, tente novamente!");
                    alert.showAndWait();
                }
                if (json != null){
                    model = new ArrayList<>();
                    List<List> dados = (List<List>) json.get("DATA");
                    for(int i=0;i<dados.size();i++){
                        data.add(new TableData(dados.get(i).get(0).toString(),dados.get(i).get(1).toString(),dados.get(i).get(2).toString(),dados.get(i).get(3).toString(),(String)dados.get(i).get(4).toString(),dados.get(i).get(5).toString()));
                        model.add(new Model(dados.get(i).get(0).toString(),dados.get(i).get(1).toString(),dados.get(i).get(2).toString(),dados.get(i).get(3).toString(),dados.get(i).get(4).toString(),dados.get(i).get(5).toString()));
                    }
                    numeroVeiculos=numeroVeiculos(model);
                    nv.setText(numeroVeiculos);
                    dataant.setText(menosRecente(model));
                    datarec.setText(maisRecente(model));
                    String hatt= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
                    dataatt.setText(hatt);
                    pieChartData =
                            FXCollections.observableArrayList(
                                    new PieChart.Data("Movimento", numeroVeiculosMovimento(model)),
                                    new PieChart.Data("Parado",100-numeroVeiculosMovimento(model)));

                    chart.setData(pieChartData);
                }
            }
        });

        chart = new PieChart(pieChartData);
        chart.setTitle("% bus em movimento");
        HBox hbox= new HBox();
        HBox hbox2= new HBox();
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        nv.setText(numeroVeiculos);
        Label nve = new Label("Número de Ônibus: ");
        Label dataL = new Label("\tData mais recente: ");
        Label dataL2 = new Label("\tData mais antiga: ");
        Label dataL3 = new Label("\tData atualizaçao: ");
        hbox.getChildren().addAll(nve,nv,dataL,datarec,dataL2,dataant,dataL3,dataatt,chart);
        if(model!=null) {
            barGraph(hbox2);
            vbox.getChildren().add(hbox2);
        }
        vbox.getChildren().addAll(label, table, btn,btn2,hbox);
        vbox.applyCss();
        vbox.layout();

        stage.setScene(new Scene(vbox, 800, 600));
        stage.show();

    }
    private String numeroVeiculos(ArrayList<Model> model) {
        String modeltam = Integer.toString(model.size());
        return modeltam;
    }
    private Double numeroVeiculosMovimento(ArrayList<Model> model) {
        int busmov=0;
        Double vel;
        for(int i=0;i<model.size();i++){
            vel = Double.parseDouble(model.get(i).getVelocidade());
            if(0 != vel){
                busmov++;
            }
        }
        Double p;
        int tam=model.size();
        p= (busmov*1.0/tam)*100.0;
        System.out.println(p);
        return p;
    }
    private String maisRecente(ArrayList<Model> model){
        return model.get(model.size()-1).getData();
    }
    private String menosRecente(ArrayList<Model> model){
        return model.get(0).getData();
    }
    void barGraph(HBox hbox) {
        CategoryAxis x = new CategoryAxis();
        NumberAxis y = new NumberAxis();
        BarChart<String, Number> graph = new BarChart<String, Number>(x, y);
        graph.setTitle("Veículos em movimento por linha");
        x.setLabel("Linha");
        y.setLabel("Quantidade");
        ArrayList<Linhas> lista= crialinhas(model);
        XYChart.Series dados = new XYChart.Series();
        dados.setName("Movimento");
        for (int i = 0; i < lista.size(); i++) {
            dados.getData().add(new XYChart.Data(lista.get(i).getNome(), lista.get(i).getQuant()));
        }
        graph.getData().addAll(dados);
        hbox.getChildren().add(graph);
    }
    private ArrayList<Linhas> crialinhas(ArrayList<Model> model){
        ArrayList<Linhas> list = new ArrayList<>();
        for(int i=0;i<model.size();i++){
            String linha= model.get(i).getLinha();
            if((!linhaExiste(list,linha))&& (!linha.equals(""))){
                list.add(new Linhas(linha,1));
            }
            else{
                incrementaLista(list,linha);

            }
        }
        return list;
    }
    private boolean linhaExiste(ArrayList<Linhas> list,String linha){
        for(int i=0;i<list.size();i++){
            if(linha.equals(list.get(i).getNome())){
                return true;
            }
        }
        return false;
    }
    private void incrementaLista(ArrayList<Linhas> list, String linha){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getNome().equals(linha)){
                list.get(i).incrementa();
            }
        }
    }
}

