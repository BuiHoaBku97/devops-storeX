package startup.vn.storex.init_data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import startup.vn.storex.models.Product;
import startup.vn.storex.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitProduct implements CommandLineRunner {
    private ProductRepository productRepository;

    public InitProduct(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if( productRepository.findAll().isEmpty()) {
            // Initialize product data here
            List<Product> products = new ArrayList<Product>();
            products.add(new Product(null, "Product 1", "Description 1", 10.0));
            products.add(new Product(null, "Product 2", "Description 2", 20.0));
            products.add(new Product(null, "Product 3", "Description 3", 30.0));
            productRepository.saveAll(products);
        }
    }
}
