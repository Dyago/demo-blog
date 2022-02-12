package pe.com.bootcamp.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.bootcamp.blog.entities.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long> {
	
	List<Blog> findByAuthorId(Long id);

}
