package com.netcracker.order.catalog.service;

import com.netcracker.order.catalog.domain.Category;

import java.util.List;

/**
 * Created by ulza1116 on 8/18/2017.
 */
public interface CategoryService {
    Category createCategory(Category category);

    Category getCategory(int categoryId);

    void deleteCategory(int categoryId);

    void updateCategory(Category category, int categoryId);

    List<Integer> createCategory(List<Category> categories);
}
