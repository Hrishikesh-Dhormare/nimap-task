package com.nimap.project.controller;
import java.util.List;

import com.nimap.project.model.Category;
import com.nimap.project.request.CategoryRequest;
import com.nimap.project.response.AppResponse;
import com.nimap.project.response.CategoryResponse;
import com.nimap.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("")
    public ResponseEntity createNewCategory(@Validated @RequestBody CategoryRequest req) {
        String message = categoryService.addNewCategory(req);
        AppResponse res = new AppResponse();
        res.setMessage(message);
        res.setStatus(true);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @GetMapping("")
    public ResponseEntity getAllCategories(@RequestParam(defaultValue = "0",required = false) Integer page){

        CategoryResponse catResponse= categoryService.getAllCategories(page);
        return ResponseEntity.status(HttpStatus.OK).body(catResponse);
    }

    @PutMapping("/{di}")
    public ResponseEntity updateCategory(@Validated @RequestBody CategoryRequest c, @PathVariable(name = "di") Integer categoryId) {
        String message = categoryService.updateCategory(c, categoryId);
        AppResponse res = new AppResponse();
        res.setMessage(message);
        res.setStatus(true);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @DeleteMapping("/{di}")
    public ResponseEntity deleteCategory(@PathVariable(name = "di") Integer categoryId) {
        String message = categoryService.deleteCategory(categoryId);
        AppResponse res = new AppResponse();
        res.setMessage(message);
        res.setStatus(true);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @GetMapping("/{di}")
    public ResponseEntity getCategoryById(@PathVariable(name = "di") Integer categoryId) {
        Category category =  categoryService.findCategoryById(categoryId);
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }
}
