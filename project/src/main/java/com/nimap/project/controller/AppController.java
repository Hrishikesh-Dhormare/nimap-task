package com.nimap.project.controller;

import com.nimap.project.response.AppResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/")
    public ResponseEntity<AppResponse> homeController(){

        AppResponse res=new AppResponse("Welcome To E-Commerce System", true);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
