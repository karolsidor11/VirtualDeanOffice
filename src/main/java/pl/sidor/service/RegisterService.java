package pl.sidor.service;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import pl.sidor.connection.DatabaseConnection;
import pl.sidor.entity.general.Student;

import javax.persistence.EntityManager;

public class RegisterService {

    protected final static Logger log = LoggerFactory.logger(RegisterService.class);
    private EntityManager entityManager = DatabaseConnection.getInstance();

    /**
     * Method persist student to database
     * @param student
     * @return true if student registered
     *         false if student not registered
     */
    public boolean registerStudent(Student student) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            log.error("Error while persist to the database");
            entityManager.getTransaction().rollback();

            return false;
        }
    }
}
