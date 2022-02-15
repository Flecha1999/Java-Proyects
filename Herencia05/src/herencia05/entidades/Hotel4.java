
package herencia05.entidades;

public class Hotel4 extends Hotel{

    protected String gimnasio; //pueden ser a o b
    protected String nombreRestaurante;
    protected Integer CapacidadRestaurante;

    public Hotel4() {
    }

    public Hotel4(String gimnasio, String nombreRestaurante, Integer CapacidadRestaurante, Integer cantidadDeHabitaciones, Integer cantidadDeCamas, Integer cantidadDePisos, Double precioHabitaciones, String nombre, String direccion, String localidad, String gerenteEncargado) {
        super(cantidadDeHabitaciones, cantidadDeCamas, cantidadDePisos, precioHabitaciones, nombre, direccion, localidad, gerenteEncargado);
        this.gimnasio = gimnasio;
        this.nombreRestaurante = nombreRestaurante;
        this.CapacidadRestaurante = CapacidadRestaurante;
    }

    public String getGimnasio() {
        return gimnasio;
    }

    public void setGimnasio(String gimnasio) {
        this.gimnasio = gimnasio;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public Integer getCapacidadRestaurante() {
        return CapacidadRestaurante;
    }

    public void setCapacidadRestaurante(Integer CapacidadRestaurante) {
        this.CapacidadRestaurante = CapacidadRestaurante;
    }

    @Override
    public String toString() {
        return "Hotel4{" + "gimnasio=" + gimnasio + ", nombreRestaurante=" + nombreRestaurante + ", CapacidadRestaurante=" + CapacidadRestaurante + '}';
    }
    
}
