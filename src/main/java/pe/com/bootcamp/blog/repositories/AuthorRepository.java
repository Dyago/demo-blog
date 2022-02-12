package pe.com.bootcamp.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.bootcamp.blog.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
