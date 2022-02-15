package principal.services;

import java.util.List;
import java.util.UUID;
import principal.entities.Autor;
import principal.entities.Editorial;
import principal.entities.Libro;
import principal.persistencia.LibroDAO;

public class LibroServicio {

    private final LibroDAO DAO;
    private AutorServicio autorServicio;
    private EditorialServicio editorialServicio;

    public LibroServicio() {
        DAO = new LibroDAO();
        autorServicio = new AutorServicio();
        editorialServicio = new EditorialServicio();
    }

    public Libro guardarLibro(String titulo, int ejemplares, Long isbn, String editorial, String autor) throws Exception {
        validarDatos(titulo, isbn, autor, ejemplares);

        Editorial e = editorialServicio.buscarPorNombre(editorial);
        Autor a = autorServicio.buscarPorNombre(autor);

        Libro l = new Libro();
        l.setId(UUID.randomUUID().toString());
        l.setAlta(true);
        l.setEjemplares(ejemplares);
        l.setEjemplaresRestantes(ejemplares);
        l.setEjemplaresPrestados(0);
        l.setTitulo(titulo);
        l.setIsbn(isbn);
        l.setEditorial(e);
        l.setAutor(a);

        DAO.guardarLibro(l);

        return l;

    }

    public Libro editarLibro(Libro l) {
        return DAO.actualizarLibro(l);
    }

    public Libro alta(String idLibro) throws Exception {
        Libro l = buscarPorId(idLibro);
        l.setAlta(true);
        return DAO.actualizarLibro(l);
    }

    public Libro baja(String idLibro) throws Exception {
        Libro l = buscarPorId(idLibro);

        l.setAlta(false);
        return DAO.actualizarLibro(l);
    }

    public List<Libro> listarActivos() {
        return DAO.listarActivos();
    }

    public List<Libro> listarTodos() {
        return DAO.listarTodos();
    }

    public Libro buscarPorId(String idLibro) throws Exception {
        Libro l = DAO.buscarPorId(idLibro);
        if (l == null) {
            throw new Exception("No se encontró un libro con ID " + idLibro);
        }
        return l;
    }
    
    public List<Libro> buscarPorTitulo(String titulo) throws Exception {
        List<Libro> libros = DAO.buscarPorTitulo(titulo);
        if (libros.isEmpty()) {
            throw new Exception("No se encontraron libros con el título " + titulo);
        }
        return libros;
    }
   
    public Libro buscarPorIsbn(Long isbn) throws Exception {
        Libro libro = DAO.buscarPorISBN(isbn);
        if (libro == null) {
            throw new Exception("No se encontraron libros con ISBN: " + isbn);
        }
        return libro;
    }
    
    public List<Libro> buscarPorAutor(String nombre) throws Exception {
        Autor a = autorServicio.buscarPorNombre(nombre);
        return DAO.buscarPorAutor(a.getId());
    }

    public List<Libro> buscarPorEditorial(String editorial) throws Exception {
        Editorial e = editorialServicio.buscarPorNombre(editorial);
        return DAO.buscarPorEditorial(e.getId());
    }

    public void eliminarLibro(String id) throws Exception {
        Libro l = DAO.buscarPorId(id);
        if (l == null) {
            throw new Exception("No se encontró un libro con ID " + id);
        }
        DAO.eliminarLibro(l);
    }

    public void eliminarPorEditorial(String idEditorial) throws Exception {
        List<Libro> libros = DAO.buscarPorEditorial(idEditorial);
        if (libros.isEmpty()) {
            throw new Exception("Esta editorial no tiene libros para eliminar");
        }
        libros.forEach(l -> DAO.eliminarLibro(l));
    }

    private void validarDatos(String titulo, Long isbn, String autor, int ejemplares) throws Exception {

        if (titulo == null || titulo.trim().isEmpty()) {
            throw new Exception("El título del libro no puede estar vacío");
        }

        if (autor == null || autor.trim().isEmpty()) {
            throw new Exception("El autor del libro no puede estar vacío");
        }

        if (ejemplares < 0) {
            throw new Exception("El número de ejemplares no puede ser negativo");
        }

        if (isbn.toString().length() != 10 && isbn.toString().length() != 13) {
            throw new Exception("El ISBN debe tener 10 o 13 caracteres");
        }

    }

}
