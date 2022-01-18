package principal.persistencia;

import java.util.List;
import javax.persistence.NoResultException;
import principal.entities.Editorial;

public class EditorialDAO extends DAO<Editorial> {

    public void guardarEditorial(Editorial e) throws Exception {
        super.guardar(e);
    }

    public void eliminarEditorial(Editorial e) throws Exception {
        eliminar(e);
    }

    public Editorial actualizarEditorial(Editorial e) throws Exception {
        return editar(e);
    }

    public Editorial buscarPorId(String id) {
        conectar();
        try {
            return (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.id LIKE :id")
                    .setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            System.out.println("EDITORIAL DAO EXCEPTION: " + e.getMessage());
            return null;
        } finally {
            desconectar();
        }
    }

    public Editorial buscarPorNombre(String nombre) {
        conectar();
        try {
            return (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.nombre LIKE :nombre")
                    .setParameter("nombre", nombre).getSingleResult();
        } catch (NoResultException e) {
            System.out.println("EDITORIAL DAO EXCEPTION: " + e.getMessage());
            return null;
        } finally {
            desconectar();
        }
    }

    public List<Editorial> listarTodos() {
        conectar();
        try {
            return em.createQuery("SELECT e FROM Editorial e").getResultList();
        } catch (Exception e) {
            System.out.println("EDITORIAL DAO EXCEPTION: " + e.getMessage());
            return null;
        } finally {
            desconectar();
        }
    }

    public List<Editorial> listarActivos() {
        conectar();
        try {
            return em.createQuery("SELECT e FROM Editorial e WHERE e.alta = TRUE").getResultList();
        } catch (Exception e) {
            System.out.println("EDITORIAL DAO EXCEPTION: " + e.getMessage());
            return null;
        } finally {
            desconectar();
        }
    }

}
