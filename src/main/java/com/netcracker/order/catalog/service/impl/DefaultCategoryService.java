package com.netcracker.order.catalog.service.impl;

import com.netcracker.order.catalog.domain.Category;
import com.netcracker.order.catalog.repository.CategoryRepository;
import com.netcracker.order.catalog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ulza1116 on 8/18/2017.
 */
@Service
public class DefaultCategoryService implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public DefaultCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategory(int categoryId){
        return categoryRepository.findOne(categoryId);
    }

    @Override
    public void deleteCategory(int categoryId){
        categoryRepository.delete(categoryId);
    }

    @Override
    public void updateCategory(Category category, int categoryId) {
        Category category1 = categoryRepository.findOne(categoryId);
        category1.setName(category.getName());
        categoryRepository.save(category1);
    }

    @Override
    public List<Integer> createCategory(List<Category> categories){
        return categoryRepository.save(categories).stream().map(Category::getId).collect(Collectors.toList());
    }

}
