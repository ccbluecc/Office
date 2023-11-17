package sit.int202.classicmodels_tue.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.classicmodels_tue.entities.Environment;

public class EntityManagerBuilder {
    private final static EntityManagerFactory emf  = Persistence.createEntityManagerFactory(Environment.PUNIT_NAME);
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
