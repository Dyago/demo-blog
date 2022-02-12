package pe.com.bootcamp.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.bootcamp.blog.entities.Comment;
import pe.com.bootcamp.blog.services.CommentService;

@RestController
@RequestMapping("comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping
	public List<Comment> getAll() {
		return commentService.getAll();
	}
	
	@GetMapping("/{id}")
	public Comment getById(@PathVariable("id") Long id) {
		return commentService.getById(id);
	}
	
	@PostMapping
	public Comment save(@RequestBody Comment comment) {
		return commentService.save(comment);
	}

}
