package sn.gestion.post.controller.Api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sn.gestion.post.dto.UtlisateurDto;

public interface UtlisateurApi {
        @PostMapping("/auth/register")
        UtlisateurDto save(@RequestBody UtlisateurDto utlisateurDto) throws Exception;
}
