/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package invoker;

import command.command;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.*;
import javafx.application.*;
import receiver.java.model.MoteurEditionImplementation;
import command.*;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author 17012776
 */
public class Notepad extends Application {

    client client = new client();

    MoteurEditionImplementation mei = new MoteurEditionImplementation();
    public command collerC;

    @Override
   // public void start(Stage stage) throws Exception {
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root,800,600);
        
        stage.setScene(scene);
        stage.show();

        collerC = new coller(mei);

    }


    @FXML
    private Label label;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private TextArea textArea;

    @FXML
    public void HandleInsererButtonAction(ActionEvent event){
        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                client.list.get("inserer_texte");
            }
        });
    }
    @FXML
    public void HandleCollerButtonAction(ActionEvent event){
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                collerC.execute();
                textArea.setText(mei.buf.zone_texte.toString());
            }
        });
    }
    @FXML
    public void HandleCopierButtonAction(ActionEvent event){
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                client.list.get("copier");
            }
        });
    }
    @FXML
    public void HandleCouperButtonAction(ActionEvent event){
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                client.list.get("couper");
            }
        });
    }

    @FXML
    public void HandleSupprimerButtonAction(ActionEvent event){
        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                client.list.get("supprimer");
            }
        });
    }




    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
