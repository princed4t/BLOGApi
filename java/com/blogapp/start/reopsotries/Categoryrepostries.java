package com.blogapp.start.reopsotries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.start.entities.Category;

public interface Categoryrepostries extends JpaRepository<Category, Integer> {

}
