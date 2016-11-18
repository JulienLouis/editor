/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package invoker;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import command.*;
import receiver.java.model.MoteurEditionImplementation;

import javax.swing.*;


/**
 *
 * @author 17012776
 */
public class FXMLDocumentController implements Initializable {

    /*client client = new client();
    public command coller;



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
*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {

      //  coller = client.list.get("coller");
    }
/*
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
                JOptionPane.showMessageDialog(null,"alert");
                coller.execute();
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
*/
    
}
