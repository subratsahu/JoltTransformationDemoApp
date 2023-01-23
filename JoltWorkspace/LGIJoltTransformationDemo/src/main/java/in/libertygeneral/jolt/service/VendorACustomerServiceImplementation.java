package in.libertygeneral.jolt.service;


import in.libertygeneral.jolt.entity.Customer;
import in.libertygeneral.jolt.handler.ResponseHandler;
import in.libertygeneral.jolt.repository.CustomerRepository;
import in.libertygeneral.jolt.util.JoltUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service("VendorACustomerService")
public class VendorACustomerServiceImplementation implements CustomerService{
    
    @Autowired
    CustomerRepository custRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    
    
    @Override
    public ResponseEntity<Object> createCustomer() {
    	System.out.println("inside A createCustomer");
    	ResponseEntity<Map<String, Object>> responseEntity = restTemplate.exchange("http://localhost:3000/vendorAcust", HttpMethod.GET, null, new ParameterizedTypeReference<Map<String, Object>>() {
        });
        Map<String, Object> response = responseEntity.getBody();
        Customer customer = JoltUtil.getEntity("/vendorASpec.json", Customer.class, response);
        custRepository.save(customer);
        
        return ResponseHandler.generateResponse("Successfully created vendor A data!", HttpStatus.OK, customer);
   }
}
