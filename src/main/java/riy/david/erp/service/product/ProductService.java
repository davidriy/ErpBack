package riy.david.erp.service.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import riy.david.erp.model.Product;
import riy.david.erp.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public Product addProduct(Product product){
        productRepository.save(product);
        return product;
    }

    public Product updateProduct(Product product) {
        Product savedProduct = productRepository.findById(product.getId())
                .orElseThrow( () -> new RuntimeException(
                        String.format("Cannot find Employee by ID %s", product.getId())));
        savedProduct.setId(product.getId());
        savedProduct.setName(product.getName());
        savedProduct.setPrice(product.getPrice());
        savedProduct.setStock(product.getStock());

        return productRepository.save(savedProduct);
    }

    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    public Product getProductById(String id) {
        return productRepository.findById(id)
                .orElseThrow( () -> new RuntimeException(
                        String.format("Cannot find Product by id %s", id)
                ));
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
