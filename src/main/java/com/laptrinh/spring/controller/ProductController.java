package com.laptrinh.spring.controller;

import com.laptrinh.spring.dto.BaseDto;
import com.laptrinh.spring.dto.Request.CustomerRequest;
import com.laptrinh.spring.dto.Request.ProductRequest;
import com.laptrinh.spring.dto.Response.CustomerResponse;
import com.laptrinh.spring.dto.Response.ProductResponse;
import com.laptrinh.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/{getid}")
    public ResponseEntity<ProductResponse[]> getAllProductByCategoryId (@PathVariable("getid") Integer id){
        System.out.println(id);
        List<ProductResponse> productResponseList = productService.getAllProductByCategoryId(id);
        ProductResponse[] result = null;
        result = productResponseList.stream().toArray(ProductResponse[]::new);
        return ResponseEntity.ok().body(result);
    }
    @RequestMapping("/getall")
    public ResponseEntity<ProductResponse[]> getAll(){
        return ResponseEntity.ok().body(productService.getAll());
    }
    @PostMapping("/create")
    public ResponseEntity<BaseDto> addProduct (@RequestBody ProductRequest productRequest){
        BaseDto baseDto =productService.addProduct(productRequest);
        return ResponseEntity.ok(baseDto);
    }
    @GetMapping("/edit/")
    public ResponseEntity<ProductResponse> editProduct(@RequestParam("id") Integer id){
        ProductResponse productResponse = new ProductResponse();
        if (id == null) {
            return ResponseEntity.ok().body(null);
        } else {
            productResponse = productService.findProductById(id);
        }
        return ResponseEntity.ok().body(productResponse);
    }
    @PostMapping("/update")
    public ResponseEntity<BaseDto> updateProduct(@RequestBody ProductRequest productRequest){
        BaseDto baseDto = new BaseDto();
        baseDto = productService.updateProduct(productRequest);
        return ResponseEntity.ok(baseDto);
    }
    @GetMapping("/delete")
    public ResponseEntity<BaseDto> delete(@RequestParam("id") Integer id) {
        BaseDto baseDto = productService.deleteProduct(id);
        return ResponseEntity.ok().body(baseDto);
    }






}
