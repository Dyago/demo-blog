package pe.com.bootcamp.blog.services;

import java.util.List;

import pe.com.bootcamp.blog.entities.Comment;

public interface CommentService {

	List<Comment> getAll();

	Comment getById(Long id);

	Comment save(Comment comment);

}
