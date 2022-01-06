package com.laptrinh.spring.controller;

import com.laptrinh.spring.dto.BaseDto;
import com.laptrinh.spring.dto.Request.CategoryRequest;
import com.laptrinh.spring.dto.Response.CategoryResponse;
import com.laptrinh.spring.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/index")
    public ResponseEntity<CategoryResponse[]> login() {
        List<CategoryResponse> categoryResponseList = categoryService.getAllCategory();

        CategoryResponse[] result = null;
        result = categoryResponseList.stream().toArray(CategoryResponse[]::new);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/addition")
    public ResponseEntity<BaseDto> addition(@RequestBody CategoryRequest categoryRequest) {
        BaseDto baseDto = categoryService.insertCategory(categoryRequest);
        return ResponseEntity.ok().body(baseDto);
    }

    @GetMapping("/delete")
    public ResponseEntity<BaseDto> delete(@RequestParam("id") Integer id) {
        BaseDto baseDto = categoryService.deleteCategory(id);
        return ResponseEntity.ok().body(baseDto);
    }

    @GetMapping("/edit")
    public ResponseEntity<CategoryResponse> findCategoryById(@RequestParam("id") Integer id) {
        CategoryResponse categoryResponse = null;
        if (id == null) {
            return ResponseEntity.ok().body(null);
        } else {
            categoryResponse = categoryService.findCategoryById(id);
        }
        return ResponseEntity.ok().body(categoryResponse);
    }
    @PostMapping("/update")
    public ResponseEntity<BaseDto> update (@RequestBody CategoryRequest categoryRequest ){
        System.out.println(categoryRequest.getName() + categoryRequest.getNameVN() + categoryRequest.getId());
        BaseDto baseDto = categoryService.updateCategory(categoryRequest);
         return ResponseEntity.ok().body(baseDto);
    }

}
