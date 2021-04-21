package pl.sidor.service;

import com.google.common.base.Optional;
import pl.sidor.connection.DatabaseConnection;
import pl.sidor.entity.general.Student;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class LoginService {

    private EntityManager entityManager = DatabaseConnection.getInstance();

    /**
     * Method searches for a student on the basis of email and password
     * @param email
     * @param password
     * @return Optional student
     */
    public Optional<Student> findStudentByEmialAndPassword(String email, String password) {
        TypedQuery<Student> query = entityManager.createQuery("select s from Student s where s.email=:email and s.password=:password", Student.class);
        query.setParameter("email", email);
        query.setParameter("password", password);

        return getOptionalStudent(query.getResultList());
    }

    /**
     * Method searches for a student on the basis of email
     * @param email
     * @return Optional student
     */
    public Optional<Student> findStudentByEmail(String email) {
        TypedQuery<Student> query = entityManager.createQuery("select s from Student s where s.email=:email", Student.class);
        query.setParameter("email", email);

        return getOptionalStudent(query.getResultList());
    }

    /**
     * Method get Optional student
     * @param resultList
     * @return Optional student
     */
    private Optional<Student> getOptionalStudent(List<Student> resultList) {
        return resultList.isEmpty() ? Optional.<Student>absent(): Optional.fromNullable(resultList.get(0));
    }
}
