package com.springframework.exceltodatabase.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springframework.exceltodatabase.service.CustomerService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("customers")
public class CustomerController {
    private CustomerService customerService;

    @PostMapping("/upload-customers-data")
    public ResponseEntity<?> uploadCustomersData(@RequestParam("file") MultipartFile file){
        this.customerService.saveCustomerToDatabase(file);
        return ResponseEntity.ok(Map.of("Message",
        "Customers data uploaded and saved to database successfully."));
    }
}
