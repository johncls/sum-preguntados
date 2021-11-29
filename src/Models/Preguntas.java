/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author 
 * john Alexander Pinilla Celis
 */
public class Preguntas {
    
    public static ObservableList<GetPregunta> preguntas;
    
    public Preguntas(){
        
        preguntas = FXCollections.observableArrayList();
        
        String [] respuestaUNO = {"a) 60 minutos ", " b) 120 minutos", " c) 180 minutos" , " d) 30 minutos"};
        preguntas.add(new GetPregunta("Cuantos minutos tiene una hora:", respuestaUNO, 0, 1));
        
        String [] respuestaDOS = {"a) 2 meses", "b) 3 meses", "c) 1 dia" , "d) 1 mes"};
        preguntas.add(new GetPregunta("Cuantos Meses Tienen 28 días", respuestaDOS, 3, 1));
        
        String [] respuestaCUATRO   = {"a) Pluton", "b) Tierra" , "c) Mercurio", "d) Jupiter"};
        preguntas.add(new GetPregunta("Que planeta es mas cercano al sol", respuestaCUATRO, 2, 1));
        
        String [] respuestaCINCO = {"a) Colombia", "b) China", "c) Argentina" , "d) España"};
        preguntas.add(new GetPregunta("Cual es el pais con mayor poblaciòn en el mundo:", respuestaCINCO, 1, 1));
        
        String [] respuestaSEIS = {"a) 100 kilos", "b) 1000 libras", "c) 1000 Kilos" , "d) Ninguna "};
        preguntas.add(new GetPregunta("¿Cuantos Kilos son una tonelada?", respuestaSEIS, 2, 1));
        
        String [] respuestaTRES = {"a) Caracas", "b) Bogota", "c) Montevideo" , "d) Buenos Aires"};
        preguntas.add(new GetPregunta("Cual es la capital de colombia:", respuestaTRES, 1, 2));
        
        String [] respuestaSIETE = {"a) Invertebrados", "b) Animales", "c) Vertebrados" , "d) No se :("};
        preguntas.add(new GetPregunta("¿Cómo se llaman los animales que tienen un esqueleto articulado?:", respuestaSIETE, 2, 2));
        
        String [] respuestaOCHO = {"a) Pobre", "b) Rico", "c) Adinerado" , "d) Trabajador"};
        preguntas.add(new GetPregunta("¿Cual es el antónimo de rico?", respuestaOCHO, 0, 2));
        
        String [] respuestaNUEVE = {"a) 8 horas", "b) 12 horas", "c) 24 horas" , "d)  10 horas"};
        preguntas.add(new GetPregunta("¿Cuántas horas tiene un día?", respuestaNUEVE, 2, 2));
        
        String [] respuestaDIEZ = {"a) Feliz", "b) Triste", "c) Enojado" , "d) Pensativo"};
        preguntas.add(new GetPregunta("Indica un sinónimo de alegre.", respuestaDIEZ, 0, 2));
        
        String [] respuestaONCE = {"a) El resultado es 4", "b) El resultado es 7", "c) El resultado es 12" , "d) El resultado es 20"};
        preguntas.add(new GetPregunta("¿Es lo mismo multiplicar 3x4 que 4x3?", respuestaONCE, 2, 3));
        
        String [] respuestaDOCE = {"a) Rio Misisipi V", "b) Rio Sena", "c) Rio Magdalena" , "d) Rio Amazonas"};
        preguntas.add(new GetPregunta("¿Cuál es el río más largo del mundo?", respuestaDOCE, 3, 3));
        
        String [] respuestaTRECE = {"a) Asia", "b) Europa", "c) America" , "d) Centro America"};
        preguntas.add(new GetPregunta("¿En qué continente está Brasil? ", respuestaTRECE, 2, 3));
        
        String [] respuestaCATORCE = {"a) Azules", "b) Un chaleco no tiene mangas", "c) Verdes" , "d) Color del chaleco"};
        preguntas.add(new GetPregunta("¿De qué color son las mangas del chaleco rojo de mi hermano?", respuestaCATORCE, 1, 3));
        
        String [] respuestaQUINCE = {"a) Jugaron Futból", "b) Nada", "c) Una hora" , "d) Todas Las anteriores"};
        preguntas.add(new GetPregunta("¿Qué paso ayer en Madrid de 7 a 8?", respuestaQUINCE, 2, 3));
        
    }
    
    
     public String toString(){
        
          String visualizar = "";
        
        for(int i = 0; i < preguntas.size(); i++){
            
            visualizar  += preguntas.get(i) + "\n";
        }
        
        return visualizar;
        
    }

    public ObservableList<GetPregunta> getPreguntas() {
        return preguntas;
    }
    
    
    
}
