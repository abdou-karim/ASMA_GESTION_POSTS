package sn.gestion.post.service.imp;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sn.gestion.post.dto.PostDto;
import sn.gestion.post.repository.UtilisateurRepository;
import sn.gestion.post.service.PostService;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PostServiceImpTest {
    @Autowired
    PostService postService;
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Test
    void save() {
     PostDto expectedPostDto =   PostDto.builder()
                .title("nouvelle post")
                .description("nouvelle description")
                .build();
              PostDto postDto =  postService.save(expectedPostDto);
              assertNotNull(postDto);
              assertNotNull(postDto.getId());
              assertEquals(expectedPostDto.getTitle(),postDto.getTitle());
              assertEquals(expectedPostDto.getDescription(),postDto.getDescription());
    }

    @Test
    void updatePost() {
    }

    @Test
    void findAllPosts() {
    }
}
