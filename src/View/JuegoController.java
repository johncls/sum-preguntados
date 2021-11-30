/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Models.GetPregunta;
import Models.Preguntas;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 * Controlador de la vista del juego
 * @author John Alexnader Pinilla Celis
 */
public class JuegoController implements Initializable {

    //Variables 
    private Random rn;
    private int aleatorio;
    private int correcta;
    private ObservableList<GetPregunta> getQuestions;
    Preguntas resultQuestions = new Preguntas();
    private ArrayList<GetPregunta> questionOne;
    private ArrayList<GetPregunta> questionTwo;
    private ArrayList<GetPregunta> questionThree;
    private Timeline task;
    private int contadorPregunta = 1;
    private DropShadow shadow, shadowRed;
    
    // create a alert
    Alert a = new Alert(AlertType.NONE);
    
    //Pasar datos entre diferentes scenes
    private JuegoTerminadoController jtController;
    private FXMLLoader ultimaVista;
    private Region root;
    private int myFlag = 0;
    @FXML
    private AnchorPane panelJuego;
    @FXML
    private Button btnComodinTiempo;
    @FXML
    private Button btnComodinPersona;
    @FXML
    private Button btnComodin50;
    @FXML
    private Button btnUno;
    @FXML
    private Button btnDos;
    @FXML
    private Button btnTres;
    @FXML
    private Button btnCuatro;
    @FXML
    private Label lblPregunta;
    @FXML
    private ProgressBar pBar;
    @FXML
    private Label lblNumeroPregunta;
    @FXML
    private BarChart<?, ?> bChart;
    @FXML
    private CategoryAxis X;
    @FXML
    private NumberAxis Y;
    @FXML
    private Label lbl100;
    @FXML
    private Label lbl500;
    @FXML
    private Label lbl1000;
    @FXML
    private Label lb2000;
    @FXML
    private Label lbl5000;
    @FXML
    private Label lbl30000;
    @FXML
    private Label lbl10000;
    @FXML
    private Label lbl15000;
    @FXML
    private Label lbl50000;
    @FXML
    private Label lbl100000;
    @FXML
    private Label lbl200000;
    @FXML
    private Label lbl500000;
    @FXML
    private Label lbl1000000;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        questionOne = new ArrayList<>();
        questionTwo = new ArrayList<>();
        questionThree = new ArrayList<>();

        //dao = new DAOPreguntaImpl();
        getQuestions = resultQuestions.getPreguntas();

        rn = new Random();

        for (int i = 0; i < getQuestions.size(); i++) {
            if (getQuestions.get(i).getDificultad() == 1) {
                questionOne.add(getQuestions.get(i));
            }
            if (getQuestions.get(i).getDificultad() == 2) {
                questionTwo.add(getQuestions.get(i));
            }
            if (getQuestions.get(i).getDificultad() == 3) {
                questionThree.add(getQuestions.get(i));
            }
        }
        System.out.println(questionOne.get(aleatorio).getCorrecta());
        aleatorio = rn.nextInt(questionOne.size());
        rellenoD1(aleatorio);

