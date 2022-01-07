package com.laptrinh.spring.service;

import com.laptrinh.spring.dto.BaseDto;
import com.laptrinh.spring.dto.Request.CategoryRequest;
import com.laptrinh.spring.dto.Request.CustomerRequest;
import com.laptrinh.spring.dto.Request.ProductRequest;
import com.laptrinh.spring.dto.Response.CustomerResponse;
import com.laptrinh.spring.entity.Customer;
import com.laptrinh.spring.entity.Product;
import com.laptrinh.spring.responsitory.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public CustomerResponse findByUsername(String username) {
        CustomerResponse customerResponse = new CustomerResponse();
        Customer customer = accountRepository.findByUsername(username);
        if (customer != null && customer.getId().length() > 0) {
            customerResponse.setUsername(customer.getId());
            customerResponse.setPassWord(customer.getPassword());
            customerResponse.setMessage("success");
        } else { // trường hợp thất bại
            customerResponse = new CustomerResponse("fail");
        }
        return customerResponse;
    }
    public CustomerResponse[] getAll(){
        List<CustomerResponse> customerResponseList = new ArrayList<>();
        List<Customer> customerList = accountRepository.getAll();
        customerList.stream().forEach(x->{
            CustomerResponse customerResponse = new CustomerResponse();
            customerResponse.setUsername(x.getId());
            customerResponse.setPassWord(x.getPassword());
            customerResponse.setFullName(x.getFullName());
            customerResponse.setEmail(x.getEmail());
            customerResponse.setActivated(x.getActivated());
            customerResponse.setAdmin(x.getAdmin());
            customerResponse.setPhoto(x.getPhoto());
            customerResponseList.add(customerResponse);
        });
        if(customerList != null){
        return customerResponseList.stream().toArray(CustomerResponse[]::new);}
        else {
            return null;
        }

    }
    public BaseDto updateCustomer(CustomerRequest customerRequest){
        Customer customer = new Customer();
        customer.setId(customerRequest.getUsername());
        customer.setPassword(customerRequest.getPassword());
        customer.setEmail(customerRequest.getEmail());
        customer.setFullName(customerRequest.getFullName());
        customer.setPhoto(customerRequest.getPhoto());
        customer.setActivated(customerRequest.getActivated());
        customer.setAdmin(customerRequest.getAdmin());
        String s = accountRepository.updateCustomer(customer);
        BaseDto baseDto = new BaseDto();
        baseDto.setMessage(s);
        return baseDto;
    }
    public CustomerResponse findCustomerById (Integer id){
        Customer customer = new Customer();
        customer = accountRepository.findCustomerById(id);
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setUsername(customer.getId());
        customerResponse.setPassWord(customer.getPassword());
        customerResponse.setEmail(customer.getEmail());
        customerResponse.setFullName(customer.getFullName());
        customerResponse.setPhoto(customer.getPhoto());
        customerResponse.setActivated(customer.getActivated());
        customerResponse.setAdmin(customer.getAdmin());
        return  customerResponse;

    }
    public BaseDto deleteCustomer(String id) {
        BaseDto baseDto = new BaseDto();
        Customer customer = new Customer();
        customer.setId(id);
        String result = accountRepository.deleteCustomer(customer);
        baseDto.setMessage(result);
        return baseDto;
    }
    public BaseDto addCustomer(CustomerRequest customerRequest){
        Customer customer = new Customer();
        customer.setId(customerRequest.getUsername());
        customer.setPassword(customerRequest.getPassword());
        customer.setEmail(customerRequest.getEmail());
        customer.setFullName(customerRequest.getFullName());
        customer.setPhoto(customerRequest.getPhoto());
        customer.setActivated(customerRequest.getActivated());
        customer.setAdmin(customerRequest.getAdmin());
        String s = accountRepository.addCustomer(customer);
        BaseDto baseDto = new BaseDto();
        baseDto.setMessage(s);
        return baseDto;
    }
}
