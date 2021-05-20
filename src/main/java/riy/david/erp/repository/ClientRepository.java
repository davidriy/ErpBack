package riy.david.erp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import riy.david.erp.model.Client;
import riy.david.erp.model.Employee;

import java.util.Optional;

public interface ClientRepository extends MongoRepository<Client, String> {
    @Query("ObjectId(?0)")
    Optional<Client> findById(String id);
}
