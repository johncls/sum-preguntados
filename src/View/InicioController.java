/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Models.Preguntas;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    
    //Stage
    Stage stage;
    
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
        //Creating an image 
      Image image = null;  
      
        try {
            image = new Image(new FileInputStream("src/View/Image/ninosaprendiendo.png"));
            
            //Setting the image view 
            ImageView imageView = new ImageView(image); 
            //Setting the position of the image 
            imageView.setX(50); 
            imageView.setY(25); 

            //setting the fit height and width of the image view 
            imageView.setFitHeight(455); 
            imageView.setFitWidth(500); 

            //Setting the preserve ratio of the image view 
            imageView.setPreserveRatio(true);  
            //Creating a Group object  
            Group root = new Group(imageView);  

            //Creating a scene object 
            Scene scene = new Scene(root, 600, 500);  



        } catch (FileNotFoundException ex) {
            Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
