package com.example.spring_restapi.v2.handler;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.example.spring_restapi.dao.CustomerDB;
import com.example.spring_restapi.exception.CustomizedException;
import com.example.spring_restapi.v1.model.CustomerPOJO;
import com.example.spring_restapi.service.CustomerService;
import com.example.spring_restapi.service.Response;
import com.example.spring_restapi.service.CustomerDBModel;
import com.example.spring_restapi.v2.model.Customer;
import com.example.spring_restapi.v2.model.Customer.FullName;

@Service("customerHandlerV2")
public class CustomerHandler extends com.example.spring_restapi.v1.handler.CustomerHandler {


	@Autowired
	public CustomerHandler(CustomerDB dao,CustomerService customerService) {
		super(dao,customerService);
	
	}

	@Override
	public List<CustomerPOJO> getAll() {
		System.out.println("from version 2");
		List<CustomerDBModel> list=customerService.getAll();
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
		if(validatePojo(model))
		{
			String result=customerService.save(convertToDbPOJO((Customer)model));
		return new Response(result, ((Customer) model).getCustId());
		}
		else
		{
			return new Response("error in validation",((Customer)model).getCustId());
		}
	}
	public boolean validatePojo(CustomerPOJO c) throws CustomizedException {
 
            Errors errors = new BeanPropertyBindingResult(c, "customerHandlerV2");
            ValidationUtils.invokeValidator(getValidator(), c, errors);

            if (errors.hasErrors()) {
                String errorMessages = errors.getAllErrors().stream()
                                            .map(error -> error.getDefaultMessage())
                                            .collect(Collectors.joining("\n"));
                throw new CustomizedException(errorMessages);
            }
             
       
       
        return true;
    }
	private CustomerPOJO convertToHandlerPOJO(CustomerDBModel model) {
		return new Customer(model.getCustId(), new FullName(model.getFname(), model.getLname()), model.getMail(),model.getContact());
	}

	private CustomerDBModel convertToDbPOJO(Customer model) {
		CustomerDBModel customer = new CustomerDBModel();
		customer.setCustId(model.getCustId());
		customer.setFname(model.getFullName().getFirstname());
		customer.setLname(model.getFullName().getLastname());
		customer.setMail(model.getMail());
		return customer;
	}

}
