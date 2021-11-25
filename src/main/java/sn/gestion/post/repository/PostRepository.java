package sn.gestion.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.gestion.post.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {
    Optional<Post> findByIdAndArchiveFalse(Long id);
    List<Post> findAllByArchiveFalse();
}
