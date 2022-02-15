
package herencia05.entidades;

public class Hotel5 extends Hotel4{
    protected Integer cantidadSalonesConferencia;
    protected Integer cantidadSuites;
    protected Integer cantidadLimosinas;

    public Hotel5() {
    }

    public Hotel5(Integer cantidadSalonesConferencia, Integer cantidadSuites, Integer cantidadLimosinas, String gimnasio, String nombreRestaurante, Integer CapacidadRestaurante, Integer cantidadDeHabitaciones, Integer cantidadDeCamas, Integer cantidadDePisos, Double precioHabitaciones, String nombre, String direccion, String localidad, String gerenteEncargado) {
        super(gimnasio, nombreRestaurante, CapacidadRestaurante, cantidadDeHabitaciones, cantidadDeCamas, cantidadDePisos, precioHabitaciones, nombre, direccion, localidad, gerenteEncargado);
        this.cantidadSalonesConferencia = cantidadSalonesConferencia;
        this.cantidadSuites = cantidadSuites;
        this.cantidadLimosinas = cantidadLimosinas;
    }

    public Integer getCantidadSalonesConferencia() {
        return cantidadSalonesConferencia;
    }

    public void setCantidadSalonesConferencia(Integer cantidadSalonesConferencia) {
        this.cantidadSalonesConferencia = cantidadSalonesConferencia;
    }

    public Integer getCantidadSuites() {
        return cantidadSuites;
    }

    public void setCantidadSuites(Integer cantidadSuites) {
        this.cantidadSuites = cantidadSuites;
    }

    public Integer getCantidadLimosinas() {
        return cantidadLimosinas;
    }

    public void setCantidadLimosinas(Integer cantidadLimosinas) {
        this.cantidadLimosinas = cantidadLimosinas;
    }

    @Override
    public String toString() {
        return "Hotel5{" + "cantidadSalonesConferencia=" + cantidadSalonesConferencia + ", cantidadSuites=" + cantidadSuites + ", cantidadLimosinas=" + cantidadLimosinas + '}';
    }
}
