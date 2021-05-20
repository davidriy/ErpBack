package riy.david.erp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import riy.david.erp.model.Employee;

import java.util.Optional;


public interface EmployeeRepository extends MongoRepository<Employee, String> {
    @Query("{'document': ?0}")
    Optional<Employee> findByDocument(String document);
}
