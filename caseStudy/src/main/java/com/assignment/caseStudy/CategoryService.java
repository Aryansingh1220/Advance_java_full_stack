package com.assignment.caseStudy;



import com.assignment.caseStudy.product.entity.Category;
import java.util.List;

public interface CategoryService {

    Category createCategory(Category category);

    List<Category> getAllCategories();

    Category getCategory(Long id);

    void deleteCategory(Long id);
}