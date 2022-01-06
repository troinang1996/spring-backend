package com.laptrinh.spring.dto.Response;

import com.laptrinh.spring.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor

public class CustomerResponse extends BaseDto {
//    private String username;
//    private String password;
public CustomerResponse(){
    super();
}
    public CustomerResponse(String message){
        this.setMessage(message);
    }

    private String username;
    private String passWord;
    private String fullName;
    private String email;
    private String photo;
    private Boolean activated ;


    private Boolean admin ;
}
