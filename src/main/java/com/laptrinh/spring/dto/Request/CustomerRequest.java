package com.laptrinh.spring.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    private String username;
    private String password;
}
