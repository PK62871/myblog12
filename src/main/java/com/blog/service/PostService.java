package com.blog.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.blog.dto.PostDto;
import com.blog.model.Post;

public interface PostService {

	// Create Post......................
	public PostDto createPost(PostDto postDto);

	// DeletePostById................................
	public void deletePost(Long id);

	// FetchAll Posts.................................
	public List<PostDto> fetchAllPosts();

	// FetchAll Posts By Pegination.................................
	public List<PostDto> fetchAllPostsPegination(int pageNo, int pageSize);

	// Fetch All Post By Pegination Sort By......................................
	public List<PostDto> fetchAllPostsPeginationBySorting(int pageNo, int pageSize, String sortBy);

	// Fetch All Post By Pegination Sort By Direction Like ASC OR
	// DESC......................................
	public List<PostDto> fetchAllPostsPeginationBySortingByAscOrDesc(int pageNo, int pageSize, String sortBy,
			String sortDir);
	
	// Find Post Based On Comment.......................................
	public PostDto findByComment(String comment);
	
	
	// FInd Post Based On title;
	public PostDto findByTitle(String title);
	
	// Query Method...................
	 PostDto findByCommentNative(String comment);
	 
	 PostDto findByTitleNativeQuery(String title);
}
