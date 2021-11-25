package sn.gestion.post.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import sn.gestion.post.controller.Api.PostApi;
import sn.gestion.post.dto.PostDto;
import sn.gestion.post.service.PostService;

import java.util.List;


@RestController
@AllArgsConstructor
public class PostController implements PostApi {
    PostService postService;
    @Override
    public PostDto save(PostDto postDto) {
        return postService.save(postDto);
    }

    @Override
    public PostDto updatePost(PostDto postDto,Long id) {
        return postService.updatePost(postDto,id);
    }

    @Override
    public List<PostDto> findAllPosts() {
        return postService.findAllPosts();
    }

}
