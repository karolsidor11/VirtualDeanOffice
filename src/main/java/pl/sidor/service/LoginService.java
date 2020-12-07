package pl.sidor.service;

import com.google.common.base.Optional;
import pl.sidor.connection.DatabaseConnection;
import pl.sidor.entity.general.Student;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class LoginService {

    private EntityManager entityManager = DatabaseConnection.getInstance();

    public Optional<Student> findStudentByEmialAndPassword(String email, String password) {
        Query query = entityManager.createQuery("select s from Student s where s.email=:email and s.password=:password");
        query.setParameter("email", email);
        query.setParameter("password", password);

        if (query.getResultList().isEmpty()) {
            return Optional.absent();
        }
        return Optional.fromNullable((Student) query.getResultList().get(0));
    }
}
