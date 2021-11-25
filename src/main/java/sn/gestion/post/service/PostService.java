package sn.gestion.post.service;

import sn.gestion.post.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto save(PostDto postDto);
    PostDto updatePost (PostDto postDto,Long id);
    List<PostDto> findAllPosts();
}
