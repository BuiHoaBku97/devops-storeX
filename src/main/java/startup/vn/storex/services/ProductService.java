package startup.vn.storex.services;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import startup.vn.storex.models.Product;
import startup.vn.storex.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Cacheable(cacheNames = "products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @CacheEvict(cacheNames = "products", allEntries = true)
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
