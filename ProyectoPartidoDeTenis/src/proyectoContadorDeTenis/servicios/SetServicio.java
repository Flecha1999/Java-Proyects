package proyectoContadorDeTenis.servicios;

import proyectoContadorDeTenis.entidades.Jugador;

public class SetServicio {
    
        public void jugarSet(float sets, Jugador jugadorUno, Jugador jugadorDos) {

        int juegosJug1 = 0;
        int juegosJug2 = 0;
        int setJug1 = 0;
        int setJug2 = 0;
        float set1 = (sets / 2);
        double set = set1 + 0.5;
        boolean finPartido = false;
        JuegoServicio juegoServicio = new JuegoServicio();

        while (!finPartido) {
            boolean resultadoJuego = juegoServicio.jugarJuego(jugadorUno, jugadorDos);
            if (resultadoJuego) {
                juegosJug1 = juegosJug1 + 1;
            } else {
                juegosJug2 = juegosJug2 + 1;
            }

            if (juegosJug1 == 6 && juegosJug2 == 6) {
                System.out.println("Tie Break");
            }

            //si el jugador uno tiene 6 o mas juegos ganados(games) y a su vez la diferencia con el jugador dos es 
            //de dos juego de ventaja o en caso de ir a tiebreak y que el jugador llegue primero a 7, gana el set.
            if (juegosJug1 >= 6 && (Math.abs(juegosJug1 - juegosJug2) > 1) || juegosJug1 == 7 && juegosJug2 == 6) {
                setJug1 = setJug1 + 1;
                System.out.println(jugadorUno.getNombre() + " gana el set por " + juegosJug1 + " a " + juegosJug2 );
                System.out.println();
                juegosJug1 = 0;
                juegosJug2 = 0;
                if (setJug1 == set && setJug1 > setJug2) {
                    System.out.println(jugadorUno.getNombre() + " gana el partido por " + setJug1 + " sets a " + setJug2);
                    finPartido = true;
                }
            }
            //al igual que en la funcion anterior haremos lo mismo para el jugador numero dos
            if (juegosJug2 >= 6 && (Math.abs(juegosJug2 - juegosJug1) > 1) || juegosJug2 == 7 && juegosJug1 == 6) {
                setJug2 = setJug2 + 1;
                System.out.println(jugadorDos.getNombre() + " gana el set por " + juegosJug2 + " a " + juegosJug1);
                System.out.println();
                juegosJug1 = 0;
                juegosJug2 = 0;
                if (setJug2 == set && setJug2 > setJug1) {
                    System.out.println(jugadorDos.getNombre() + " gana el partido por " + setJug2 + " sets a " + setJug1);
                    finPartido = true;
                }
            }
        }
    }
}
//para finalizar queria comentar un poco el proyecto. tiene algunos errores que no he podido corregir como muestra
//en consola que siempre el jugador que primero se ingresa gana el set 6 a 0. No logro encontrar la solucion a eso.
//  Cabe aclarar tambien que he buscado mucho en la web y he leido sobre el problema e intente hacerlo de la mejor
//manera posible, corrigiendo errores y demás.