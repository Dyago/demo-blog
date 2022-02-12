package pe.com.bootcamp.blog.services.impl;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.bootcamp.blog.entities.Author;
import pe.com.bootcamp.blog.entities.Blog;
import pe.com.bootcamp.blog.repositories.AuthorRepository;
import pe.com.bootcamp.blog.repositories.BlogRepository;
import pe.com.bootcamp.blog.services.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public List<Blog> getAll() {
		return blogRepository.findAll();
	}

	@Override
	public Blog getById(Long id) {
		return blogRepository.findById(id).orElse(null);
	}

	@Override
	public Blog save(Blog blog) {
		Author author = authorRepository.findById(blog.getAuthor().getId()).orElse(null);
		if (author != null) {
			if (author.getBlogs().size() > 2) {
				System.err.println("El autor ya cuenta con 3 blogs registrados");
				return null;
			} else if (Period.between(
					Instant.ofEpochMilli(author.getBirthDate().getTime()).atZone(ZoneId.systemDefault()).toLocalDate(),
					LocalDate.now()).getYears() < 18) {
				System.err.println("El autor es menor de edad");
				return null;
			} else {
				return blogRepository.save(blog);
			}
		} else {
			System.err.println("El codigo de autor ingresado no existe");
			return null;
		}
	}

}
