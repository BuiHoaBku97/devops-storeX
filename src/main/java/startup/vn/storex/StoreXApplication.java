package startup.vn.storex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class StoreXApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreXApplication.class, args);
    }

}
