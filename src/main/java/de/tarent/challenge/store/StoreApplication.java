package de.tarent.challenge.store;

import com.google.common.collect.Sets;
import de.tarent.challenge.store.model.Product;
import de.tarent.challenge.store.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}

	/*@Bean
	CommandLineRunner runner(ProductService productService) {
		return args -> {
			productService.save(new Product("1002", "Milch", 2.39, Sets.newHashSet("12345678", "77777777", "23498128")));
			productService.save(new Product("20035", "Brot", 1.35, Sets.newHashSet("34558821", "12323410")));
			productService.save(new Product("S-0155", "Käse", 7.15, Sets.newHashSet("34598146","43565922","23454045")));
			productService.save(new Product("10488", "Wurst", 5.00, Sets.newHashSet("18754629","46025548")));
			productService.save(new Product("B0001", "Couscous", 3.00, Sets.newHashSet("54342316")));
		};
	}*/
}
