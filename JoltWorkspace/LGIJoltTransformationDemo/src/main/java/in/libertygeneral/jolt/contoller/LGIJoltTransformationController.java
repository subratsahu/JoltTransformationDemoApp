package in.libertygeneral.jolt.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.libertygeneral.jolt.entity.Customer;
import in.libertygeneral.jolt.repository.CustomerRepository;
import in.libertygeneral.jolt.service.VendorACustomerServiceImplementation;
import in.libertygeneral.jolt.service.VendorBCustomerServiceImplementation;
import in.libertygeneral.jolt.service.VendorCCustomerServiceImplementation;

@RestController
public class LGIJoltTransformationController {

    @Autowired
    private CustomerRepository custRepository;
    
    @Autowired
    VendorACustomerServiceImplementation aCustomerServiceImplementation;
    @Autowired
    VendorBCustomerServiceImplementation bCustomerServiceImplementation;
    @Autowired
    VendorCCustomerServiceImplementation cCustomerServiceImplementation;

    @GetMapping("/allCustomers")
    public List<Customer> getAllCustomers() {
        return custRepository.findAll();
    }
    
    @GetMapping("/CreateVendorACustomer")
    @ResponseBody
    public ResponseEntity<Object> createVendorACustomer() {
    	return aCustomerServiceImplementation.createCustomer();
    }
    
    @GetMapping("/CreateVendorBCustomer")
    @ResponseBody
    public ResponseEntity<Object> createVendorBCustomer() {
    	return bCustomerServiceImplementation.createCustomer();    
    }
    @GetMapping("/CreateVendorCCustomer")
    @ResponseBody
    public ResponseEntity<Object> createVendorCCustomer() {
    	return cCustomerServiceImplementation.createCustomer();        
    }
}
