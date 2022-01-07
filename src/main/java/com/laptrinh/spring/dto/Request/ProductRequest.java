package com.laptrinh.spring.dto.Request;

import com.laptrinh.spring.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private Integer id;

    private String name;

    private String image;

    private Double unitPrice;

    private Double discount;

    private Integer quantity;


    private Date productDate;

    private Boolean available;


    Category category;


    private String description;

    private Integer viewCount;
}
