package principal.persistencia;

import java.util.List;
import javax.persistence.NoResultException;
import principal.entities.Autor;

public class AutorDAO extends DAO<Autor> {

    public void guardarAutor(Autor a) {
        guardar(a);
    }

    public void eliminarAutor(Autor a) {
        eliminar(a);
    }

    public Autor actualizarAutor(Autor a) {
        return editar(a);
    }

    public Autor buscarPorId(String id) {
        conectar();
        try {
            return (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.id = :id")
                    .setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            System.out.println("AUTOR DAO EXCEPTION: " + e.getMessage());
            return null;
        } finally {
            desconectar();
        }
    }

    public List<Autor> buscarPorNombre(String nombre) {
        conectar();
        try {
            return (List<Autor>) (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre")
                    .setParameter("nombre", nombre).getResultList();
        } catch (NoResultException e) {
            System.out.println("AUTOR DAO EXCEPTION: " + e.getMessage());
            return null;
        } finally {
            desconectar();
        }
    }

    public List<Autor> listarTodos() {
        conectar();
        try {
            return em.createQuery("SELECT a FROM Autor a").getResultList();
        } catch (Exception e) {
            System.out.println("AUTOR DAO EXCEPTION: " + e.getMessage());
            return null;
        } finally {
            desconectar();
        }
    }

    public List<Autor> listarActivos() {
        conectar();
        try {
            return em.createQuery("SELECT a FROM Autor a WHERE a.alta = TRUE").getResultList();
        } catch (Exception e) {
            System.err.println("Error al listar todos los autores");
            return null;
        } finally {
            desconectar();
        }
    }
}
