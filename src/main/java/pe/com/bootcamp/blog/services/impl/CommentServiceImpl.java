package pe.com.bootcamp.blog.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import pe.com.bootcamp.blog.entities.Comment;
import pe.com.bootcamp.blog.entities.Post;
import pe.com.bootcamp.blog.exceptions.BusinessException;
import pe.com.bootcamp.blog.repositories.CommentRepository;
import pe.com.bootcamp.blog.repositories.PostRepository;
import pe.com.bootcamp.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public List<Comment> getAll() {
		return commentRepository.findAll();
	}
	
	@Override
	public Comment getById(Long id) {
		return commentRepository.findById(id).orElse(null);
	}
	
	@Override
	public Comment save(Comment comment) {
		Post post = postRepository.findById(comment.getPost().getId()).orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND,
				"El codigo de post ingresado no se encuentra registrado"));
		if ("BORRADOR".equals(post.getStatus())) {
			throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Solo se puede registrar comentarios en un post publicado");
		} else {
			return commentRepository.save(comment);
		}
	}
}
