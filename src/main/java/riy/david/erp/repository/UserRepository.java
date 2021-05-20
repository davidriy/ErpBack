package riy.david.erp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import riy.david.erp.model.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    @Query("ObjectId(?0)")
    Optional<User> findById(String d);
}
