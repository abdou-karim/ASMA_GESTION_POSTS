package sn.gestion.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.gestion.post.model.Post;
import sn.gestion.post.model.Utilisateur;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private Long id;
    String title;
    String description;
    Utilisateur utilisateur;

    public static PostDto fromEntity (Post post){
        if (post ==null){
            return  null;
        }
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .description(post.getDescription())
                .utilisateur(post.getUserId())
                .build();

    }
    public static Post toEntity(PostDto postDto){
        if (postDto ==null){
            return  null;
        }
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setUserId(post.getUserId());
        return post;
    }

}
