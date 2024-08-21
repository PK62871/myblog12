package com.blog.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostDto {

	private Long id;

	@NotNull(message = "Content must not be null")
	@NotEmpty(message = "Content must not be empty")
	@Size(min = 2, message = "Content must be at least 2 characters long")
	private String content;

	@NotEmpty(message = "Description must not be empty")
	@Size(min = 2, message = "Description must be at least 2 characters long")
	private String description;

	@NotEmpty(message = "Comment must not be empty")
	@Size(min = 3, message = "Comment must be at least 3 characters long")
	private String comment;

	@NotEmpty(message = "Title must not be empty")
	@Size(min = 3, message = "Title must be at least 3 characters long")
	private String title;

}
