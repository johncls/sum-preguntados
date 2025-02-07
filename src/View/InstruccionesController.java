/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 * Controlador de la vista Instrucciones
 * @author John Alexander Pinilla Celis
 */
public class InstruccionesController implements Initializable {

    //Panel para las instrucciones
    @FXML
    private AnchorPane panelInstrucciones;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * Metodo encargado de redireccionar al inicio del juego
     * @param event
     * @throws IOException 
     */
    @FXML
    private void irAtras(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/Inicio.fxml"));
        panelInstrucciones.getChildren().add(pane);
    }
    
}
