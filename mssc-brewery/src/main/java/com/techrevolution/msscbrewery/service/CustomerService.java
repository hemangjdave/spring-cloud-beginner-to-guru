package com.techrevolution.msscbrewery.service;

import com.techrevolution.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    CustomerDto getCustomer(UUID uuid);

}
