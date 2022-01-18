package principal.services;

import java.util.List;
import java.util.UUID;
import principal.entities.Autor;
import principal.persistencia.AutorDAO;

public class AutorServicio {

    private final AutorDAO DAO;

    public AutorServicio() {
        this.DAO = new AutorDAO();
    }

    public Autor crearAutor(String nombre) throws Exception {
        validarNombre(nombre);
        Autor a = new Autor();
        a.setId(UUID.randomUUID().toString());
        a.setAlta(Boolean.TRUE);
        a.setNombre(nombre);
        DAO.guardarAutor(a);
        return a;
    }

    public Autor alta(String idAutor) throws Exception {
        Autor a = buscarPorId(idAutor);
        a.setAlta(true);
        return DAO.actualizarAutor(a);
    }

    public Autor baja(String idAutor) throws Exception {
        Autor a = buscarPorId(idAutor);
        a.setAlta(false);
        return DAO.actualizarAutor(a);
    }

    public Autor cambiarNombre(String idAutor, String nuevoNombre) throws Exception {
        Autor a = buscarPorId(idAutor);
        validarNombre(nuevoNombre);
        a.setNombre(nuevoNombre);
        return DAO.actualizarAutor(a);
    }

    public void eliminarAutor(String idAutor) throws Exception {
        Autor a = buscarPorId(idAutor);
        DAO.eliminarAutor(a);
    }

    public List<Autor> listarTodos() throws Exception {
        List<Autor> autores = DAO.listarTodos();
        if (autores.isEmpty()) {
            throw new Exception("No hay autores para mostrar");
        }
        return autores;
    }

    public List<Autor> listarActivos() throws Exception {
        List<Autor> autores = DAO.listarActivos();
        if (autores.isEmpty()) {
            throw new Exception("No hay autores activos para mostrar");
        }
        return autores;
    }

    public Autor buscarPorId(String id) throws Exception {
        Autor a = DAO.buscarPorId(id);
        if (a == null) {
            throw new Exception("No se encontró un autor con ID " + id);
        }
        return a;
    }

    public Autor buscarPorNombre(String nombre) throws Exception {
//        Autor a = DAO.buscarPorNombre(nombre);
//        if (a == null) {
//            throw new Exception("No se encontró un autor con el nombre " + nombre);
//        }
//        return a;
        return null;

    }
    
    private void validarNombre(String nombre) throws Exception {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("El nombre del autor no puede estar vacío");
        }
        List<Autor> autores = DAO.buscarPorNombre(nombre);
        for (Autor autor : autores) {
            if (autor.getNombre().equalsIgnoreCase(nombre)) {
                throw new Exception("Ya existe un autor con ese nombre");
            }
        }

    }

}
