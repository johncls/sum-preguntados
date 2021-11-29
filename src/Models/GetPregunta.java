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
 *
 * @author John alexander pinilla celis
 */
public class GetPregunta {
    
    public String pregunta;
    private final String[] respuestas;
    private final int correcta;
    private final int dificultad;

    public GetPregunta(String pregunta, String[] respuestas, int correcta, int dificultad) {
        this.pregunta = pregunta;
        this.respuestas = respuestas;
        this.correcta = correcta;
        this.dificultad = dificultad;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getDificultad() {
        return dificultad;
    }

    public int getCorrecta() {
        return correcta;
    }

    public String[] getRespuestas() {
        return respuestas;
    }
    
    
    @Override
    public String toString() {
        return pregunta;
    }

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
