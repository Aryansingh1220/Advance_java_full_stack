package com.assignment.caseStudy;

import com.casestudy.product.entity.Category;
import com.casestudy.product.exception.CategoryNotFoundException;
import com.casestudy.product.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repo;

    public CategoryServiceImpl(CategoryRepository repo) {
        this.repo = repo;
    }

    public Category createCategory(Category category) {
        return repo.save(category);
    }

    public List<Category> getAllCategories() {
        return repo.findAll();
    }

    public Category getCategory(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));
    }

    public void deleteCategory(Long id) {
        repo.deleteById(id);
    }
}