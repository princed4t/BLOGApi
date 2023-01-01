package com.blogapp.start.reopsotries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.blogapp.start.entities.Category;
import com.blogapp.start.entities.Post;
import com.blogapp.start.entities.User;

public interface PostReposotries extends JpaRepository<Post, Integer>,PagingAndSortingRepository<Post, Integer>{
  public List<Post> findByUser(User user);
  public List<Category> findByCategory(Category category);
	
	
}
