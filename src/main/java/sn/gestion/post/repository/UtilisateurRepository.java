package sn.gestion.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.gestion.post.model.Utilisateur;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Optional<Utilisateur> findByUsernameAndArchiveFalse(String username);
}
