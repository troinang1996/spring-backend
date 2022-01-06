package com.laptrinh.spring.controller;

import com.laptrinh.spring.dto.Request.CustomerRequest;
import com.laptrinh.spring.dto.Response.CustomerResponse;
import com.laptrinh.spring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/account/")
public class AccountController {
@Autowired
private AccountService accountService;

    @ResponseBody
    @PostMapping("login")
    public ResponseEntity<CustomerResponse> login(@RequestBody CustomerRequest customerRequest){
        if("".equals(customerRequest.getUsername()) || "".equals(customerRequest.getPassword())){

        }
        CustomerResponse respone =null;
        respone =   accountService.findByUsername(customerRequest.getUsername());
        System.out.println(" test chay " + respone);

        return ResponseEntity.ok().body(respone);

    }
    @GetMapping("getall")
    public CustomerResponse getallCustomer(){

        return null;
    }
    @GetMapping("getall")
    public ResponseEntity<CustomerResponse[]> getallCustomer(){
        return ResponseEntity.ok().body(accountService.getAll());
    }
}
