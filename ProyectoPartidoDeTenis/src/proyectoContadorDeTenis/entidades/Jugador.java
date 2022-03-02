package proyectoContadorDeTenis.entidades;

public class Jugador {
    private String nombre;
    private Integer probabilidaDeGanar;

    public Jugador() {
    }

    public Jugador(String nombre, Integer probabilidaDeGanar) {
        this.nombre = nombre;
        this.probabilidaDeGanar = probabilidaDeGanar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getProbabilidaDeGanar() {
        return probabilidaDeGanar;
    }

    public void setProbabilidaDeGanar(Integer probabilidaDeGanar) {
        this.probabilidaDeGanar = probabilidaDeGanar;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", probabilidaDeGanar=" + probabilidaDeGanar + '}';
    }
    
}
