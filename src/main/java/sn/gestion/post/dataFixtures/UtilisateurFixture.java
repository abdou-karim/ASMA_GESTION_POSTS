package sn.gestion.post.dataFixtures;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import sn.gestion.post.model.Utilisateur;
import sn.gestion.post.repository.UtilisateurRepository;

import java.util.Arrays;


@AllArgsConstructor
@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
@Order(3)
public class UtilisateurFixture implements CommandLineRunner {

    private UtilisateurRepository userRepository;

    @Override
    public void run(String... args) {
        String password = "password";
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);

        userRepository.saveAll(Arrays.asList(
                new Utilisateur("omzo", encodedPassword),
                new Utilisateur("mouhamed",  encodedPassword)
        ));
    }
}
