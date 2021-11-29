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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author jonce
 */
public class JuegoTerminadoController implements Initializable {

    @FXML
    private AnchorPane panelFinal;
    @FXML
    private Label lblTitulo;
    @FXML
    private Label lblTitulo11;
    
    private Label lblPremio;
    @FXML
    private Label lblTitulo1;
    @FXML
    private Label lblPuntaje;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void setTitulo(String titulo) {
        lblPuntaje.setText(titulo);
    }

    @FXML
    public void volverAEmpezar() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/Inicio.fxml"));
        panelFinal.getChildren().setAll(pane);
    }
    
    
}
