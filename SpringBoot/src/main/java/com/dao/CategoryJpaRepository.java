package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dto.Category;


public interface CategoryJpaRepository extends JpaRepository<Category, Integer>{

}