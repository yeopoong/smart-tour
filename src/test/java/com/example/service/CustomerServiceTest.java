package com.example.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.App;
import com.example.domain.Customer;
import com.example.repository.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class CustomerServiceTest {

    @Autowired
    CustomerRepository customerRepository;
    
    @Test
    public void testGetCustomers() {
    	List<Customer> customers = customerRepository.findAll();
    	
    	assertThat(customers.size(), is(4));
    }
}
