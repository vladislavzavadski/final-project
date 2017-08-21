package com.netcracker.order.catalog.service.impl;

import com.netcracker.order.catalog.domain.Category;
import com.netcracker.order.catalog.repository.CategoryRepository;
import com.netcracker.order.catalog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void createCategory(Category category){
        categoryRepository.save(category);
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
        Category category1 = categoryRepository.getOne(categoryId);
        category1.setName(category.getName());
        categoryRepository.save(category1);
    }

    @Override
    public void createCategory(List<Category> categories){
        categoryRepository.save(categories);
    }

}
