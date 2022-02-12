package pe.com.bootcamp.blog.services;

import java.util.List;

import pe.com.bootcamp.blog.entities.Blog;

public interface BlogService {

	List<Blog> getAll();

	Blog getById(Long id);

	Blog save(Blog blog);

}
