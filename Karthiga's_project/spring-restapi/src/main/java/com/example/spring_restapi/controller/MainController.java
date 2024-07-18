package com.example.spring_restapi.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_restapi.ProxyFactory.ProxyFactoryClass;
import com.example.spring_restapi.interceptor.LoggerInterceptor;
import com.example.spring_restapi.v1.handler.CustomerHandler;
import com.example.spring_restapi.v1.model.Customer;
import com.example.spring_restapi.v1.model.CustomerPOJO;
import com.example.spring_restapi.service.Response;
import com.google.gson.Gson;

@RestController
@Validated
@RequestMapping("/api")
public class MainController {

	private final ApplicationContext context;
	private final Gson gson = new Gson();

	@Autowired
	public MainController(ApplicationContext context) {
		this.context = context;
	}

	@GetMapping("/{version}/customer")
	public List<?> getAllCustomers(@PathVariable String version) {
		CustomerHandler customerHandler = null;
		try {
			customerHandler = (CustomerHandler) ProxyFactoryClass.createProxy(context, version, "customer");
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerHandler.getAll();
	}

	@GetMapping("/{version}/customer/{custId}")
	public ResponseEntity<?> getCustomerById(@PathVariable String version, @PathVariable String custId) {
		CustomerHandler customerHandler;
		try {
			customerHandler = (CustomerHandler) ProxyFactoryClass.createProxy(context, version, "customer");
			CustomerPOJO customer = customerHandler.getById(custId);
			if (customer != null) {
				return new ResponseEntity<>(customer, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/{version}/customer")
	public ResponseEntity<?> createCustomer(@PathVariable String version, @RequestBody String jsonString) {
		CustomerHandler customerService;
		try {
			customerService = (CustomerHandler) ProxyFactoryClass.createProxy(context, version, "customer");
			CustomerPOJO customer = (CustomerPOJO) gson.fromJson(jsonString, ProxyFactoryClass.clazz);
			System.out.println("from Controller:" + customer.toString());
			Response response = customerService.save(customer);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (BeansException e) {

			e.printStackTrace();
			return new ResponseEntity<>(new Response(e.getMessage(), (StringBuilder) null), HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/{version}/customer/create")
	public ResponseEntity<?> createCustomers(@PathVariable String version, @Valid @RequestBody List<Customer> customers,
			BindingResult result) {
		if (result.hasErrors()) {
			String errorMessages = result.getAllErrors().stream().map(error -> error.getDefaultMessage())
					.collect(Collectors.joining("\n"));
			return new ResponseEntity<>(new Response(errorMessages, (StringBuilder) null), HttpStatus.BAD_REQUEST);
		} else {
			CustomerHandler customerService;
			try {
				customerService = (CustomerHandler) ProxyFactoryClass.createProxy(context, version, "customer");
				Response response = customerService.saveAll(customers);
				return new ResponseEntity<>(response, HttpStatus.CREATED);
			} catch (BeansException e) {

				e.printStackTrace();
				return new ResponseEntity<>(new Response(e.getMessage(), (StringBuilder) null), HttpStatus.NOT_FOUND);
			}

		}
	}

	@PutMapping("/{version}/customer/{custId}")
	public ResponseEntity<?> updateCustomer(@PathVariable String version, @PathVariable String custId,
			@Valid @RequestBody Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<>(new Response(result.getFieldError().getDefaultMessage(), (StringBuilder) null),
					HttpStatus.BAD_REQUEST);
		} else {

			try {
				CustomerHandler customerService = (CustomerHandler) ProxyFactoryClass.createProxy(context, version,
						"customer");
				Response response = customerService.update(custId, customer);
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(new Response(e.getMessage(), (StringBuilder) null), HttpStatus.NOT_FOUND);
			}
		}
	}

	@DeleteMapping("/{version}/customer")
	public ResponseEntity<?> deleteCustomer(@PathVariable String version, @RequestParam String custId) {

		try {
			CustomerHandler customerService = (CustomerHandler) ProxyFactoryClass.createProxy(context, version,
					"customer");
			Response response = customerService.delete(custId);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {

			e.printStackTrace();
			return new ResponseEntity<>(new Response(e.getMessage(), custId), HttpStatus.NOT_FOUND);
		}

	}

}
