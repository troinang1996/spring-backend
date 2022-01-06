package com.laptrinh.spring.dto.Response;

import com.laptrinh.spring.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse extends BaseDto {
    private Integer  id;
    private String  name;
    private String  nameVN;
}
