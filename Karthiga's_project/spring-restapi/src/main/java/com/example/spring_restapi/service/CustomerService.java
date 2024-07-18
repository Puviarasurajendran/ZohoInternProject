package com.example.spring_restapi.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_restapi.dao.CustomerDB;



@Service("customerService")
public class CustomerService implements CrudService<CustomerDBModel> {

	private CustomerDB dao;

	@Autowired
	public CustomerService(CustomerDB dao) {

		this.dao = dao;
	}

	@Override
	public List<CustomerDBModel> getAll() {
		List<LinkedHashMap<String, Object>> list = dao.getAllCustomers();
		List<CustomerDBModel> customers = new ArrayList<>();
		for (LinkedHashMap<String, Object> l : list) {
			customers.add(new CustomerDBModel((String) l.get("custId"), (String) l.get("fname"), (String) l.get("lname"),
					(String) l.get("mail"),(String)l.get("contact")));
		}
		return customers;

	}

	@Override
	public CustomerDBModel getById(String id) {
		return dao.getCustomer(id);
	}

	@Override
	public String save(CustomerDBModel model) {

		return dao.saveCustomer(model);
	}

	@Override
	public String saveAll(List<CustomerDBModel> models) {

		return null;
	}

	@Override
	public String update(String id, CustomerDBModel model) {
		
		return dao.updateCustomer(id, model.getMail());
	}

	@Override
	public String delete(String id) {

		return dao.deleteCustomer(id);
	}

}
