package com.example.springboot.h2crud.springbootfirst.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springboot.h2crud.springbootfirst.entity.Customer;
import com.example.springboot.h2crud.springbootfirst.repository.CustomerReo;

@RestController
@RequestMapping("/api")
public class CustomerController {
	//autowire repository to use their methods
	@Autowired
	CustomerReo customerRep;
	//Saving the cust obj

	//insert

	//bind the req to the customer pojo

	@PostMapping("/customers")

	public ResponseEntity<Customer> save(@RequestBody Customer customer){
		try{
			return new ResponseEntity<>(customerRep.save(customer),HttpStatus.CREATED);
		}

		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//select *

	@GetMapping("/customers")

	public ResponseEntity<List<Customer>> getAll(){
		try {
			List<Customer> allcus = customerRep.findAll();
			if(allcus.isEmpty() || allcus.size() == 0)
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return new ResponseEntity<>(allcus, HttpStatus.OK);

		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//select where id

	@GetMapping("/customers/{id}")

	public ResponseEntity<Customer> getCus(@PathVariable Long id){
		try {
			Optional<Customer> cus = customerRep.findById(id);
			if(!cus.isPresent())
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(cus.get() ,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//update
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer( @PathVariable Long id,

			@RequestBody Customer gcus){
		try {
			Optional<Customer> cus = customerRep.findById(id);
			if(!cus.isPresent())         
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			cus.get().setName(gcus.getName());
			cus.get().setAge(gcus.getAge());
			cus.get().setLocation(gcus.getLocation());
			Customer updatedCus =customerRep.save(cus.get());
			return new ResponseEntity<>(updatedCus,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}                          
	}
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<HttpStatus> deleteCust(@PathVariable Long id){
		try {

			Optional<Customer> cus = customerRep.findById(id);
			if(cus.isPresent())          
				customerRep.delete(cus.get());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}
}

