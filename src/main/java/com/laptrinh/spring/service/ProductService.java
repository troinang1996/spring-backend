package com.laptrinh.spring.service;

import com.laptrinh.spring.dto.BaseDto;
import com.laptrinh.spring.dto.Request.ProductRequest;
import com.laptrinh.spring.dto.Response.CustomerResponse;
import com.laptrinh.spring.dto.Response.ProductResponse;
import com.laptrinh.spring.entity.Category;
import com.laptrinh.spring.entity.Customer;
import com.laptrinh.spring.entity.Product;
import com.laptrinh.spring.responsitory.CategoryReponsitory;
import com.laptrinh.spring.responsitory.ProductReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductReponsitory productReponsitory;
    @Autowired
    CategoryReponsitory categoryReponsitory;

    public List<ProductResponse> getAllProductByCategoryId(Integer id) {
        List<ProductResponse> productResponseList = new ArrayList<>();
        Category category = categoryReponsitory.findCategoryById(id);
        List<Product> productList = category.getProducts();
        productList.stream().forEach(x -> {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(x.getId());
            productResponse.setProductDate(x.getProductDate());
            productResponse.setAvailable(x.getAvailable());
            productResponse.setName(x.getName());
            productResponse.setImage(x.getImage());
            productResponse.setUnitPrice(x.getUnitPrice());
            productResponse.setDiscount(x.getDiscount());
            productResponse.setDescription(x.getDescription());
            productResponse.setViewCount(x.getViewCount());
            productResponse.setQuantity(x.getQuantity());
            productResponseList.add(productResponse);
        });
        return productResponseList;
    }

    public ProductResponse[] getAll() {
        List<ProductResponse> responses = new ArrayList<>();
        List<Product> products = productReponsitory.getAllProducts();
        if (products != null) {
            products.stream().forEach(x -> {
                ProductResponse productReponse = new ProductResponse();
                productReponse.setId(x.getId());
                productReponse.setProductDate(x.getProductDate());
                productReponse.setAvailable(x.getAvailable());
                productReponse.setName(x.getName());
                productReponse.setImage(x.getImage());
                productReponse.setUnitPrice(x.getUnitPrice());
                productReponse.setDiscount(x.getDiscount());
                productReponse.setDescription(x.getDescription());
                productReponse.setViewCount(x.getViewCount());
                productReponse.setQuantity(x.getQuantity());
                if (x.getCategory() != null) {

                    productReponse.setCategory(x.getCategory());
                }
                responses.add(productReponse);
            });
        }
        if (responses != null) {
            return responses.stream().toArray(ProductResponse[]::new);
        }
        return null;
    }

    public ProductResponse findProductById(Integer id) {
        Product product = productReponsitory.findProductById(id);
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setDiscount(product.getDiscount());
        productResponse.setProductDate(product.getProductDate());
        productResponse.setAvailable(product.getAvailable());
        productResponse.setDescription(product.getDescription());
        productResponse.setImage(product.getImage());
        productResponse.setQuantity(product.getQuantity());
        productResponse.setUnitPrice(product.getUnitPrice());
        productResponse.setViewCount(product.getViewCount());
        productResponse.setCategory(product.getCategory());
        return productResponse;
    }
    public BaseDto updateProduct(ProductRequest productRequest){
        Product product = new Product();
        product.setId(productRequest.getId());
        product.setName(productRequest.getName());
        product.setDiscount(productRequest.getDiscount());
        product.setProductDate(productRequest.getProductDate());
        product.setAvailable(productRequest.getAvailable());
        product.setDescription(productRequest.getDescription());
        product.setImage(productRequest.getImage());
        product.setQuantity(productRequest.getQuantity());
        product.setUnitPrice(productRequest.getUnitPrice());
        product.setViewCount(productRequest.getViewCount());
        product.setCategory(productRequest.getCategory());
        String s = productReponsitory.updateProduct(product);
        BaseDto baseDto = new BaseDto();
        baseDto.setMessage(s);
        return baseDto;
    }
    public BaseDto addProduct(ProductRequest productRequest){
        Product product = new Product();
        product.setId(productRequest.getId());
        product.setName(productRequest.getName());
        product.setDiscount(productRequest.getDiscount());
        product.setProductDate(productRequest.getProductDate());
        product.setAvailable(productRequest.getAvailable());
        product.setDescription(productRequest.getDescription());
        product.setImage(productRequest.getImage());
        product.setQuantity(productRequest.getQuantity());
        product.setUnitPrice(productRequest.getUnitPrice());
        product.setViewCount(productRequest.getViewCount());
        product.setCategory(productRequest.getCategory());
        String s = productReponsitory.addProduct(product);
        BaseDto baseDto = new BaseDto();
        baseDto.setMessage(s);
        return baseDto;
    }
    public BaseDto deleteProduct(Integer id) {
        BaseDto baseDto = new BaseDto();
        Product product = new Product();
        product.setId(id);
        String result = productReponsitory.deleteProduct(product);
        baseDto.setMessage(result);
        return baseDto;
    }
}
