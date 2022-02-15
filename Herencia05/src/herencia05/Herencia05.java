package herencia05;

import herencia05.entidades.Alojamiento;
import herencia05.entidades.Camping;
import herencia05.entidades.Hotel;
import java.util.ArrayList;

public class Herencia05 {

    public static void main(String[] args) {
//• todos los alojamientos.
//• todos los hoteles.
//• todos los campings con restaurante
//• todos las residencias que tienen descuento.

        ArrayList<Alojamiento> listadoDeAlojamientos = new ArrayList();
        ArrayList<Hotel> listadoDeHoteles = new ArrayList();
        
        
        
        

//listado de alojamientos.
        for (Alojamiento aux : listadoDeAlojamientos) {
            System.out.println(aux.getNombre());
        }

//listado de hoteles y sus precios
        for (Hotel aux : listadoDeHoteles) {
            System.out.println("Hotel: " + aux.getNombre() + " precio de habitacion: " + aux.getPrecioHabitaciones());
        }
//listado de campings con restaurante.
        for (Alojamiento aux : listadoDeAlojamientos) {
            if (aux instanceof Camping ) {
                //terminar
                if (((Camping) aux).getRestaurante()) {
                    System.out.println(aux);
                }
            }
        }
    }
}
