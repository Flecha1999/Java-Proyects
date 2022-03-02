package proyectoContadorDeTenis.servicios;

import proyectoContadorDeTenis.entidades.Jugador;

public class JugadoresServicio {

    String jugador1;
    String jugador2;
    public void jugadoresPorParametro(Jugador jugador1, Jugador jugador2){
        
    }
    public void Jugadores(String jugador1, String jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public JugadoresServicio() {
    }

    public String getJugador1() {
        return jugador1;
    }

    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }

    @Override
    public String toString() {
        return "Jugadores{" + "jugador1=" + jugador1 + ", jugador2=" + jugador2 + '}';
    }

}
