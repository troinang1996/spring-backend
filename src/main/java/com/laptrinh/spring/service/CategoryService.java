package com.laptrinh.spring.service;

import com.laptrinh.spring.dto.BaseDto;
import com.laptrinh.spring.dto.Request.CategoryRequest;
import com.laptrinh.spring.dto.Response.CategoryResponse;
import com.laptrinh.spring.entity.Category;
import com.laptrinh.spring.responsitory.CategoryReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryReponsitory categoryReponsitory;

    public List<CategoryResponse> getAllCategory() {
        List<CategoryResponse> response = new ArrayList<>();
        List<Category> categories = categoryReponsitory.getAllCategory();
        categories.stream().forEach(x -> {
                    CategoryResponse categoryResponse = new CategoryResponse();
                    categoryResponse.setId(x.getId());
                    categoryResponse.setName(x.getName());
                    categoryResponse.setNameVN(x.getNameVN());
                    response.add(categoryResponse);
                }
        );
        return response;
    }
    public BaseDto insertCategory(CategoryRequest categoryRequest){
        BaseDto baseDto =new BaseDto();
        Category category = new Category();
        category.setName(categoryRequest.getName());
        category.setNameVN(categoryRequest.getNameVN());
        String result = categoryReponsitory.insertCategory(category);
        baseDto.setMessage(result);
        return baseDto;
    }
    public BaseDto deleteCategory(Integer id){
        BaseDto baseDto =new BaseDto();
        Category category = new Category();
        category.setId(id);
        String result = categoryReponsitory.deleteCategory(category);
        baseDto.setMessage(result);
        return baseDto;
    }
    public CategoryResponse findCategoryById (Integer id){
        Category category = categoryReponsitory.findCategoryById(id);
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(category.getId());
        categoryResponse.setName(category.getName());
        categoryResponse.setNameVN(category.getNameVN());
        return categoryResponse;
    }
    public BaseDto updateCategory(CategoryRequest categoryRequest){
        BaseDto baseDto = new BaseDto();
        Category category= new Category();
        category.setId(categoryRequest.getId());
        category.setName(categoryRequest.getName());
        category.setNameVN(categoryRequest.getNameVN());
        String result = categoryReponsitory.updateCategory(category);
        baseDto.setMessage(result);
        return baseDto;
    }
}
