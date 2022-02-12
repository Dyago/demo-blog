package pe.com.bootcamp.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.bootcamp.blog.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
