package principal.services;

import java.util.List;
import java.util.UUID;
import principal.entities.Editorial;
import principal.persistencia.EditorialDAO;

public class EditorialServicio {

    private final EditorialDAO DAO;
    private LibroServicio libroServicio;

    public EditorialServicio() {
        DAO = new EditorialDAO();
        libroServicio = new LibroServicio();
    }

    public Editorial crearEditorial(String nombre) throws Exception {

        validarNombre(nombre);

        Editorial e = new Editorial();
        e.setId(UUID.randomUUID().toString());
        e.setNombre(nombre);
        e.setAlta(true);

        DAO.guardarEditorial(e);
        return e;
    }

    public Editorial editarEditorial(Editorial e) throws Exception {
        return DAO.actualizarEditorial(e);
    }

    public Editorial alta(String idEditorial) throws Exception {
        Editorial e = buscarPorId(idEditorial);
        e.setAlta(true);
        return DAO.actualizarEditorial(e);
    }

    public Editorial baja(String idEditorial) throws Exception {
        Editorial e = buscarPorId(idEditorial);
        e.setAlta(false);
        return DAO.actualizarEditorial(e);
    }

    public void eliminarEditorial(String id) throws Exception {
        Editorial e = buscarPorId(id);

        libroServicio.eliminarPorEditorial(id);

        DAO.eliminarEditorial(e);
    }

    public List<Editorial> listarTodos() throws Exception {
        List<Editorial> editoriales = DAO.listarTodos();
        if (editoriales.isEmpty()) {
            throw new Exception("No hay editoriales para mostrar");
        }
        return editoriales;
    }

    public List<Editorial> listarActivos() throws Exception {
        List<Editorial> editoriales = DAO.listarActivos();
        if (editoriales.isEmpty()) {
            throw new Exception("No hay editoriales activos para mostrar");
        }
        return editoriales;
    }

    public Editorial buscarPorId(String id) throws Exception {
        Editorial e = DAO.buscarPorId(id);
        if (e == null) {
            throw new Exception("No se encontró una editorial con ID " + id);
        }
        return e;
    }

    public Editorial buscarPorNombre(String nombre) throws Exception {
        Editorial e = DAO.buscarPorNombre(nombre);
        if (e == null) {
            throw new Exception("No se encontró una editorial con el nombre " + nombre);
        }
        return e;
    }

    private void validarNombre(String nombre) throws Exception {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("El nombre no puede estar vacío");
        }

        if (DAO.buscarPorNombre(nombre) != null) {
            throw new Exception("Ya existe una editorial con ese nombre");
        }
    }
}
