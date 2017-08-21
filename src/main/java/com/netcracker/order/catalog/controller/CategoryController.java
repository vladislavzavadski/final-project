package com.netcracker.order.catalog.controller;

import com.netcracker.order.catalog.domain.Category;
import com.netcracker.order.catalog.service.CategoryService;
import com.netcracker.order.catalog.service.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ulza1116 on 8/18/2017.
 */
@RestController
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public void createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
    }

    @RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
    public Category getCategory(@PathVariable("categoryId") int categoryId){
        return categoryService.getCategory(categoryId);
    }

    @RequestMapping(value = "/category/{categoryId}", method = RequestMethod.DELETE)
    public void deleteCategory(@PathVariable("categoryId") int categoryId){
        categoryService.deleteCategory(categoryId);
    }

    @RequestMapping(value = "/category", method = RequestMethod.PUT)
    public void updateCategory(@RequestBody Category category) throws EntityNotFoundException {
        categoryService.updateCategory(category, );
    }

    @RequestMapping(value = "/category/list", method = RequestMethod.POST)
    public void createCategory(@RequestBody List<Category> categories){
        categoryService.createCategory(categories);
    }

}
