package com.nimap.project.repository;

import com.nimap.project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
    @Query("select C from Category C where C.name =: name")
    Category findCategoryByName(String name);
}
