package startup.vn.storex.init_data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import startup.vn.storex.models.Product;
import startup.vn.storex.services.ProductService;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitProduct implements CommandLineRunner {
    private ProductService productService;

    public InitProduct(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        if( productService.getProducts().isEmpty()) {
            // Initialize product data here
            List<Product> products = new ArrayList<Product>();
            products.add(new Product(null, "Product 1", "Description 1", 10.0));
            products.add(new Product(null, "Product 2", "Description 2", 20.0));
            products.add(new Product(null, "Product 3", "Description 3", 30.0));
            productService.saveProduct(products.get(0));
            productService.saveProduct(products.get(1));
            productService.saveProduct(products.get(2));
        }
    }
}
