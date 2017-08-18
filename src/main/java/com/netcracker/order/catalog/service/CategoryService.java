package com.netcracker.order.catalog.service;

import com.netcracker.order.catalog.domain.Category;
import com.netcracker.order.catalog.service.exception.CategoryNotFoundException;

/**
 * Created by ulza1116 on 8/18/2017.
 */
public interface CategoryService {
    void createCategory(Category category);

    Category getCategory(int categoryId);

    void deleteCategory(int categoryId);

    void updateCategory(Category category) throws CategoryNotFoundException;
}
