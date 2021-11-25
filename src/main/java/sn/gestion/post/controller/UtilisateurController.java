package sn.gestion.post.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import sn.gestion.post.controller.Api.UtlisateurApi;
import sn.gestion.post.dto.UtlisateurDto;
import sn.gestion.post.service.UtlisateurService;

@RestController
@AllArgsConstructor
public class UtilisateurController implements UtlisateurApi {
    UtlisateurService utlisateurService;
    @Override
    public UtlisateurDto save(UtlisateurDto utlisateurDto) throws Exception {
        return utlisateurService.save(utlisateurDto);
    }
}
