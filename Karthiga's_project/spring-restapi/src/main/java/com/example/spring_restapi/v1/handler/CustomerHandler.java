package com.example.spring_restapi.v1.handler;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.spring_restapi.dao.CustomerDB;
import com.example.spring_restapi.exception.CustomizedException;
import com.example.spring_restapi.v1.model.Customer;
import com.example.spring_restapi.v1.model.CustomerPOJO;
import com.example.spring_restapi.service.CustomerService;
import com.example.spring_restapi.service.CustomerDBModel;
import com.example.spring_restapi.service.Response;

@Component("customerHandlerV1")
public class CustomerHandler extends CrudHandler<CustomerPOJO> {

	protected CustomerDB dao;
	protected CustomerService customerService;

	@Autowired
	private Validator validator;

	public Validator getValidator() {
		return validator;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@Autowired
	public CustomerHandler(CustomerDB dao, CustomerService customerService) {
		this.dao = dao;
		this.customerService = customerService;
	}

	@Override
	public List<CustomerPOJO> getAll() {
		System.out.println("from version1");
		List<CustomerDBModel> list = customerService.getAll();
		List<CustomerPOJO> customers = new ArrayList<>();
		for (CustomerDBModel l : list) {
			customers.add(convertToHandlerPOJO(l));
		}
		return customers;
	}

	@Override
	public CustomerPOJO getById(String id) {
		return convertToHandlerPOJO(customerService.getById(id));
	}

	@Override
	public Response save(@Valid CustomerPOJO model) {
		System.out.println("from service:" + model.toString());
		if (validatePojo(model)) {
			String result = customerService.save(convertToDbPOJO((Customer) model));
			return new Response(result, ((Customer) model).getCustId());
		} else {
			return new Response("error in validation", ((Customer) model).getCustId());
		}

	}

	@Override
	public Response saveAll(List<Customer> customers) {
		String result = dao.saveAllCustomers(customers);
		return new Response(result, (String) null);
	}

	@Override
	public Response update(String id, CustomerPOJO model) {
		String result = customerService.update(id, convertToDbPOJO((Customer) model));
		return new Response(result, ((Customer) model).getCustId());
	}

	@Override
	public Response delete(String id) {
		String result = customerService.delete(id);
		return new Response(result, id);
	}

	public boolean validatePojo(CustomerPOJO c) throws CustomizedException {

		Errors errors = new BeanPropertyBindingResult(c, "customerHandlerV1");
		ValidationUtils.invokeValidator(getValidator(), c, errors);

		if (errors.hasErrors()) {

			String errorMessages = errors.getAllErrors().stream().map(error -> error.getDefaultMessage())
					.collect(Collectors.joining("\n"));
			throw new CustomizedException(errorMessages);
		}

		return true;
	}

	private CustomerPOJO convertToHandlerPOJO(CustomerDBModel model) {
		return new Customer(model.getCustId(), model.getFname(), model.getLname(), model.getMail());
	}

	private CustomerDBModel convertToDbPOJO(Customer model) {
		CustomerDBModel customer = new CustomerDBModel();
		customer.setCustId(model.getCustId());
		customer.setFname(model.getFname());
		customer.setLname(model.getLname());
		customer.setMail(model.getMail());
		return customer;
	}

}
