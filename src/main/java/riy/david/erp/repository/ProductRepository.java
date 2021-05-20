package riy.david.erp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import riy.david.erp.model.Product;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    @Query("ObjectId(?0)")
    Optional<Product> findById(String d);
}
