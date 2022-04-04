package sn.gestion.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.gestion.post.model.Utilisateur;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UtlisateurDto {
    private Long id;
    String username;
    String password;

    public static UtlisateurDto fromEntity (Utilisateur utilisateur){
        if (utilisateur ==null){
            return  null;
        }
        return UtlisateurDto.builder()
                .id(utilisateur.getId())
                .username(utilisateur.getUsername())
                .password(utilisateur.getPassword())
                .build();

    }
    public static Utilisateur toEntity(UtlisateurDto utlisateurDto){
        if (utlisateurDto ==null){
            return  null;
        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUsername(utlisateurDto.getUsername());
        utilisateur.setPassword(utlisateurDto.getPassword());
        return utilisateur;
    }
}
