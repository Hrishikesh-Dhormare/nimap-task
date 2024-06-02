package com.nimap.project.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductRequest {

    @NotEmpty(message = "Product title cannot be empty")
    private String title;

    @NotEmpty(message = "Product description cannot be empty")
    private String description;

    @NotNull
    @Min(value = 1,message = "Product price must be greater than 0")
    private Double price;

    @NotEmpty(message = "Product category cannot be empty")
    private String category;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

}