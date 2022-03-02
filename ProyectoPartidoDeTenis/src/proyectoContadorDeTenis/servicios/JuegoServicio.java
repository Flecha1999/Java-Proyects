package proyectoContadorDeTenis.servicios;

import java.util.Objects;
import java.util.Random;
import proyectoContadorDeTenis.entidades.Jugador;

public class JuegoServicio {

    public boolean jugarJuego(Jugador jugadorUno, Jugador jugadorDos) {

        Random rnd = new Random();
        Integer marcadorJug1 = 0;
        Integer marcadorJug2 = 0;
        String puntosJug1 = "0";
        String puntosJug2 = "0";
        Boolean ganador = true;
        Boolean finJuego = false;

        //mientras este boolean de false se va a seguir ejecutando la funcion hasta que
        //un jugador llegue a cuatro puntos y se setee este boolean a true.
        while (finJuego != true) {

            //generamos numeros aleatorios entre 0 y 1, si el numero es 0 suma punto el jugador numero 1
            //en caso contrario suma el jugador numero dos
            int randomGolpe = rnd.nextInt(2);
            //generamos un string que vamos a setear dependiendo la cantidad de puntos del jugador
            String marcadorPuntos = "";

            if (randomGolpe == 0) {
                //contador para los puntos de jugador uno
                marcadorJug1 = marcadorJug1 + 1;

                //mientras la cantidad de puntos del jugador uno sea mayor a tres y la diferencia de puntos
                //entre jugador uno y jugador dos sea mayor a uno(deuce) se van a setear
                // a true.
                if ((marcadorJug1 > 3) && (Math.abs(marcadorJug1 - marcadorJug2) > 1)) {
                    System.out.println();
                    System.out.println(jugadorUno.getNombre() + " gana el juego, a continuacion sirve el jugador " + jugadorDos.getNombre());
                    System.out.println();
                    marcadorJug1 = 0;
                    marcadorJug2 = 0;
                    ganador = true;
                    finJuego = true;
                }
            }
            //al igual qu en el metodo del jugador hacemos con el metodo del jugador dos solamente que esta funcion 
            //va a iniciar cuando el numero generado aleatorialmente sea igual a 1.
            if (randomGolpe == 1) {
                marcadorJug2 = marcadorJug2 + 1;
                if ((marcadorJug2 > 3) && (Math.abs(marcadorJug2 - marcadorJug1) > 1)) {
                    System.out.println();
                    System.out.println(jugadorDos.getNombre() + " gana el game, a continuaion sirve el jugador " + jugadorUno.getNombre());
                    System.out.println();
                    marcadorJug1 = 0;
                    marcadorJug2 = 0;
                    ganador = true;
                    finJuego = true;
                }
            }

            //en este bloque de if seteamos el String dependiendo la cantidad de puntos que tenga cada jugador
            if (marcadorJug1 == 1) {
                puntosJug1 = "15";
                marcadorPuntos = puntosJug1 + " - " + puntosJug2;
            }
            if (marcadorJug1 == 2) {
                puntosJug1 = "30";
                marcadorPuntos = puntosJug1 + " - " + puntosJug2;
            }
            if (marcadorJug1 == 3) {
                puntosJug1 = "40";
                marcadorPuntos = puntosJug1 + " - " + puntosJug2;
            }
            if (marcadorJug2 == 1) {
                puntosJug2 = "15";
                marcadorPuntos = puntosJug1 + " - " + puntosJug2;
            }
            if (marcadorJug2 == 2) {
                puntosJug2 = "30";
                marcadorPuntos = puntosJug1 + " - " + puntosJug2;
            }
            if (marcadorJug2 == 3) {
                puntosJug2 = "40";
                marcadorPuntos = puntosJug1 + " - " + puntosJug2;
            }
            if (marcadorJug1 > 3 && marcadorJug2 > 3 && Objects.equals(marcadorJug1, marcadorJug2)) {
                marcadorPuntos = "deuce";
            }
            if (marcadorJug1 > 3 && marcadorJug1 > marcadorJug2) {
                puntosJug1 = "";
                puntosJug2 = "";
                marcadorPuntos = "ventaja " + jugadorUno.getNombre();
            }
            if (marcadorJug2 > 3 && marcadorJug2 > marcadorJug1) {
                puntosJug1 = "";
                puntosJug2 = "";
                marcadorPuntos = "ventaja " + jugadorDos.getNombre();
            }

            //mostramos el string seteado con el resultado dependiendo de los puntos de cada jugador
            System.out.println(marcadorPuntos);
        }
        //devolvemos en la funcion el resultado cuando haya un ganador del jeugo.
        return ganador;
    }
}
