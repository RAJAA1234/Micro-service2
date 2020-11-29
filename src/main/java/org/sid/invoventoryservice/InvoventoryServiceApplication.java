package org.sid.invoventoryservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@SpringBootApplication
public class InvoventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoventoryServiceApplication.class, args);
	}
		@Bean
		CommandLineRunner start(ProductRepository productRepository ){
			return args -> {
				productRepository.save(new Product(null,"pc",788,12));
				productRepository.save(new Product(null,"souri",758,10));
				productRepository.save(new Product(null,"tv",58,12));
				productRepository.save(new Product(null,"tel",752,7));
			    productRepository.findAll().forEach(c->{
				   System.out.println(c.getNom());
				
		
					
				});
				
				
				
				
			};

		}
		
	}
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
class Product {
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private double prix;
	private double quantite;
	

}
@RepositoryRestResource
interface ProductRepository extends JpaRepository<Product, Long>{
}


