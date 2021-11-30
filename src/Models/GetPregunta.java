/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 *Clase que obtiene las preguntas y su respectivo nivel de dificultad
 * @author John alexander pinilla celis
 */
public class GetPregunta {
    
    public String pregunta;
    private final String[] respuestas;
    private final int correcta;
    private final int dificultad;

    /**
     * Constructor de la clase
     * @param pregunta string con las preguntas a obtener
     * @param respuestas array con las respuestas a obtener 
     * @param correcta entero que validad si la respuesta es correcta 
     * @param dificultad  entero que obteine la dificultad de la pregunta
     */
    public GetPregunta(String pregunta, String[] respuestas, int correcta, int dificultad) {
        this.pregunta = pregunta;
        this.respuestas = respuestas;
        this.correcta = correcta;
        this.dificultad = dificultad;
    }

    /**
     * Metodo que retorna la pregunta 
     * @return  pregunta
     */
    public String getPregunta() {
        return pregunta;
    }

    /**
     * Metodo que envia la pregunta 
     * @param pregunta 
     */
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    /***
     * Metodo que retorna la dificultad
     * @return 
     */
    public int getDificultad() {
        return dificultad;
    }

    /**
     * Metodo que se encarga de obtener la respuesta correcta
     * @return  respuesta correcta
     */
    public int getCorrecta() {
        return correcta;
    }

    /***
     * Metodo que se encarga de obtener las respuestas
     * @return respuestas
     */
    public String[] getRespuestas() {
        return respuestas;
    }
    
    /**
     * Metodo que llama al objecto y lo representa en un valor de texto
     * @return pregutnas 
     */
    @Override
    public String toString() {
        return pregunta;
    }

    /**
     * Metodo que se encarga de la validacion de la pregunta
     * @param obj Objecto con la respuesta 
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GetPregunta other = (GetPregunta) obj;
        if (!Objects.equals(this.pregunta, other.pregunta)) {
            return false;
        }
        return true;
    } 
    
}
