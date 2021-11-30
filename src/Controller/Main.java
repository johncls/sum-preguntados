/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 *
 * @author john alexander pinilla celis 
 */
public class Main  extends Application
{
    
      
    @Override
    public void start(Stage stage) throws Exception {
        //Inicio del aplicativo
        try {
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation( Main.class.getResource("/View/Inicio.fxml"));
            Pane ventana = (Pane) loader.load();

            // Muestra la ventana 
            Scene scene = new Scene(ventana);
            stage.setTitle("¿Preguntados The Best?");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.setScene(scene);
            stage.show();

        }catch( IOException e){
            
            System.out.println(e.getMessage());
        }
        
    }

    /**
     * metodo estatico de main 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
