
package herencia05.entidades;

public class Residencia extends Alojamiento{
// Para las residencias se
//indica la cantidad de habitaciones, si se hacen o no descuentos a los gremios y
//si posee o no campo deportivo. Realizar un programa en el que se representen
//todas las relaciones descriptas.
    protected Integer cantidadHabitaciones;
    protected Boolean DescuentosAGremios;
    protected Boolean CampoDeportivo;

    public Residencia() {
    }

    public Residencia(Integer cantidadHabitaciones, Boolean DescuentosAGremios, Boolean CampoDeportivo, String nombre, String direccion, String localidad, String gerenteEncargado) {
        super(nombre, direccion, localidad, gerenteEncargado);
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.DescuentosAGremios = DescuentosAGremios;
        this.CampoDeportivo = CampoDeportivo;
    }

    public Integer getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public void setCantidadHabitaciones(Integer cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    public Boolean getDescuentosAGremios() {
        return DescuentosAGremios;
    }

    public void setDescuentosAGremios(Boolean DescuentosAGremios) {
        this.DescuentosAGremios = DescuentosAGremios;
    }

    public Boolean getCampoDeportivo() {
        return CampoDeportivo;
    }

    public void setCampoDeportivo(Boolean CampoDeportivo) {
        this.CampoDeportivo = CampoDeportivo;
    }

    @Override
    public String toString() {
        return "Residencia{" + "cantidadHabitaciones=" + cantidadHabitaciones + ", DescuentosAGremios=" + DescuentosAGremios + ", CampoDeportivo=" + CampoDeportivo + '}';
    }
    
}
