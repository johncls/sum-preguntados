/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Models.Preguntas;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 * Controlador de la vista inicial del juego
 * @author John Alexander Pinilla Celis
 */
public class InicioController implements Initializable {

    //Intancia para obtner las preguntas
    Preguntas resultQuestions = new Preguntas();
    
    //Atributo del pantalla principal
    @FXML
    private AnchorPane panelPrincipal;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * Metodo de salir del juego
     * @param event 
     */
    @FXML
    private void salir(ActionEvent event) {
        System.exit(0);
    }

    /**
     * Metodo la redirigir a la vista ver instrucciones
     * @param event
     * @throws IOException 
     */
    @FXML
    private void verInstrucciones(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/Instrucciones.fxml"));
        panelPrincipal.getChildren().setAll(pane);
    }

    /**
     * Metodo al momento de hacer clic para comenzar el juego y redirección al juego
     * @param event
     * @throws IOException 
     */
    @FXML
    private void comenzarJuego(ActionEvent event) throws IOException {
             
        if (resultQuestions.getPreguntas().size() != 15) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al Iniciar Juego");
            alert.setContentText("Debe haber 15 preguntas para poder jugar");
            
            //Poner icono
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(this.getClass().getResource("/View/Image/iconerror.png").toString()));

            alert.showAndWait();
        } else {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/Juego.fxml"));
            panelPrincipal.getChildren().setAll(pane);
        }
       
    }
    
}
