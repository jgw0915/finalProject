package com.example.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.*;

import java.util.*;

@CrossOrigin("*")
@Controller
@RequestMapping(path="/")
public class customerController {
    @Autowired
    private customerRepository customerRepository;
    @Operation(summary = "新增用戶")
    @PostMapping(path="/customer")
    public @ResponseBody
    String addNewUser (@RequestBody Map<String,String> m) {
        customerRepository.save(new customer(m.get("firstName"),m.get("lastName")));
        return "Saved";
    }
    @Operation(summary = "尋找所有用戶")
    @GetMapping (path="/customer")
    public @ResponseBody Iterable<customer> getAllUsers() {
        return customerRepository.findAll();
    }

    @Operation(summary = "尋找特定用戶(By Id)")
    @GetMapping(path="/customer/{id}")
    public @ResponseBody
    Iterable<customer> getCustomer(@PathVariable long id) throws customerNotfoundException {
        return (Iterable<customer>)Collections.singleton(customerRepository.findById(id));
    }
    @Operation(summary = "更新資料")
    @PutMapping(path="/customer/{id}")
    public @ResponseBody
    customer updateCustomer( @RequestBody customer c) {
        customerRepository.save(c);
        return c;
    }
    @Operation(summary = "刪除用戶")
    @DeleteMapping("/customer/{id}")
    public @ResponseBody
    String deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
        return "Delete";
    }



}
