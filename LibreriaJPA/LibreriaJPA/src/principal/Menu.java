package principal;

import java.util.Scanner;
import principal.services.AutorServicio;
import principal.services.EditorialServicio;
import principal.services.LibroServicio;

public class Menu {

    private final AutorServicio autorServicio;
    private final LibroServicio libroServicio;
    private final EditorialServicio editorialServicio;
    private final Scanner LEER;

    public Menu() {
        autorServicio = new AutorServicio();
        libroServicio = new LibroServicio();
        editorialServicio = new EditorialServicio();
        LEER = new Scanner(System.in).useDelimiter("\n");
    }

    public void mostrarMenu() {
        System.out.println("------------- MENU -------------"
                + "\n 1. Mostrar libros activos"
                + "\n 2. Mostrar autores activos"
                + "\n 3. Mostrar editoriales activos"
                + "\n 4. Cargar nuevo libro"
                + "\n 5. Cargar nuevo autor"
                + "\n 6. Cargar nuevo editorial"
                + "\n 7. Dar de baja libro"
                + "\n 8. Dar de baja autor"
                + "\n 9. Dar de baja editorial"
                + "\n 10. Salir");
    }

    public int pedirOpcion() {
        System.out.println("Escribí una opción para continuar");
        int opcion = LEER.nextInt();

        while (opcion < 1 || opcion > 10) {
            System.out.println("Opción no válida. Debe estar entre 1 y 10."
                    + "\nIntentá de nuevo");
            opcion = LEER.nextInt();
        }
        return opcion;
    }

    public void ejecutar() throws Exception {
        int opcion;

        do {
            mostrarMenu();
            opcion = pedirOpcion();
            switch (opcion) {
                case 1:
                    libroServicio.listarActivos().forEach(libro -> System.out.println("Titulo: " + libro.getTitulo() + " -  Autor: " + libro.getAutor().getNombre() + " - " + libro.getId()));
                    break;
                case 2:
                    autorServicio.listarActivos().forEach(autor -> System.out.println(autor.getNombre() + " - Id: " + autor.getId()));
                    break;
                case 3:
                    editorialServicio.listarActivos().forEach(editorial -> System.out.println(editorial.getNombre() + " - Id: " + editorial.getId()));
                    break;
                case 4:
                    cargarLibro();
                    break;
                case 5:
                    cargarAutor();
                    break;
                case 6:
                    cargarEditorial();
                    break;
                case 7:
                    bajaLibro();
                    break;
                case 8:
                    bajaAutor();
                    break;
                case 9:
                    bajaEditorial();
                    break;
                case 10:
                    System.out.println("Hasta luego");
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
                    opcion = pedirOpcion();
            }
        } while (opcion != 10);

    }

    private String pedirCadena() {
        return LEER.next();
    }

    private int pedirNumero() {
        return LEER.nextInt();
    }

    private Long pedirIsbn() {
        return LEER.nextLong();
    }

    private void cargarLibro() throws Exception {
        System.out.println("Escribi el título del libro a crear");
        String titulo = pedirCadena();

        System.out.println("Escribi la cantidad de ejemplares");
        int ejemplares = pedirNumero();

        System.out.println("Escribi el ISBN del Libro");
        long isbn = pedirIsbn();

        System.out.println("Escribi la editorial del libro");//CHEQUEAR FUNCIONES DE VALIDACION
        String editorial = pedirCadena();

        System.out.println("Escribi el autor del libro");//CHEQUEAR FUNCIONES DE VALIDACION
        String autor = pedirCadena();

        libroServicio.guardarLibro(titulo, ejemplares, isbn, editorial, autor);
    }

    private void cargarAutor() throws Exception {

        System.out.println("Escribi el nombre del autor");
        String nombreAutor = pedirCadena();
        autorServicio.crearAutor(nombreAutor);

    }

    private void cargarEditorial() throws Exception {
        System.out.println("Escribi el nombre de la editorial");
        String editorial = pedirCadena();

        editorialServicio.crearEditorial(editorial);
    }

    private void bajaLibro() throws Exception {
        System.out.println("Ingrese el ID del libro a dar de baja");
        String id = pedirCadena();
        libroServicio.baja(id);
    }

    private void bajaAutor() throws Exception {
        System.out.println("Ingrese el ID del autor a dar de baja");
        String id = pedirCadena();
        autorServicio.baja(id);
    }

    private void bajaEditorial() throws Exception {
        System.out.println("Ingrese el ID de la editorial a dar de baja");
        String id = pedirCadena();
        editorialServicio.baja(id);
    }

}
