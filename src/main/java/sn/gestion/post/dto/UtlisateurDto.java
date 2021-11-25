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
    String phoneNumber;
    String fullName;

    public static UtlisateurDto fromEntity (Utilisateur utilisateur){
        if (utilisateur ==null){
            return  null;
        }
        return UtlisateurDto.builder()
                .id(utilisateur.getId())
                .fullName(utilisateur.getFullName())
                .username(utilisateur.getUsername())
                .password(utilisateur.getPassword())
                .phoneNumber(utilisateur.getPhoneNumber()).build();

    }
    public static Utilisateur toEntity(UtlisateurDto utlisateurDto){
        if (utlisateurDto ==null){
            return  null;
        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUsername(utlisateurDto.getUsername());
        utilisateur.setPhoneNumber(utlisateurDto.getPhoneNumber());
        utilisateur.setPassword(utlisateurDto.getPassword());
        utilisateur.setFullName(utlisateurDto.getFullName());
        return utilisateur;
    }
}
