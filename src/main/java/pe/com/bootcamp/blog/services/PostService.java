package pe.com.bootcamp.blog.services;

import java.util.List;

import pe.com.bootcamp.blog.entities.Post;

public interface PostService {

	List<Post> getAll();

	Post getById(Long id);

	Post save(Post post);

	Post publish(Long id);

}
