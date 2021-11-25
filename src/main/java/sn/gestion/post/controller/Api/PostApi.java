package sn.gestion.post.controller.Api;

import org.springframework.web.bind.annotation.*;
import sn.gestion.post.dto.PostDto;

import java.util.List;

public interface PostApi {
    @PostMapping("/posts/add")
    PostDto save(@RequestBody PostDto postDto);
    @PutMapping("/posts/update/{id}")
    PostDto updatePost(@RequestBody PostDto postDto,@PathVariable Long id);
    @GetMapping("/posts/list")
    List<PostDto> findAllPosts();

}
