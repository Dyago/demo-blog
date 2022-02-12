package pe.com.bootcamp.blog.services;

import java.util.List;

import pe.com.bootcamp.blog.entities.Author;

public interface AuthorService {

	List<Author> getAll();

	Author getById(Long id);

	Author save(Author author);

	void delete(Long id);

}
