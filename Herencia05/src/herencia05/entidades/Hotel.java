
package herencia05.entidades;

public class Hotel extends Alojamiento {
    protected Integer cantidadDeHabitaciones;
    protected Integer cantidadDeCamas;
    protected Integer cantidadDePisos;
    protected Double precioHabitaciones;

    public Hotel() {
    }

    public Hotel(Integer cantidadDeHabitaciones, Integer cantidadDeCamas, Integer cantidadDePisos, Double precioHabitaciones, String nombre, String direccion, String localidad, String gerenteEncargado) {
        super(nombre, direccion, localidad, gerenteEncargado);
        this.cantidadDeHabitaciones = cantidadDeHabitaciones;
        this.cantidadDeCamas = cantidadDeCamas;
        this.cantidadDePisos = cantidadDePisos;
        this.precioHabitaciones = precioHabitaciones;
    }

    public Integer getCantidadDeHabitaciones() {
        return cantidadDeHabitaciones;
    }

    public void setCantidadDeHabitaciones(Integer cantidadDeHabitaciones) {
        this.cantidadDeHabitaciones = cantidadDeHabitaciones;
    }

    public Integer getCantidadDeCamas() {
        return cantidadDeCamas;
    }

    public void setCantidadDeCamas(Integer cantidadDeCamas) {
        this.cantidadDeCamas = cantidadDeCamas;
    }

    public Integer getCantidadDePisos() {
        return cantidadDePisos;
    }

    public void setCantidadDePisos(Integer cantidadDePisos) {
        this.cantidadDePisos = cantidadDePisos;
    }

    public Double getPrecioHabitaciones() {
        return precioHabitaciones;
    }

    public void setPrecioHabitaciones(Double precioHabitaciones) {
        this.precioHabitaciones = precioHabitaciones;
    }

    @Override
    public String toString() {
        return "Hoteles{" + "cantidadDeHabitaciones=" + cantidadDeHabitaciones + ", cantidadDeCamas=" + cantidadDeCamas + ", cantidadDePisos=" + cantidadDePisos + ", precioHabitaciones=" + precioHabitaciones + '}';
    }
}
