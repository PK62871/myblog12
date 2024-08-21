package com.blog.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.blog.dto.PostDto;
import com.blog.model.Post;
import com.blog.repository.PostRepository;
import com.blog.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private ModelMapper modelMapper;

	// Create Post.....................................................
	@Override
	public PostDto createPost(PostDto postDto) {

		Post post = mapToEntity(postDto);

//		Post post = new Post();
//		post.setComment(postDto.getComment());
//		post.setContent(postDto.getContent());
//		post.setDescription(postDto.getDescription());
//		post.setTitle(postDto.getTitle());

		Post postSaved = postRepository.save(post);

//		PostDto dto = new PostDto();
//		dto.setId(postSaved.getId());
//		dto.setComment(postSaved.getComment());
//		dto.setContent(postSaved.getContent());
//		dto.setDescription(postSaved.getDescription());
//		dto.setTitle(postSaved.getTitle());

		PostDto dto = MapToDto(postSaved);
		return dto;
	}

	// Dto To Entity.......................................................
	Post mapToEntity(PostDto postDto) {

		Post post = modelMapper.map(postDto, Post.class);
//		Post post = new Post();
//		post.setComment(postDto.getComment());
//		post.setContent(postDto.getContent());
//		post.setDescription(postDto.getDescription());
//		post.setTitle(postDto.getTitle());
		return post;
	}

	// ENtity To Dto...........................................
	PostDto MapToDto(Post post) {

		PostDto dto = modelMapper.map(post, PostDto.class);

//		PostDto dto = new PostDto();
//		dto.setId(post.getId());
//
//		dto.setComment(post.getComment());
//		dto.setContent(post.getContent());
//		dto.setDescription(post.getDescription());
//		dto.setTitle(post.getTitle());

		return dto;
	}

	// DeletingRecord..................................................
	public void deletePost(Long id) {

		// Delete the post
		postRepository.deleteById(id);
	}

	// FetchAllPost...............................
	@Override
	public List<PostDto> fetchAllPosts() {
		List<Post> posts = postRepository.findAll();

		// Covert List of post into List of postDto.......................
		List<PostDto> postDtos = posts.stream().map(post -> MapToDto(post)).collect(Collectors.toList());

		return postDtos;
	}

	// Fetch All Post Pegination...............................................
	@Override
	public List<PostDto> fetchAllPostsPegination(int pageNo, int pageSize) {

		// Create a Pageable object with page number and size
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);

		// Fetching Record From
		// database.................................................
		Page<Post> allposts = postRepository.findAll(pageRequest);

		// Converting this allPostOn per page into List of
		// post......................................
		List<Post> listOfPostContent = allposts.getContent();

		// Convert posts into dtos.................................
		List<PostDto> peginationDtos = listOfPostContent.stream().map(post -> MapToDto(post))
				.collect(Collectors.toList());
		return peginationDtos;
	}

	// Fetch All Post Pegination By
	// Sorting...............................................
	@Override
	public List<PostDto> fetchAllPostsPeginationBySorting(int pageNo, int pageSize, String sortBy) {

		// Creating Sort object Based on
		// requirement.......................................
		// Sort sort = Sort.by(Sort.Order.asc(sortBy));

		// Creating PageRequestObject..............................
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		// Fetching Data from Database by passing pagerequest Object....................
		Page<Post> all = postRepository.findAll(pageRequest);

		// Converting this page object into List...................................
		List<Post> content = all.getContent();

		// Convert it into Dtos..........................
		List<PostDto> dtos = content.stream().map(post -> MapToDto(post)).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public List<PostDto> fetchAllPostsPeginationBySortingByAscOrDesc(int pageNo, int pageSize, String sortBy,
			String sortDir) {
		
		// Here We are checking the value of sortDir by Ternary Operator..................................
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
		
		
		// Creating PageRequestObject..............................
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);

		// Fetching Data from Database by passing pagerequest Object....................
		Page<Post> all = postRepository.findAll(pageRequest);

		// Converting this page object into List...................................
		List<Post> content = all.getContent();

		// Convert it into Dtos..........................
		List<PostDto> dtos = content.stream().map(post -> MapToDto(post)).collect(Collectors.toList());
		return dtos;

	}
	


		// Find Post By Based on Your Requirement................
	@Override
	public PostDto findByComment(String comment) {
		Post findByComment = postRepository.findByComment(comment);
		return MapToDto(findByComment);
	}

	
	// Find Post By Based on Your Requirement................
	@Override
	public PostDto findByTitle(String title) {
		Post findByTitle = postRepository.findByTitle(title);
		
		return MapToDto(findByTitle);
	}

	
	
	@Override
	public PostDto findByCommentNative(String comment) {
		
		Post findByCommentNative = postRepository.findByCommentNative(comment);
		return MapToDto(findByCommentNative);
	}
	

	@Override
	public PostDto findByTitleNativeQuery(String title) {
		
		Post findByTitleNativeQuery = postRepository.findByTitleNativeQuery(title);
		return MapToDto(findByTitleNativeQuery);
	}

	
	
	
	
	
}
