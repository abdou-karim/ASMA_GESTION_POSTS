package sn.gestion.post.service.imp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sn.gestion.post.dto.PostDto;
import sn.gestion.post.exception.EntityNotFoundException;
import sn.gestion.post.exception.ErrorCodes;
import sn.gestion.post.exception.InvalidEntityException;
import sn.gestion.post.model.Post;
import sn.gestion.post.model.Utilisateur;
import sn.gestion.post.repository.PostRepository;
import sn.gestion.post.repository.PostRepositoryPagin;
import sn.gestion.post.repository.UtilisateurRepository;
import sn.gestion.post.service.PostService;
import sn.gestion.post.validator.PostValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("postServiceImp")
@Slf4j
@AllArgsConstructor
public class PostServiceImp implements PostService {
    UtilisateurRepository utilisateurRepository;
    PostRepository postRepository;
    PostRepositoryPagin postRepositoryPagin;
    @Override
    public PostDto save(PostDto postDto) {
        List<String> errors = PostValidator.validate(postDto);
        if (!errors.isEmpty()) {
            throw new InvalidEntityException("Post n'est pas valide", ErrorCodes.POST_NOT_VALID, errors);
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Post post = new Post();
        Utilisateur utilisateur = utilisateurRepository.findByUsernameAndArchiveFalse(auth!=null?auth.getPrincipal().toString():"sidibe").get();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setUserId(utilisateur);
        postDto.setUtilisateur(utilisateur);
        log.info(postDto.toString());
        postRepository.save(post);
        return PostDto.fromEntity(post);

    }

    @Override
    public PostDto updatePost(PostDto postDto,Long id) {
        Post post = postRepository.findByIdAndArchiveFalse(id).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun post avec l'ID = " + id + " ne se trouve dans la BDD",
                        ErrorCodes.POST_NOT_FOUND));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Utilisateur utilisateur = utilisateurRepository.findByUsernameAndArchiveFalse(auth.getPrincipal().toString()).get();
        if (utilisateur.getId()!=post.getUserId().getId()){
            throw new InvalidEntityException("Vous ne pouvez pas modifier ce post", ErrorCodes.Utilisateur_NOT_VALID);
        }
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        postRepository.flush();

        return PostDto.fromEntity(post);
    }

    @Override
    public List<PostDto> findAllPosts(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Post> pagedResult = postRepositoryPagin.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent().stream()
                    .map(PostDto::fromEntity)
                    .collect(Collectors.toList());
        } else {
            return postRepository.findAllByArchiveFalse().stream()
                    .map(PostDto::fromEntity)
                    .collect(Collectors.toList());
        }
    }
}
