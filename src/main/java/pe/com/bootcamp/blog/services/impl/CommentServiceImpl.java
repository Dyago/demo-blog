package pe.com.bootcamp.blog.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.bootcamp.blog.entities.Comment;
import pe.com.bootcamp.blog.entities.Post;
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
		Post post = postRepository.findById(comment.getPost().getId()).get();
		if ("BORRADOR".equals(post.getStatus())) {
			System.err.println("Solo se puede registrar comentarios en un post publicado");
			return null;
		} else {
			return commentRepository.save(comment);
		}
	}
}
