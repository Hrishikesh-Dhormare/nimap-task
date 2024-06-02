package com.nimap.project.request;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


public class CategoryRequest {

    @NotEmpty(message = "Category name cannot be empty")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}