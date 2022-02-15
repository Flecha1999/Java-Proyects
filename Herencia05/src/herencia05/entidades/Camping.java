
package herencia05.entidades;

public class Camping extends Alojamiento {

    protected Integer capacidadMaximaCarpas;
    protected Integer cantidadBanios;
    protected Boolean Restaurante;

    public Camping() {
    }

    public Camping(Integer capacidadMaximaCarpas, Integer cantidadBanios, Boolean Restaurante, String nombre, String direccion, String localidad, String gerenteEncargado) {
        super(nombre, direccion, localidad, gerenteEncargado);
        this.capacidadMaximaCarpas = capacidadMaximaCarpas;
        this.cantidadBanios = cantidadBanios;
        this.Restaurante = Restaurante;
    }

    public Integer getCapacidadMaximaCarpas() {
        return capacidadMaximaCarpas;
    }

    public void setCapacidadMaximaCarpas(Integer capacidadMaximaCarpas) {
        this.capacidadMaximaCarpas = capacidadMaximaCarpas;
    }

    public Integer getCantidadBanios() {
        return cantidadBanios;
    }

    public void setCantidadBanios(Integer cantidadBanios) {
        this.cantidadBanios = cantidadBanios;
    }

    public Boolean getRestaurante() {
        return Restaurante;
    }

    public void setRestaurante(Boolean Restaurante) {
        this.Restaurante = Restaurante;
    }

    @Override
    public String toString() {
        return "Camping{" + "capacidadMaximaCarpas=" + capacidadMaximaCarpas + ", cantidadBanios=" + cantidadBanios + ", Restaurante=" + Restaurante + '}';
    }
    
}
