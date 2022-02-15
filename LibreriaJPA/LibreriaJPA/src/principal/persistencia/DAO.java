package principal.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAO<T> {

    private final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("LibreriaPU");
    protected EntityManager em = EMF.createEntityManager();

    protected void conectar() {
        if (!em.isOpen()) {
            em = EMF.createEntityManager();
        }
    }

    protected void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }

    protected void guardar(T objeto) {
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
    }

    protected T editar(T objeto) {
        conectar();
        em.getTransaction().begin();
        T t = em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
        return t;
    }

    protected void eliminar(T objeto) {
        conectar();
        em.getTransaction().begin();
        if (!em.contains(objeto)) {
            objeto = em.merge(objeto);
        }
        em.remove(objeto);
        em.getTransaction().commit();
        desconectar();
    }

}
