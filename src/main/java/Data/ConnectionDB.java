package Data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionDB {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static void openConnection() {
        emf = Persistence.createEntityManagerFactory("projetoSwitchs");
        em = emf.createEntityManager();
    }

    public static void closeConnection() {
        em.close();
        emf.close();
    }

    public static EntityManager getEm() {
        return em;
    }
}
