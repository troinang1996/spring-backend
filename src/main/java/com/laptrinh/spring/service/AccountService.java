package com.laptrinh.spring.service;

import com.laptrinh.spring.dto.Response.CustomerResponse;
import com.laptrinh.spring.entity.Customer;
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
}
