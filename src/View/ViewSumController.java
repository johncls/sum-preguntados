/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Models.SumModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author jonce
 */
public class ViewSumController implements Initializable {

    @FXML
    private TextField txtOne;
    @FXML
    private TextField txtTwo;
    @FXML
    private TextField txtResult;
    @FXML
    private Button btnSum;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Sum(ActionEvent event) {
        try{
            int op1 = Integer.parseInt(this.txtOne.getText());
            int op2 = Integer.parseInt(this.txtTwo.getText());
            
            SumModel sum = new SumModel(op1,op2);
            
            int result = sum.suma();
            this.txtResult.setText(result + "");
        }catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }
            
        
    }
    
}
