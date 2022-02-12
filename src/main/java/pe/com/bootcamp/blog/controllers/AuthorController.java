package pe.com.bootcamp.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.bootcamp.blog.entities.Author;
import pe.com.bootcamp.blog.services.AuthorService;

@RestController
@RequestMapping("author")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@GetMapping
	public List<Author> getAll() {
		return authorService.getAll();
	}
	
	@GetMapping("/{id}")
	public Author getById(@PathVariable("id") Long id) {
		return authorService.getById(id);
	}
	
	@PostMapping
	public Author save(@RequestBody Author author) {
		return authorService.save(author);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		authorService.delete(id);
	}
	

}
