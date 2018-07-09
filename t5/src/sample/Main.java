package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main extends Application {

    private Grafo grafo;
    private Circle circle;
    private Line aresta;
    private Vertice inicioAresta;
    private double r;
    private double g;
    private double b;

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane bp = new BorderPane();
        grafo = new Grafo();

        HBox hbtop = new HBox();
        HBox hbbot = new HBox();
        Pane centro = new Pane();

        ArrayList<String> corV = new ArrayList<String>();
        ArrayList<String>corA = new ArrayList<String>();

        bp.setCenter(centro);

        hbtop.setPadding(new Insets(10, 10, 10, 10));
        //Botões
        Button novo = new Button();
        novo.setText("Novo Grafo");

        Button salvar = new Button();
        salvar.setText("Salvar em SVG");

        Button info = new Button();
        info.setText("Info");

        Button sair = new Button();
        sair.setText("Sair");

        hbtop.getChildren().addAll(novo,salvar,info,sair);
        hbtop.setStyle("-fx-background-color: gray");
        hbtop.setSpacing(20);

        //Labels
        Label vertares = new Label();
        vertares.setText("Vértice/Aresta:");
        Label cor = new Label();
        cor.setText("Cor:");
        Label raio = new Label();
        raio.setText("Raio:");

        //Escolher vértice e aresta
        HBox hvora = new HBox();
        ToggleGroup toggle = new ToggleGroup();
        RadioButton rVertice = new RadioButton();
        RadioButton rAresta = new RadioButton();
        rVertice.setToggleGroup(toggle);
        rVertice.setText("Vértice");
        rAresta.setToggleGroup(toggle);
        rAresta.setText("Aresta");
        rVertice.setSelected(true);
        hvora.setSpacing(10);
        hvora.getChildren().addAll(rVertice, rAresta);
        VBox vradio = new VBox();
        vradio.setSpacing(5);
        vradio.getChildren().addAll(vertares, hvora);
        vradio.setPadding(new Insets(10, 10, 10, 10));

        //Escolher o raio
        Slider slider = new Slider();
        slider.setMin(10);
        slider.setMax(40);
        slider.setValue(10);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(10);
        slider.setMinorTickCount(1);
        slider.setBlockIncrement(5);
        VBox vslider = new VBox();
        vslider.getChildren().addAll(raio, slider);
        vslider.setPadding(new Insets(10, 10, 10, 10));

        //Escolher a cor
        VBox vcolorPicker = new VBox();
        ColorPicker colorPicker = new ColorPicker(Color.BLACK);
        vcolorPicker.getChildren().addAll(cor, colorPicker);
        vcolorPicker.setPadding(new Insets(10, 10, 10, 10));

        hbbot.getChildren().addAll(vradio,vslider,vcolorPicker);
        hbbot.setStyle("-fx-background-color: gray");
        hbbot.setSpacing(20);

        bp.setTop(hbtop);
        bp.setBottom(hbbot);

        sair.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage stage = (Stage) sair.getScene().getWindow();
                stage.close();
            }
        });
        info.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert info2 = new Alert(Alert.AlertType.INFORMATION);
                info2.setTitle("Info do grafo");
                info2.setContentText("NumVértices: " + grafo.getNumVertices() + "\nArestas: " + grafo.getNumArestas()+"\nArestas Sobrepostas: "+grafo.getNumAresSob());
                info2.show();
            }
        });
        salvar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileWriter arquivo=null;
                try {
                    arquivo = new FileWriter("grafo.html");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                PrintWriter salvarArquivo = new PrintWriter(arquivo);
                for (int i=0;i<grafo.getNumVertices();i++) {
                    salvarArquivo.printf("<svg height=\"" + centro.getHeight() + "\" width=\"" + centro.getWidth() + "\"> <circle cx=\"" + grafo.getVertex().get(i).getCircle().getCenterX() + "\" cy=\"" + grafo.getVertex().get(i).getCircle().getCenterY() + "\" r=\"" + grafo.getVertex().get(i).getCircle().getRadius() + "\" stroke=\"" + grafo.getVertex().get(i).getCircle().getStroke() +"\" stroke-width=\"" + grafo.getVertex().get(i).getCircle().getStrokeWidth()+ "\"fill=\"" +corV.get(i)+"\"/> </svg>");
                }
                for(int i =0; i < grafo.getNumArestas();i++){
                    salvarArquivo.printf("<svg height=\"" + centro.getHeight() + "\" width=\"" + centro.getWidth() + "\"> <line x1=\"" + grafo.getEdges().get(i) + "\" y1=" + grafo.getEdges().get(i).getStartY() + "\" x2=\"" + grafo.getEdges().get(i).getEndX() + "\" y2=\"" + grafo.getEdges().get(i).getEndY() + "\" style=\"stroke:" + corA.get(i) + ";stroke-width:" + grafo.getEdges().get(i).getLine().getStrokeWidth() + "px\"/> </svg>");
                }
                try {
                    arquivo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        novo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                grafo = new Grafo();
                centro.getChildren().clear();
            }
        });
        centro.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (grafo != null) {
                    if (rVertice.isSelected()) {
                        circle = new Circle(e.getX(), e.getY(), slider.getValue(), colorPicker.getValue());
                        centro.getChildren().add(circle);
                    }
                }
            }
        });
        centro.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (grafo != null) {
                    if (rVertice.isSelected()) {
                        grafo.addVertex(new Vertice(circle));
                        circle = new Circle(e.getX(), e.getY(), slider.getValue(), colorPicker.getValue());
                        r = colorPicker.getValue().getRed();
                        g = colorPicker.getValue().getGreen();
                        b = colorPicker.getValue().getBlue();
                        corV.add(toRGB(r,g,b));
                        centro.getChildren().add(circle);
                    } else if (rAresta.isSelected()) {
                        Vertice fim = grafo.clickVertice(e.getX(), e.getY());
                        if (fim != null) {
                            if (inicioAresta == null) {
                                aresta = new Line(fim.getCircle().getCenterX(), fim.getCircle().getCenterY(), e.getX(), e.getY());
                                aresta.setStroke(colorPicker.getValue());
                                r = colorPicker.getValue().getRed();
                                g = colorPicker.getValue().getGreen();
                                b = colorPicker.getValue().getBlue();
                                corA.add(toRGB(r,g,b));
                                centro.getChildren().add(aresta);
                                inicioAresta = fim;
                            } else if (inicioAresta != fim) {
                                if (!grafo.arestaExiste(inicioAresta, fim)) {
                                    centro.getChildren().remove(aresta);
                                    grafo.addEdge(new Aresta(aresta, inicioAresta, fim));
                                    aresta = new Line(inicioAresta.getCircle().getCenterX(), inicioAresta.getCircle().getCenterY(), fim.getCircle().getCenterX(), fim.getCircle().getCenterY());
                                    aresta.setStroke(colorPicker.getValue());
                                    r = colorPicker.getValue().getRed();
                                    g = colorPicker.getValue().getGreen();
                                    b = colorPicker.getValue().getBlue();
                                    corA.add(toRGB(r,g,b));
                                    centro.getChildren().add(aresta);
                                    aresta = null;
                                    inicioAresta = null;
                                }
                            }
                        }
                    }
                }
            }
        });
        centro.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (grafo != null) {
                    if (rVertice.isSelected()) {
                        circle.setCenterX(e.getX());
                        circle.setCenterY(e.getY());
                    } else if (rAresta.isSelected()) {
                        if (inicioAresta != null) {
                            aresta.setEndX(e.getX());
                            aresta.setEndY(e.getY());
                        }
                    }
                }
            }
        });


        Scene scene = new Scene(bp, 600, 600);
        primaryStage.setTitle("Grafo creater");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private static String toRGB(double r, double g, double b) {
        return String.format("#%02X%02X%02X",
                (int) (r * 255),
                (int) (g * 255),
                (int) (b * 255));
    }
    public static void main(String[] args) {
        launch(args);
    }
}
