package com.techrevolution.msscbrewery.service;

import com.techrevolution.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomer(UUID uuid) {
        return CustomerDto.builder()
                .uuid(uuid)
                .name("Hemang")
                .build();
    }
}
