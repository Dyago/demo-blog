package pe.com.bootcamp.blog.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.com.bootcamp.blog.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	
	List<Post> findByPublishDate(Date date);
	
	@Query("select case when count(p)> 0 then true else false end from Post p where CAST(p.publishDate AS date) = CAST(:publishDate AS date)")
	boolean existsPostPublished(@Param("publishDate") Date publishDate);

}
