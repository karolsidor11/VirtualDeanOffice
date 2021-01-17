package pl.sidor.service;

import pl.sidor.connection.DatabaseConnection;
import pl.sidor.entity.general.Student;

import javax.persistence.EntityManager;

public class RegisterService {

    private EntityManager entityManager = DatabaseConnection.getInstance();

    public void registerStudent(Student student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
    }
}
