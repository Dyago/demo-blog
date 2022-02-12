package pe.com.bootcamp.blog.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.bootcamp.blog.entities.Author;
import pe.com.bootcamp.blog.repositories.AuthorRepository;
import pe.com.bootcamp.blog.services.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	public List<Author> getAll() {
		return authorRepository.findAll();
	}

	@Override
	public Author getById(Long id) {
		return authorRepository.findById(id).orElse(null);
	}

	@Override
	public Author save(Author author) {
		return authorRepository.save(author);
	}
	
	@Override
	public void delete(Long id) {
		authorRepository.deleteById(id);
	}

}
