package pe.com.bootcamp.blog.services.impl;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import pe.com.bootcamp.blog.entities.Author;
import pe.com.bootcamp.blog.entities.Blog;
import pe.com.bootcamp.blog.exceptions.BusinessException;
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
		return blogRepository.findById(id).orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND,
				"El codigo ingresado no se encuentra registrado"));
	}

	@Override
	public Blog save(Blog blog) {
		Author author = authorRepository.findById(blog.getAuthor().getId())
				.orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND,
						"El codigo de autor ingresado no se encuentra registrado"));
		if (author.getBlogs().size() > 2) {
			throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "El autor ya cuenta con 3 blogs registrados");
		} else if (Period.between(
				Instant.ofEpochMilli(author.getBirthDate().getTime()).atZone(ZoneId.systemDefault()).toLocalDate(),
				LocalDate.now()).getYears() < 18) {
			throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "El autor es menor de edad");
		}
		return blogRepository.save(blog);
	}

}
