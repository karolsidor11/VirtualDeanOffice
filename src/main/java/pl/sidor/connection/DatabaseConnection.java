package pl.sidor.connection;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DatabaseConnection {

    protected final static Logger log = LoggerFactory.logger(DatabaseConnection.class);

    /** Persistence Unit Name */
    private static final String CONNECTION_NAME = "connection";
    private static EntityManager entityManager;

    /**
     * Method create instance EntityManger
     */
    public static EntityManager getInstance() {
        if (entityManager == null) {
            createConnection();
            return entityManager;
        }
        return entityManager;
    }

    /**
     * Method create EntityManger based persistence.xml
     */
    private static void createConnection() {
        try {
            entityManager = Persistence.createEntityManagerFactory(CONNECTION_NAME).createEntityManager();
        } catch (Exception e) {
            log.error("MySQL database connection error");
            throw new RuntimeException("MySQL database connection error");
        }
    }
}
