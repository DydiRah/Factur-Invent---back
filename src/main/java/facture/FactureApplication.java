package facture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"facture.Modele",
		"facture.Controller",
		"facture.Service",
		"facture.Repos"
})
public class FactureApplication {
	public static void main(String[] args) {
		SpringApplication.run(FactureApplication.class, args);
	}

}
