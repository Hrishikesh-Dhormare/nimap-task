package com.nimap.project.service;

import java.util.List;
import java.util.Optional;

import com.nimap.project.exception.CustomException;
import com.nimap.project.model.Category;
import com.nimap.project.repository.CategoryRepo;
import com.nimap.project.request.CategoryRequest;
import com.nimap.project.response.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;


    public String addNewCategory(CategoryRequest c) {
        //check forn existing category
        Category existingCategory = categoryRepo.findCategoryByName(c.getName());
        if(existingCategory != null)
            throw new CustomException("Category already exists with this name");
        Category category = new Category();
        category.setName(c.getName());
        categoryRepo.save(category);
        return "Category added successfully";
    }

    public CategoryResponse getAllCategories(Integer page){
        org.springframework.data.domain.Pageable  p = PageRequest.of(page, 2);
        Page<Category> pageCategories =  categoryRepo.findAll(p);
        List<Category> categories = pageCategories.getContent();

        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categories);
        categoryResponse.setPageNumber(pageCategories.getNumber());
        categoryResponse.setPageSize(pageCategories.getSize());
        categoryResponse.setTotalPages(pageCategories.getTotalPages());
        categoryResponse.setTotalElements(pageCategories.getTotalElements());
        categoryResponse.setIslastPage(pageCategories.isLast());
        return categoryResponse;
    }

    public Category findCategoryByName(String name) {
        if(name=="")
            throw new CustomException("Category name not received");
        Category category = categoryRepo.findCategoryByName(name);
        if(category == null)
            throw new CustomException("Category does not exists with this name");
        return category;
    }

    public String updateCategory(CategoryRequest c, Integer categoryId) {
        Optional<Category> optCategory = categoryRepo.findById(categoryId);
        if(optCategory.isEmpty())
            throw new CustomException("Invalid category id");
        Category category = optCategory.get();
        category.setName(c.getName());
        categoryRepo.saveAndFlush(category);
        return "Category updated successfully";
    }

    public String deleteCategory(Integer categoryId) {
        Optional<Category> optCategory = categoryRepo.findById(categoryId);
        if(optCategory.isEmpty())
            throw new CustomException("Invalid category id");
        Category category = optCategory.get();
        categoryRepo.delete(category);
        return "Category deleted successfully";
    }

    public Category findCategoryById(Integer categoryId) {
        if(categoryId==null)
            throw new CustomException("Category id not received");
        Optional<Category> optCategory = categoryRepo.findById(categoryId);
        if(optCategory.isEmpty())
            throw new CustomException("Category does not exists with this id");
        return optCategory.get();
    }
}