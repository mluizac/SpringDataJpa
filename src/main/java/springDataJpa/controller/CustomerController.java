package springDataJpa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springDataJpa.model.Customer;
import springDataJpa.service.CustomerService;

import javax.validation.Valid;
import java.util.List;


//repository // model <- service <- controller

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid Customer customer){
        return customerService.save(customer);
    }

    @GetMapping
    public Iterable<Customer> getCustomersAll(){
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public Customer getId(@PathVariable(required=true) long id){
        return customerService.getId(id);
    }

    @GetMapping("/lastName")
    public List<Customer> findByLastName(@RequestParam String lastName){
        return customerService.getLastName(lastName);
    }
}
