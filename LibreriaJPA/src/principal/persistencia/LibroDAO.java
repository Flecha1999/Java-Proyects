package principal.persistencia;

import java.util.List;
import javax.persistence.NoResultException;
import principal.entities.Libro;

public class LibroDAO extends DAO<Libro> {

    public void guardarLibro(Libro l) {
        guardar(l);
    }

    public void eliminarLibro(Libro l) {
        eliminar(l);
    }

    public Libro actualizarLibro(Libro l) {
        return editar(l);
    }

    public List<Libro> listarTodos() {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l").getResultList();
        desconectar();
        return libros;
    }

    public List<Libro> listarActivos() {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.alta = TRUE").getResultList();
        desconectar();
        return libros;
    }

    public Libro buscarPorId(String id) {
        conectar();
        try {
            return (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.id LIKE :id")
                    .setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            System.out.println("LIBRO DAO EXCEPTION: " + e.getMessage());
            return null;
        } finally {
            desconectar();
        }

    }

    public List<Libro> buscarPorAutor(String nombre) {
        conectar();
        try {
            return em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre LIKE :autor").setParameter("autor", "%" + nombre + "%").getResultList();
        } catch (Exception e) {
            System.out.println("LIBRO DAO EXCEPTION: " + e.getMessage());
            return null;
        } finally {
            desconectar();
        }
    }

    public List<Libro> buscarPorEditorial(String idEditorial) {
        conectar();
        try {
            return em.createQuery("SELECT l FROM Libro l WHERE l.editorial.id LIKE :editorial").setParameter("editorial", idEditorial).getResultList();
        } catch (Exception e) {
            System.out.println("LIBRO DAO EXCEPTION: " + e.getMessage());
            return null;
        } finally {
            desconectar();
        }
    }

    public Libro buscarPorISBN(Long isbn) {
        try {
            return (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.isbn LIKE :isbn")
                    .setParameter("isbn", isbn).getSingleResult();
        } catch (NoResultException e) {
            System.out.println("LIBRO DAO EXCEPTION: " + e.getMessage());
            return null;
        } finally {
            desconectar();
        }
    }

    public List<Libro> buscarPorTitulo(String titulo) {
        conectar();
        try {
            return em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :titulo").setParameter("titulo", "%" + titulo + "%").getResultList();
        } catch (Exception e) {
            System.out.println("LIBRO DAO EXCEPTION: " + e.getMessage());
            return null;
        } finally {
            desconectar();
        }
    }

    public void eliminarPorEditorial(String idEditorial) {
        conectar();
        try {
            em.createNativeQuery("DELETE FROM Libro l WHERE l.editorial.id = :idEditorial").setParameter("idEditorial", idEditorial);
        } catch (Exception e) {
            System.out.println("LIBRO DAO EXCEPTION: " + e.getMessage());

        } finally {
            desconectar();
        }

    }

}
