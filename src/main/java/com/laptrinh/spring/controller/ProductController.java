package com.laptrinh.spring.controller;

import com.laptrinh.spring.dto.Response.ProductResponse;
import com.laptrinh.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/{getid}")
    public ResponseEntity<ProductResponse[]> getAllProductById (@PathVariable("getid") Integer id){
        System.out.println(id);
        List<ProductResponse> productResponseList = productService.getAllProductById(id);
        ProductResponse[] result = null;
        result = productResponseList.stream().toArray(ProductResponse[]::new);
        return ResponseEntity.ok().body(result);
    }
    @RequestMapping("/getall")
    public ResponseEntity<ProductResponse[]> getAll(){
        return ResponseEntity.ok().body(productService.getAll());
    }


}
