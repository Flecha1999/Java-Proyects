
package herencia05.servicios;

import herencia05.entidades.Hotel5;
import herencia05.interfaces.Hotel5Interface;
import java.util.Scanner;

public class Hotel5Servicio implements Hotel5Interface {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    @Override
    public void precioHabitacion(Hotel5 h) {
        int p;
        int vapr = 0;
        int vapg = 0;
        int vapl = (15*h.getCantidadLimosinas());
        if(h.getCapacidadRestaurante()<30){
            vapr = 10;
        }
        if(h.getCapacidadRestaurante()>=30&& h.getCapacidadRestaurante()<=50){
            vapr = 30;
        }
        if(h.getCapacidadRestaurante()>50){
            vapr = 50;
        }
        if (h.getGimnasio().equalsIgnoreCase("a")) {
            vapg = 50;
        }
        if(h.getGimnasio().equalsIgnoreCase("b")){
            vapg = 30;
        }
        p = (50 + (1*h.getCantidadDeHabitaciones())+vapr+vapg+vapl);   
      }
    
    }
