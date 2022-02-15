package principal;

import principal.entities.Libro;
import principal.services.LibroServicio;

public class Main {

    public static void main(String[] args) {
        Menu m = new Menu();
        try {
            m.ejecutar();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

}
