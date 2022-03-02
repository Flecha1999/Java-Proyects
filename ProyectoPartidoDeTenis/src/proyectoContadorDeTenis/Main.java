package proyectoContadorDeTenis;

import proyectoContadorDeTenis.entidades.Jugador;
import proyectoContadorDeTenis.servicios.JuegoServicio;
import proyectoContadorDeTenis.servicios.JugadoresServicio;
import proyectoContadorDeTenis.servicios.SetServicio;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Jugador jugadorUno = new Jugador();
        Jugador jugadorDos = new Jugador();
        JuegoServicio juegoServicio = new JuegoServicio();
        SetServicio setServicio = new SetServicio();
        String torneo = null;
        String nombreJugador1;
        String nombreJugador2;
        JugadoresServicio jugadores = new JugadoresServicio();
        int probabilidadJugador2;
        int probabilidadJugador1;
        float cantidadDeSets = 0;
        System.out.println("comenzamos");
        String bandera = "S";
        
        while (bandera.equalsIgnoreCase("s")) {
            System.out.println("Ingrese el nombre del jugador 1");
            nombreJugador1 = leer.next();
            jugadorUno.setNombre(nombreJugador1);
            System.out.println("Ingrese el nombre del jugador 2");
            nombreJugador2 = leer.next();
            jugadorDos.setNombre(nombreJugador2);
            System.out.println("Que probabilidad tiene de ganar el jugador 1?");
            probabilidadJugador1 = leer.nextInt();
            jugadorUno.setProbabilidaDeGanar(probabilidadJugador1);
            System.out.println("Que probabilidad tiene de ganar el jugador 2?");
            probabilidadJugador2 = leer.nextInt();
            jugadorDos.setProbabilidaDeGanar(probabilidadJugador2);
            System.out.println("A cuantos sets desea que se juegue?");
            cantidadDeSets = leer.nextInt();
            System.out.println("Por ultimo, indique que torneo es");
            torneo = leer.next();
            setServicio.jugarSet(cantidadDeSets, jugadorUno, jugadorDos);
            juegoServicio.jugarJuego(jugadorUno, jugadorDos);
            System.out.println("Se ha jugado el torneo " + torneo);
            System.out.println("jugamos otra vez?, presionar 's' si asi lo desea");
            bandera = leer.next();
        }
    }
}
//Consultas de sql

//• Todos los productos del rubro "libreria", creados hoy.

//SELECT * FROM productos p, rubro r
//WHERE p.codigo = r.id_rubro 
//GROUP BY p.nombre
//HAVING p.fecha_creacion = GETDATE() AND r.rubro = "libreria";

//• Monto total vendido por cliente (mostrar nombre del cliente y monto).
//SELECT c.nombre, SUM(v.cantidad) FROM cliente c, venta v 
//WHERE c.id_cliente = v.id_venta ;


//• Cantidad de ventas por producto.
//SELECT p.nombre, count(v.cantidad) FROM venta v, producto p
//WHERE v.id_venta = p.codigo;

//• Cantidad de productos comprados por cliente en el mes actual.
//SELECT count(*), c.nombre FROM producto p, cliente c
//WHERE p.fecha_creacion = c.id_cliente
//GROUP BY p.nombre
//HAVING p.fecha_creacion = MONTH();

//• Ventas que tienen al menos un producto del rubro "bazar".
//SELECT * FROM venta v, producto p, rubro r
//


//• Rubros que no tienen ventas en los ultimos 2 meses.