        task = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        new KeyValue(pBar.progressProperty(), 0)
                ),
                new KeyFrame(
                        Duration.seconds(20),
                        new KeyValue(pBar.progressProperty(), 1)
                )
        );

        task.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                /*AnchorPane pane = FXMLLoader.load(getClass().getResource("/vista/FXMLJuegoTerminado.fxml"));
                panelJuego.getChildren().setAll(pane);*/
                makeFadeOut();
            }
        });
        task.playFromStart();

        shadow = new DropShadow(BlurType.THREE_PASS_BOX, Color.rgb(43, 179, 252), 30.63, 0.77, 0, 0);
        shadowRed = new DropShadow(BlurType.THREE_PASS_BOX, Color.rgb(240, 20, 20), 30.63, 0.77, 0, 0);

        //Cambio de scene con tipoFXMLLoader
        //Pasar datos entre diferentes scenes
        ultimaVista = new FXMLLoader(getClass().getResource("/View/JuegoTerminado.fxml"));
        try {
            root = (Region) ultimaVista.load();
        } catch (IOException ex) {
            Logger.getLogger(JuegoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Obtengo el controlador de otro FXML
        jtController = ultimaVista.<JuegoTerminadoController>getController();
    }    

    /**
     * MEtodo encargado del salir del juego
     * @param event ActionEvent
     * @throws IOException 
     */
    @FXML
    private void salirDelJuego(ActionEvent event) throws IOException {
        task.stop();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/Inicio.fxml"));
        panelJuego.getChildren().add(pane);
    }

    /**
     * MEtodo encargado de activar el boton comidin del tiempo
     * @param event 
     */
    @FXML
    private void lanzarComodinTiempo(ActionEvent event) {
        btnComodinTiempo.setDisable(true);
        task.stop();
    }


    /**
     * Metodo encargado de ejecutar el botón 50 - 50
     * @param event 
     */
    @FXML
    private void lanzarComodin50(ActionEvent event) {
        btnComodin50.setDisable(true);
        int correcto;

        if (!questionOne.isEmpty()) {
            correcto = questionOne.get(aleatorio).getCorrecta();
        } else if (!questionTwo.isEmpty()) {
            correcto = questionTwo.get(aleatorio).getCorrecta();
        } else {
            correcto = questionThree.get(aleatorio).getCorrecta();
        }

        if (correcto == 0) {
            btnDos.setDisable(true);
            btnCuatro.setDisable(true);
        }
        if (correcto == 1) {
            btnUno.setDisable(true);
            btnCuatro.setDisable(true);
        }
        if (correcto == 2) {
            btnDos.setDisable(true);
            btnCuatro.setDisable(true);
        }
        if (correcto == 3) {
            btnUno.setDisable(true);
            btnTres.setDisable(true);
        }
    }

    /**
     * Metodo encargado de validar las respuestas
     * @param event
     * @throws IOException
     * @throws InterruptedException 
     */
    @FXML
    private void responder(ActionEvent event) throws IOException, InterruptedException {
        
        if (event.getSource() == btnUno) {
            //System.out.println((Button)e.getSource());
            if (!questionOne.isEmpty() && questionOne.get(aleatorio).getCorrecta() == 0) {
                siguientePreguntaFacil();
                task.playFromStart();
            } else if (!questionTwo.isEmpty() && questionTwo.get(aleatorio).getCorrecta() == 0 && questionOne.isEmpty()) {
                siguientePreguntaMedia();
                task.playFromStart();
            } else if (!questionThree.isEmpty() && questionThree.get(aleatorio).getCorrecta() == 0 && questionTwo.isEmpty()) {
                siguientePreguntaDificil();
                task.playFromStart();
            } else {
                task.stop();
                ResultAlert(questionOne,questionTwo,questionThree);
                myFlag = 1;

            }
        }
        
        if (event.getSource() == btnDos) {
            if (!questionOne.isEmpty() && questionOne.get(aleatorio).getCorrecta() == 1) {
                siguientePreguntaFacil();
                task.playFromStart();
            } else if (!questionTwo.isEmpty() && questionTwo.get(aleatorio).getCorrecta() == 1 && questionOne.isEmpty()) {
                siguientePreguntaMedia();
                task.playFromStart();
            } else if (!questionThree.isEmpty() && questionThree.get(aleatorio).getCorrecta() == 1 && questionTwo.isEmpty()) {
                siguientePreguntaDificil();
                task.playFromStart();
            } else {
                task.stop();
                ResultAlert(questionOne,questionTwo,questionThree);
                myFlag = 1;
            }

        }
        
        if (event.getSource() == btnTres) {
            if (!questionOne.isEmpty() && questionOne.get(aleatorio).getCorrecta() == 2) {
                siguientePreguntaFacil();
                task.playFromStart();
            } else if (!questionTwo.isEmpty() && questionTwo.get(aleatorio).getCorrecta() == 2 && questionOne.isEmpty()) {
                siguientePreguntaMedia();
                task.playFromStart();
            } else if (!questionThree.isEmpty() && questionThree.get(aleatorio).getCorrecta() == 2 && questionTwo.isEmpty()) {
                siguientePreguntaDificil();
                task.playFromStart();
            } else {
                task.stop();         
                ResultAlert(questionOne,questionTwo,questionThree);
                myFlag = 1;
            }

        }
        
        if (event.getSource() == btnCuatro) {
            if (!questionOne.isEmpty() && questionOne.get(aleatorio).getCorrecta() == 3) {
                siguientePreguntaFacil();
                task.playFromStart();
            } else if (!questionTwo.isEmpty() && questionTwo.get(aleatorio).getCorrecta() == 3 && questionOne.isEmpty()) {
                siguientePreguntaMedia();
                task.playFromStart();
            } else if (!questionThree.isEmpty() && questionThree.get(aleatorio).getCorrecta() == 3 && questionTwo.isEmpty()) {

                siguientePreguntaDificil();
                task.playFromStart();
            } else {
                
                task.stop();
                ResultAlert(questionOne,questionTwo,questionThree);
                myFlag = 1;
            }

        }

        btnUno.setDisable(false);
        btnDos.setDisable(false);
        btnTres.setDisable(false);
        btnCuatro.setDisable(false);
        contadorPregunta++;
        marcaPremio();
        lblNumeroPregunta.setText(contadorPregunta + "");
        bChart.setVisible(false);
    }

    /**
     * Metodo para rellenar las respuestas con el grado de dificulta uno
     * @param aleatorio entero 
     */
    public void rellenoD1(int aleatorio) {
        lblPregunta.setText(questionOne.get(aleatorio).getPregunta());
        btnUno.setText(questionOne.get(aleatorio).getRespuestas()[0]);
        btnDos.setText(questionOne.get(aleatorio).getRespuestas()[1]);
        btnTres.setText(questionOne.get(aleatorio).getRespuestas()[2]);
        btnCuatro.setText(questionOne.get(aleatorio).getRespuestas()[3]);
    }
    
    /**
     *Metodo para rellenar las respuestas con el grado de dificulta dos 
     * @param aleatorio 
     */
    public void rellenoD2(int aleatorio) {
        lblPregunta.setText(questionTwo.get(aleatorio).getPregunta());
        btnUno.setText(questionTwo.get(aleatorio).getRespuestas()[0]);
        btnDos.setText(questionTwo.get(aleatorio).getRespuestas()[1]);
        btnTres.setText(questionTwo.get(aleatorio).getRespuestas()[2]);
        btnCuatro.setText(questionTwo.get(aleatorio).getRespuestas()[3]);
    }

    /**
     * Metodo para rellenar las respuestas con el grado de dificulta tres
     * @param aleatorio 
     */
    public void rellenoD3(int aleatorio) {
        lblPregunta.setText(questionThree.get(aleatorio).getPregunta());
        btnUno.setText(questionThree.get(aleatorio).getRespuestas()[0]);
        btnDos.setText(questionThree.get(aleatorio).getRespuestas()[1]);
        btnTres.setText(questionThree.get(aleatorio).getRespuestas()[2]);
        btnCuatro.setText(questionThree.get(aleatorio).getRespuestas()[3]);
    }
    
    /**
     * MEtodo encargado de hacer una transicion entre una escena a otra
     */
    private void makeFadeOut() {
        FadeTransition fTransition = new FadeTransition();
        fTransition.setDuration((Duration.millis(1000)));
        fTransition.setNode(panelJuego);
        fTransition.setFromValue(1);
        fTransition.setToValue(0);

        fTransition.setOnFinished((ActionEvent event) -> {
            try {
                ultimaEscena();
            } catch (IOException ex) {
                Logger.getLogger(JuegoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        fTransition.play();
    }
    
    /**
     * Metodo encargado de cambiar de escena, en los otros solo se cambia el contenido.
     * @throws IOException 
     */
    private void ultimaEscena() throws IOException {

        Scene newScene = new Scene(root);

        Stage curStage = (Stage) panelJuego.getScene().getWindow();

        curStage.setScene(newScene);
    }
    
    /**
     * Metodo que esvalua y asigna la siguiente pregunta
     */
    public void siguientePreguntaFacil() {
        questionOne.remove(aleatorio);
        if (questionOne.size() == 0) {
            aleatorio = rn.nextInt(questionTwo.size());
            rellenoD2(aleatorio);
        } else {
            aleatorio = rn.nextInt(questionOne.size());
            System.out.println(questionOne.get(aleatorio).getCorrecta());
            rellenoD1(aleatorio);

        }
    }
    
    /**
     * Metodo que esvalua y asigna la siguiente pregunta
     */
    public void siguientePreguntaMedia() {
        questionTwo.remove(aleatorio);
        if (questionTwo.isEmpty()) {
            aleatorio = rn.nextInt(questionThree.size());
            rellenoD3(aleatorio);
        } else {
            aleatorio = rn.nextInt(questionTwo.size());
            rellenoD2(aleatorio);
        }

    }
    
    /**
     * Metodo que asigna llaa siguiente pregunta con grado de complejidad mayor
     * @throws InterruptedException
     * @throws IOException 
     */
    public void siguientePreguntaDificil() throws InterruptedException, IOException {
        questionThree.remove(aleatorio);
        if (questionThree.isEmpty()) {
            task.stop();
            lbl1000000.setEffect(shadowRed);
            jtController.setTitulo(lbl1000000.getText());

            makeFadeOut();
        } else {
            aleatorio = rn.nextInt(questionThree.size());
            rellenoD3(aleatorio);
        }
    }
    
    /**
     * Metodo para marcar los premios e ir contando las repuestas correctas
     */
    public void marcaPremio() {
            if (myFlag == 1) {
                        if (contadorPregunta < 1) {
                            jtController.setTitulo("3 Doritos");
                        } else if (contadorPregunta >= 6 && contadorPregunta < 11) {
                            jtController.setTitulo(lbl5000.getText() + " Te Ganate el Paquete completo");
                        } else if (contadorPregunta >= 11) {
                            jtController.setTitulo(lbl100000.getText() + " Te Ganaste el combo");
                        }
                        makeFadeOut();
            } else {
            switch (contadorPregunta) {
                case 1:
                    lbl100.setEffect(shadow);
                    //Pasar datos entre diferentes scenes
                    jtController.setTitulo(lbl100.getText());
                    break;
                case 2:
                    lbl100.setEffect(shadow);
                    //Pasar datos entre diferentes scenes
                    jtController.setTitulo(lbl500.getText());
                    break;
                case 3:
                    lbl500.setEffect(shadow);
                    jtController.setTitulo(lbl1000.getText());
                    break;
                case 4:
                    lbl1000.setEffect(shadow);
                    jtController.setTitulo(lb2000.getText());
                    break;
                case 5:
                    lb2000.setEffect(shadow);
                    jtController.setTitulo(lbl5000.getText());
                    break;
                case 6:
                    lbl5000.setEffect(shadowRed);
                    jtController.setTitulo(lbl10000.getText());
                    break;
                case 7:
                    lbl10000.setEffect(shadow);
                    jtController.setTitulo(lbl15000.getText());
                    break;
                case 8:
                    lbl15000.setEffect(shadow);
                    jtController.setTitulo(lbl30000.getText());
                    break;
                case 9:
                    lbl30000.setEffect(shadow);
                    jtController.setTitulo(lbl50000.getText());
                    break;
                case 10:
                    lbl50000.setEffect(shadow);
                    jtController.setTitulo(lbl100000.getText());
                    break;
                case 11:
                    lbl100000.setEffect(shadowRed);
                    jtController.setTitulo(lbl200000.getText());
                    break;
                case 12:
                    lbl200000.setEffect(shadow);
                    jtController.setTitulo(lbl500000.getText());
                    break;

                case 13:
                    lbl500000.setEffect(shadow);
                    jtController.setTitulo(lbl1000000.getText());
                    break;
            }
        }
    }
    
    /**
     * Metodo para traer las pesuesta verdadera 
     * @param questionOne Array pregunas nivel uno
     * @param questionTwo Array pregunas nivel dos
     * @param questionThree Array pregunas nivel tres
     */
    public void ResultAlert(ArrayList<GetPregunta> questionOne, ArrayList<GetPregunta> questionTwo, ArrayList<GetPregunta> questionThree)
    {
        int resultOk = 0;
        if (!questionOne.isEmpty()) {
            resultOk = questionOne.get(aleatorio).getCorrecta();
       } else if (!questionTwo.isEmpty()) {
            resultOk = questionTwo.get(aleatorio).getCorrecta();
        } else {
            resultOk = questionThree.get(aleatorio).getCorrecta();
        }
        a.setAlertType(AlertType.CONFIRMATION);
        a.setTitle("Fallaste :(");
        a.setHeaderText("Aqui Estamos para enseñarte");       
        if (resultOk == 0) {
            a.setContentText("La primera respuesta era la correcta: "+btnUno.getText());
        }
        if (resultOk == 1) {
            a.setContentText("La segunda respuesta era la correcta: "+btnDos.getText());
        }
        if (resultOk == 2) {
            a.setContentText("La tercera respuesta era la correcta: "+btnTres.getText());
        }
        if (resultOk == 3) {
            a.setContentText("La cuarta respuesta era la correcta: "+btnCuatro.getText()); 
        }
        a.show();
    }

    /**
     * Metodo encargado de ejecutarse cuando se da click en el boton porcentaje
     * @param event 
     */
    @FXML
    private void lanzarPorcentaje(ActionEvent event) {
        btnComodinPersona.setDisable(true);
        bChart.setVisible(true);
        int correcto;
        Random rn = new Random();
        int porcentaje1 = rn.nextInt(40) + 40;
        int porcentaje2 = 80 - porcentaje1;
        int porcentaje3 = 90 - (porcentaje1 + porcentaje2);
        int porcentaje4 = 100 - (porcentaje1 + porcentaje2 + porcentaje3);

        int[] porcentajes = {porcentaje1, porcentaje2, porcentaje3, porcentaje4};

        XYChart.Series set1 = new XYChart.Series();

        if (!questionOne.isEmpty()) {
            correcto = questionOne.get(aleatorio).getCorrecta();
        } else if (!questionTwo.isEmpty()) {
            correcto = questionTwo.get(aleatorio).getCorrecta();
        } else {
            correcto = questionThree.get(aleatorio).getCorrecta();
        }

        if (correcto == 0) {
            set1.getData().add(new XYChart.Data("a)", porcentajes[0]));
            set1.getData().add(new XYChart.Data("b)", porcentajes[1]));
            set1.getData().add(new XYChart.Data("c)", porcentajes[3]));
            set1.getData().add(new XYChart.Data("d)", porcentajes[2]));
        }
        if (correcto == 1) {
            set1.getData().add(new XYChart.Data("a)", porcentajes[1]));
            set1.getData().add(new XYChart.Data("b)", porcentajes[0]));
            set1.getData().add(new XYChart.Data("c)", porcentajes[3]));
            set1.getData().add(new XYChart.Data("d)", porcentajes[2]));
        }
        if (correcto == 2) {
            set1.getData().add(new XYChart.Data("a)", porcentajes[3]));
            set1.getData().add(new XYChart.Data("b)", porcentajes[1]));
            set1.getData().add(new XYChart.Data("c)", porcentajes[0]));
            set1.getData().add(new XYChart.Data("d)", porcentajes[2]));
        }
        if (correcto == 3) {
            set1.getData().add(new XYChart.Data("a)", porcentajes[2]));
            set1.getData().add(new XYChart.Data("b)", porcentajes[1]));
            set1.getData().add(new XYChart.Data("c)", porcentajes[3]));
            set1.getData().add(new XYChart.Data("d)", porcentajes[0]));
        }

        bChart.getData().addAll(set1);
    }
}
