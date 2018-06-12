package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {
    private Grafo grafo;
    private Vertex verticePressionado = new Vertex(0,0);
    private Pane pane;
    @Override
    public void start(Stage primaryStage) throws Exception{
        grafo= new Grafo();
        BorderPane bp = new BorderPane();
        pane = new Pane();
        pane.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                 verticePressionado = grafo.procuraVertice(e.getX(), e.getY());
            }
        });
        pane.setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                if(verticePressionado !=null){
                    verticePressionado.setCirculoX(e.getX());
                    verticePressionado.setCirculoY(e.getY());

                }
            }
        });
        pane.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                verticePressionado = null;
                //testar arestas sobrepostas
            }
        });
        HBox hbCb = new HBox();
        VBox vb = new VBox();
        vb.setPadding(new Insets(500,10,10,10));
        ComboBox setLevel = new ComboBox();
        ComboBox dificuldade = new ComboBox();
        dificuldade.setValue("Médio");
        setLevel.setValue(1);
        vb.setSpacing(10.0);
        vb.getChildren().addAll(setLevel,dificuldade);
        vb.setStyle("-fx-background-color:#b2b2b2");
        dificuldade.getItems().addAll("Médio","Difícil");
        setLevel.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        hbCb.getChildren().add(vb);
        grafo.escolheNivel(setLevel.getValue(),dificuldade.getValue());
        bp.setLeft(hbCb);
        for (Vertex v : grafo.vertices)
            pane.getChildren().add(v.getCircle());
        for (Edge e : grafo.arestas)
            pane.getChildren().add(e.getLinha());
        bp.setCenter(pane);
        primaryStage.setTitle("Planarity");
        primaryStage.setScene(new Scene(bp, 800, 600));
        primaryStage.show();

    }



    public static void main(String[] args) {
        launch(args);
    }
}
