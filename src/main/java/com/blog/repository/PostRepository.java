package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blog.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	
	/*
	 * Custome Finder Method.................................
	 */
	// Find Post By Based On comment.................................
	public Post findByComment(String comment);
	
	// FInd Post Based On title...........................
		public Post findByTitle(String title);
		
		
		// NAtive JPQL Query By Using @Query...................................................................
		@Query(value = "SELECT * FROM post WHERE LOWER(comment) = LOWER(:comment)", nativeQuery = true)
	    Post findByCommentNative(@Param("comment") String comment);

		
		//JPQL Query..............
		@Query(value = "Select * from post where LOWER(title) = LOWER(:title)",nativeQuery = true)
		Post findByTitleNativeQuery(@Param("title") String title);
}
