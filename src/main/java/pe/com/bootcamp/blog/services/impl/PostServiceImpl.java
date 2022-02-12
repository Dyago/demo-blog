package pe.com.bootcamp.blog.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.bootcamp.blog.entities.Blog;
import pe.com.bootcamp.blog.entities.Post;
import pe.com.bootcamp.blog.repositories.BlogRepository;
import pe.com.bootcamp.blog.repositories.PostRepository;
import pe.com.bootcamp.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private BlogRepository blogRepository;

	@Override
	public List<Post> getAll() {
		return postRepository.findAll();
	}

	@Override
	public Post getById(Long id) {
		return postRepository.findById(id).orElse(null);
	}

	@Override
	public Post save(Post post) {
		Blog blog = blogRepository.findById(post.getBlog().getId()).get();
		if ("INACTIVO".equals(blog.getStatus())) {
			System.err.println("No se puede registrar post en blog con estado INACTIVO");
			return null;
		} else {
			post.setCreateDate(new Date());
			post.setStatus("BORRADOR");
			return postRepository.save(post);
		}
		
	}

	@Override
	public Post publish(Long id) {
		if (postRepository.existsPostPublished(new Date())) {
			System.err.println("No se puede publicar un post en el mismo dia");
			return null;
		} else {
			Post post = postRepository.findById(id).get();
			post.setStatus("PUBLICADO");
			post.setPublishDate(new Date());
			return postRepository.saveAndFlush(post);
		}
	}

}
