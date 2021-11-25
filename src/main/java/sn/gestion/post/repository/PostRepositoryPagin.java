package sn.gestion.post.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import sn.gestion.post.model.Post;

public interface PostRepositoryPagin extends PagingAndSortingRepository<Post,Long> {
}
