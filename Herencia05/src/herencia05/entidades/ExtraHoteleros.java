
package herencia05.entidades;

public class ExtraHoteleros extends Alojamiento {
    
    protected Boolean privadoONo;
    protected Integer cantidadDeMetros;

    public ExtraHoteleros() {
    }

    public ExtraHoteleros(Boolean privadoONo, Integer cantidadDeMetros, String nombre, String direccion, String localidad, String gerenteEncargado) {
        super(nombre, direccion, localidad, gerenteEncargado);
        this.privadoONo = privadoONo;
        this.cantidadDeMetros = cantidadDeMetros;
    }

    public Boolean getPrivadoONo() {
        return privadoONo;
    }

    public void setPrivadoONo(Boolean privadoONo) {
        this.privadoONo = privadoONo;
    }

    public Integer getCantidadDeMetros() {
        return cantidadDeMetros;
    }

    public void setCantidadDeMetros(Integer cantidadDeMetros) {
        this.cantidadDeMetros = cantidadDeMetros;
    }

    @Override
    public String toString() {
        return "ExtraHoteleros{" + "privadoONo=" + privadoONo + ", cantidadDeMetros=" + cantidadDeMetros + '}';
    }
    
    
}
