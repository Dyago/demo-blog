package pe.com.bootcamp.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.bootcamp.blog.entities.Post;
import pe.com.bootcamp.blog.services.PostService;

@RestController
@RequestMapping("post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping
	public List<Post> getAll() {
		return postService.getAll();
	}
	
	@GetMapping("/{id}")
	public Post getById(@PathVariable("id") Long id) {
		return postService.getById(id);
	}
	
	@PostMapping
	public Post save(@RequestBody Post post) {
		return postService.save(post);
	}
	
	@PatchMapping("/{id}/publish")
	public Post publish(@PathVariable("id") Long id) {
		return postService.publish(id);
	}

}
