package sn.gestion.post.service.imp;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.gestion.post.model.Utilisateur;
import sn.gestion.post.repository.UtilisateurRepository;
import sn.gestion.post.service.ApplicationService;

@Service("applicationServiceImpl")
@Transactional
@AllArgsConstructor
@Log4j2
public class ApplicationServiceImpl implements ApplicationService {
    UtilisateurRepository utilisateurRepository;

    @Override
    public Utilisateur findByUsername(String username) {
        if (utilisateurRepository.findByUsernameAndArchiveFalse(username).isPresent()){
            return utilisateurRepository.findByUsernameAndArchiveFalse(username).get();
        }
        return null;
    }
}
