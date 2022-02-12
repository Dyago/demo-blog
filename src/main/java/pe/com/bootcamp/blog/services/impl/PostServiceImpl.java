package pe.com.bootcamp.blog.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import pe.com.bootcamp.blog.entities.Blog;
import pe.com.bootcamp.blog.entities.Post;
import pe.com.bootcamp.blog.exceptions.BusinessException;
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
		return postRepository.findById(id).orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND,
				"El codigo ingresado no se encuentra registrado"));
	}

	@Override
	public Post save(Post post) {
		Blog blog = blogRepository.findById(post.getBlog().getId()).orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND,
				"El codigo de blog ingresado no se encuentra registrado"));
		if ("INACTIVO".equals(blog.getStatus())) {
			throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR,
					"No se puede registrar post en blog con estado INACTIVO");
		} else {
			post.setCreateDate(new Date());
			post.setStatus("BORRADOR");
			return postRepository.save(post);
		}
		
	}

	@Override
	public Post publish(Long id) {
		if (postRepository.existsPostPublished(new Date())) {
			throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR,
					"No se puede publicar un post en el mismo dia");
		} else {
			Post post = postRepository.findById(id).get();
			post.setStatus("PUBLICADO");
			post.setPublishDate(new Date());
			return postRepository.saveAndFlush(post);
		}
	}

}
