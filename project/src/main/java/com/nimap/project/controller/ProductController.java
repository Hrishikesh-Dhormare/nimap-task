package com.nimap.project.controller;

import java.util.List;

import com.nimap.project.model.Product;
import com.nimap.project.request.ProductRequest;
import com.nimap.project.response.AppResponse;
import com.nimap.project.response.ProductResponse;
import com.nimap.project.service.ProductService;
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
@RequestMapping(path = "/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping("")
    public ResponseEntity createNewProduct(@Validated @RequestBody ProductRequest req) {
        String message = productService.addNewProduct(req);
        AppResponse res = new AppResponse();
        res.setMessage(message);
        res.setStatus(true);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @GetMapping("")
    public ResponseEntity getAllProducts(@RequestParam(defaultValue = "0",required = false) Integer page){

        ProductResponse pr = productService.getAllProducts(page);
        return ResponseEntity.status(HttpStatus.OK).body(pr);
    }

    @PutMapping("/{di}")
    public ResponseEntity updateProduct(@Validated @RequestBody ProductRequest p, @PathVariable(name = "di") Integer productId) {
        String message = productService.updateProduct(p, productId);
        AppResponse res = new AppResponse();
        res.setMessage(message);
        res.setStatus(true);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @DeleteMapping("/{di}")
    public ResponseEntity deleteProduct(@PathVariable(name = "di") Integer productId) {
        String message = productService.deleteProduct(productId);
        AppResponse res = new AppResponse();
        res.setMessage(message);
        res.setStatus(true);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @GetMapping("/{di}")
    public ResponseEntity getProductById(@PathVariable(name = "di") Integer productId) {
        Product product =  productService.findProductById(productId);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
}