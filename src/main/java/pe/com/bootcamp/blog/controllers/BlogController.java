package pe.com.bootcamp.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.bootcamp.blog.entities.Blog;
import pe.com.bootcamp.blog.services.BlogService;

@RestController
@RequestMapping("blog")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@GetMapping
	public List<Blog> getAll() {
		List<Blog> lista = blogService.getAll();
		return lista;
	}
	
	@GetMapping("/{id}")
	public Blog getById(@PathVariable("id") Long id) {
		return blogService.getById(id);
	}
	
	@PostMapping
	public Blog save(@RequestBody Blog blog) {
		return blogService.save(blog);
	}

}
