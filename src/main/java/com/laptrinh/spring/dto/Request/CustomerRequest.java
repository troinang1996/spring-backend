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
    private String fullName;
    private String email;
    private String photo;
    private Boolean activated ;


    private Boolean admin ;
}
