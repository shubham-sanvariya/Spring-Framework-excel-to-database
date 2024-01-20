package com.springframework.exceltodatabase.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springframework.exceltodatabase.domain.Customer;
import com.springframework.exceltodatabase.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    public void saveCustomerToDatabase(MultipartFile file){
        if (ExcelUploadService.isValidExcelFile(file)) {
            try {
                List<Customer> customers = ExcelUploadService
                .getCustomersDataFromExcel(file.getInputStream());
                this.customerRepository.saveAll(customers);
            } catch (IOException e) {
                throw new IllegalArgumentException("The file is not a valid excel file");
            }
        }
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }
}
