package sn.gestion.post.service.imp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sn.gestion.post.dto.UtlisateurDto;
import sn.gestion.post.exception.ErrorCodes;
import sn.gestion.post.exception.InvalidEntityException;
import sn.gestion.post.model.Utilisateur;
import sn.gestion.post.repository.UtilisateurRepository;
import sn.gestion.post.service.UtlisateurService;
import sn.gestion.post.validator.UtlisateurValidator;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service("utlisateurServiceImpl")
@Slf4j
@AllArgsConstructor
public class UtlisateurServiceImpl implements UtlisateurService {
    UtilisateurRepository utilisateurRepository;
    PasswordEncoder encoder = new BCryptPasswordEncoder();
    @Override
    public UtlisateurDto save(UtlisateurDto utlisateurDto) throws Exception{
        List<String> errors = UtlisateurValidator.validate(utlisateurDto);
        validation(utlisateurDto);
        if (!errors.isEmpty()) {
            throw new InvalidEntityException("Utlisateur n'est pas valide", ErrorCodes.Utilisateur_NOT_VALID, errors);
        }
        if (utilisateurRepository.findByUsernameAndArchiveFalse(utlisateurDto.getUsername()).isPresent()){
            throw new InvalidEntityException("Utlisateur existe deja", ErrorCodes.Utilisateur_ALREADY_IN_USE, errors);
        }
        utlisateurDto.setPassword(encoder.encode(utlisateurDto.getPassword()));
        return UtlisateurDto.fromEntity(
                utilisateurRepository.save(
                        UtlisateurDto.toEntity(utlisateurDto)
                )
        );
    }
    private void validation(UtlisateurDto utlisateurDto) {
        List<String> errors = UtlisateurValidator.validate(utlisateurDto);

        if(userAlreadyExistsUsername(utlisateurDto.getUsername())) {
            throw new InvalidEntityException("Un autre utilisateur avec le meme nom d'utilisateur existe deja", ErrorCodes.Utilisateur_ALREADY_IN_USE,
                    Collections.singletonList("Un autre utilisateur avec le meme nom d'utilisateur existe deja dans la BDD"));
        }
        if (!errors.isEmpty()) {
            log.error("Admin is not valid {}", utlisateurDto);
            throw new InvalidEntityException("L'admin n'est pas valide", ErrorCodes.Utilisateur_NOT_VALID, errors);
        }

    }
    private boolean userAlreadyExistsUsername(String username) {
        Optional<Utilisateur> user;
            user = utilisateurRepository.findByUsernameAndArchiveFalse(username);
        return user.isPresent();
    }
}
