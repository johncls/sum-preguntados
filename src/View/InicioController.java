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
 *
 * @author jonce
 */
public class InicioController implements Initializable {

    Preguntas resultQuestions = new Preguntas();
    
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

    @FXML
    private void salir(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void verInstrucciones(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/Instrucciones.fxml"));
        panelPrincipal.getChildren().setAll(pane);
    }

    @FXML
    private void comenzarJuego(ActionEvent event) throws IOException {
        
        //System.out.print(resultQuestions.getPreguntas());
        
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
