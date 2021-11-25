package sn.gestion.post.validator;

import org.springframework.util.StringUtils;
import sn.gestion.post.dto.PostDto;

import java.util.ArrayList;
import java.util.List;

public class PostValidator {
    public static List<String> validate(PostDto postDto){
        List<String> errors = new ArrayList<>();
        if(postDto == null) {
            errors.add("Veuillez renseigner le titre");
            errors.add("Veuillez renseigner la description");
            return errors;
        }
        return getString( postDto.getTitle(),postDto.getDescription());
    }
    public static List<String> getString(String tiltle, String description){
        List<String> errors = new ArrayList<>();
        if (!StringUtils.hasLength(tiltle)){
            errors.add("Veuillez renseigner le titre");
            return errors;
        }
        if (!StringUtils.hasLength(description)){
            errors.add("Veuillez renseigner la description");
            return errors;
        }

        return errors;
    }
}
