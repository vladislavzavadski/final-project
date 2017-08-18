package com.netcracker.order.catalog.service.impl;

import com.netcracker.order.catalog.domain.Category;
import com.netcracker.order.catalog.repository.CategoryRepository;
import com.netcracker.order.catalog.service.CategoryService;
import com.netcracker.order.catalog.service.exception.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void updateCategory(Category category) throws CategoryNotFoundException {

        if(!categoryRepository.exists(category.getId())){
            throw new CategoryNotFoundException("Category with id="+category.getId()+" was not found");
        }

        categoryRepository.save(category);
    }

}
