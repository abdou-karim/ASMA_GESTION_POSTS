package sn.gestion.post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GestionPostApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionPostApplication.class, args);
	}

}
