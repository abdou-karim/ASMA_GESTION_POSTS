package sn.gestion.post.validator;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import sn.gestion.post.dto.UtlisateurDto;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Slf4j
public class UtlisateurValidator {
    public static List<String> validate(UtlisateurDto utlisateurDto){
        List<String> errors = new ArrayList<>();
        if(utlisateurDto == null) {
            errors.add("Veuillez renseigner le Username");
            errors.add("Veuillez renseigner le FullName");
            errors.add("Veuillez renseigner le password");
            errors.add("Veuillez renseigner votre phone number");
            return errors;
        }
        return getString( utlisateurDto.getUsername(),utlisateurDto.getFullName(),utlisateurDto.getPassword(), utlisateurDto.getPhoneNumber());
    }
    public static List<String> getString(String username, String fullName,String password,String phoneNumber){
        List<String> errors = new ArrayList<>();
        if (!StringUtils.hasLength(username)){
            errors.add("Veuillez renseigner le Username");
            return errors;
        }
        if (!StringUtils.hasLength(fullName)){
            errors.add("Veuillez renseigner le FullName");
            return errors;
        }
        if (!StringUtils.hasLength(password)){
            errors.add("Veuillez renseigner le password");
            return errors;
        }
        if (!StringUtils.hasLength(phoneNumber)){
            errors.add("Veuillez renseigner votre phone number");
            return errors;
        }
        return errors;
    }
}
