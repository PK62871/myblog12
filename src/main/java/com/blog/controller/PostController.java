package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.PostDto;
import com.blog.service.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/post")
public class PostController {

	@Autowired
	private PostService postService;

	// Create Post.........................................

	// URL :- http://localhost:8080/api/post/createPost .........................

	@PostMapping("/createPost")
	public ResponseEntity<?> createPost(@Valid @RequestBody PostDto postDto, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		PostDto createPost = postService.createPost(postDto);
		return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);

	}

	// Delete a
	// Post............................................................................

	// URL :- http://localhost:8080/api/post/deletePost/1 .........................

	@DeleteMapping("/deletePost/{id}")
	public ResponseEntity<String> deletePost(@PathVariable Long id) {

		postService.deletePost(id);
		return new ResponseEntity<String>("Post Deleted SuccessFully", HttpStatus.OK);

	}

	// Get All
	// Posts...................................................................
	// URL :- http://localhost:8080/api/post/fetchAllPosts ........................

	@GetMapping("/fetchAllPosts")
	public ResponseEntity<List<PostDto>> fetchAllPosts() {
		List<PostDto> allPosts = postService.fetchAllPosts();
		return new ResponseEntity<>(allPosts, HttpStatus.OK);

	}

	// URL :- http://localhost:8080/api/post/pagination?pageNo=0&pageSize=4
	// Pegination Concept....................................................
	@GetMapping("/pagination")
	public ResponseEntity<List<PostDto>> fetchAllPostsPagination(
			@RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
			@RequestParam(name = "pageSize", defaultValue = "4") int pageSize) {

		List<PostDto> fetchAllPostsPegination = postService.fetchAllPostsPegination(pageNo, pageSize);
		return new ResponseEntity<>(fetchAllPostsPegination, HttpStatus.OK);
	}

	// URL :-
	// http://localhost:8080/api/post/sortBy?pageNo=0&pageSize=4&sortBy=comment

	// Pegination ConceptSortBy....................................................
	@GetMapping("/sortBy")
	public ResponseEntity<List<PostDto>> fetchAllPostsPaginationBySorting(
			@RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
			@RequestParam(name = "pageSize", defaultValue = "4") int pageSize,
			@RequestParam(name = "sortBy", defaultValue = "id", required = false) String sortBy) {

		List<PostDto> result = postService.fetchAllPostsPeginationBySorting(pageNo, pageSize, sortBy);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	// URL :-
	// http://localhost:8080/api/post/sortByDir?pageNo=0&pageSize=4&sortBy=comment&sortDir=asc/desc

	// Pegination ConceptSortBy....................................................
	@GetMapping("/sortByDir")
	public ResponseEntity<List<PostDto>> fetchAllPostsPaginationBySortingByAscorDesc(
			@RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
			@RequestParam(name = "pageSize", defaultValue = "4") int pageSize,
			@RequestParam(name = "sortBy", defaultValue = "id", required = false) String sortBy,
			@RequestParam(name = "sortDir", defaultValue = "id", required = false) String sortDir

	) {

		List<PostDto> allPostsPeginationBySorting = postService.fetchAllPostsPeginationBySortingByAscOrDesc(pageNo,
				pageSize, sortBy, sortDir);

		return new ResponseEntity<>(allPostsPeginationBySorting, HttpStatus.OK);
	}

	// Finding Post BAsed On
	// Comment....................................................
	// URL:-
	// http://localhost:8080/api/post/{Comment_Value}........................................

//	@GetMapping("/{comment}")
//	public ResponseEntity<PostDto> findPostByComment(@PathVariable("comment") String comment){
//		
//		PostDto findByComment = postService.findByComment(comment);
//		return new ResponseEntity<>(findByComment,HttpStatus.OK);
//		
//	}

	// Finding Post BAsed On
	// Title....................................................
	// URL:-
	// http://localhost:8080/api/post/{title_Value}.......................................

	@GetMapping("/{title}")
	public ResponseEntity<PostDto> findPostByTitle(@PathVariable("title") String title) {

		PostDto findByTitle = postService.findByTitle(title);
		return new ResponseEntity<>(findByTitle, HttpStatus.OK);

	}
	
	/*
	 * Native Query Method.......................................................
	 */
	@GetMapping("/native/{comment}")
	public ResponseEntity<PostDto> findingPostByComment(@PathVariable("comment") String comment){
		
		PostDto findByCommentNative = postService.findByCommentNative(comment);
		return new ResponseEntity<PostDto>(findByCommentNative,HttpStatus.OK);
	}
	
	
	@GetMapping("/nativeTitle/{title}")
	public ResponseEntity<PostDto> getPostByTitle(@PathVariable("title") String title){
		
		PostDto postDto = postService.findByTitleNativeQuery(title);
		return new ResponseEntity<PostDto>(postDto,HttpStatus.OK);
	}
}
