package com.nimap.project.service;

import java.util.List;
import java.util.Optional;

import com.nimap.project.exception.CustomException;
import com.nimap.project.model.Category;
import com.nimap.project.model.Product;
import com.nimap.project.repository.ProductRepo;
import com.nimap.project.request.ProductRequest;
import com.nimap.project.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryService categoryService;

    public String addNewProduct(ProductRequest product) {
        Product existingProduct = productRepo.findProductByName(product.getTitle());
        if(existingProduct != null)
            throw new CustomException("Product already exists");
        Product newProduct = new Product();
        newProduct.setTitle(product.getTitle());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        Category category = categoryService.findCategoryByName(product.getCategory());
        if(category == null)
            throw new CustomException("Catgory does not exist");
        newProduct.setCategory(category);
        productRepo.save(newProduct);
        return "Product added successfully";
    }

    public ProductResponse getAllProducts(Integer page){
        Pageable p = PageRequest.of(page, 5);
        Page<Product> pageProducts =  productRepo.findAll(p);
        List<Product> products = pageProducts.getContent();

        ProductResponse pr = new ProductResponse();
        pr.setContent(products);
        pr.setPageNumber(pageProducts.getNumber());
        pr.setPageSize(pageProducts.getSize());
        pr.setTotalElements(pageProducts.getTotalElements());
        pr.setTotalPages(pageProducts.getTotalPages());
        pr.setIslastPage(pageProducts.isLast());
        return pr;
    }

    public String updateProduct(ProductRequest product,Integer productId) {
        Optional<Product> optProduct = productRepo.findById(productId);
        if(optProduct.isEmpty())
            throw new CustomException("Invalid product id");
        Product newProduct = optProduct.get();
        newProduct.setTitle(product.getTitle());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        Category category = categoryService.findCategoryByName(product.getCategory());
        if(category == null)
            throw new CustomException("Catgory does not exist");
        newProduct.setCategory(category);
        productRepo.saveAndFlush(newProduct);
        return "Product updated successfully";
    }

    public String deleteProduct(Integer productId) {
        Optional<Product> optProduct = productRepo.findById(productId);
        if(optProduct.isEmpty())
            throw new CustomException("Invalid product id");
        Product product = optProduct.get();
        productRepo.delete(product);
        return "Product deleted successfully";
    }


    public Product findProductById(Integer productId) {
        if(productId==null)
            throw new CustomException("Product id not received");
        Optional<Product> optProduct = productRepo.findById(productId);
        if(optProduct.isEmpty())
            throw new CustomException("Product does not exists");
        return optProduct.get();
    }
}
