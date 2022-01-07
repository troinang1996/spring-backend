package com.laptrinh.spring.controller;

import com.laptrinh.spring.dto.BaseDto;
import com.laptrinh.spring.dto.Request.CustomerRequest;
import com.laptrinh.spring.dto.Request.ProductRequest;
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
    public ResponseEntity<CustomerResponse[]> getallCustomer(){
        return ResponseEntity.ok().body(accountService.getAll());
    }
    @GetMapping("edit/")
    public ResponseEntity<CustomerResponse> editCustomer(@RequestParam("id") Integer id){
        CustomerResponse customerResponse = new CustomerResponse();
        if (id == null) {
            return ResponseEntity.ok().body(null);
        } else {
            customerResponse = accountService.findCustomerById(id);
        }
        return ResponseEntity.ok().body(customerResponse);

    }
    @PostMapping("update")
    public ResponseEntity<BaseDto> updateCustomer(@RequestBody CustomerRequest customerRequest){
        BaseDto baseDto = new BaseDto();
        baseDto = accountService.updateCustomer(customerRequest);
        return ResponseEntity.ok(baseDto);
    }
    @GetMapping("delete")
    public ResponseEntity<BaseDto> delete(@RequestParam("id") String id) {
        BaseDto baseDto = accountService.deleteCustomer(id);
        return ResponseEntity.ok().body(baseDto);
    }
    @PostMapping("/create")
    public ResponseEntity<BaseDto> addCustomer (@RequestBody CustomerRequest customerRequest) {
        BaseDto baseDto = accountService.addCustomer(customerRequest);
        return ResponseEntity.ok(baseDto);
    }

}
