package pl.sidor.connection;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DatabaseConnection {

    private static final String CONNECTION_NAME = "connection";
    protected final static Logger log = LoggerFactory.logger(DatabaseConnection.class);
    private static EntityManager entityManager;

    private DatabaseConnection() {
    }

    public static EntityManager getInstance() {
        if (entityManager == null) {
            try {
                entityManager = Persistence.createEntityManagerFactory(CONNECTION_NAME).createEntityManager();
            } catch (Exception e) {
                log.error("Błąd połączenia  z bazą danych MySQL.");
                throw new RuntimeException("Błąd połączenia  z bazą danych MySQL.");
            }
            return entityManager;
        }
        return entityManager;
    }
}
