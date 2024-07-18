package com.example.spring_restapi.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.spring_restapi.exception.CustomerAlreadyExistsException;
import com.example.spring_restapi.exception.MailNotFoundException;
import com.example.spring_restapi.service.CustomerDBModel;
import com.example.spring_restapi.v1.model.Customer;

@Component
public class CustomerDB {

	private DBActions db;

	@Autowired
	public CustomerDB(DBActions db) {
		this.db = db;
	}

	public List<LinkedHashMap<String, Object>> getAllCustomers() {
		List<LinkedHashMap<String, Object>> list = db.get("SELECT * FROM customer");
		return list;

	}

	public CustomerDBModel getCustomer(String cid) {
		List<LinkedHashMap<String, Object>> customers = db.get("SELECT * FROM customer WHERE custId='" + cid + "'");
		if (customers != null) {
			LinkedHashMap<String, Object> customerDetails = customers.get(0);
			return new CustomerDBModel((String) customerDetails.get("custId"), (String) customerDetails.get("fname"),
					(String) customerDetails.get("lname"), (String) customerDetails.get("mail"),
					(String) customerDetails.get("contact"));
		} else {
			return null;
		}
	}

	public String saveCustomer(CustomerDBModel c) {

		boolean result;
		try {
			result = db.execute("Insert into customer values('" + c.getCustId() + "','" + c.getFname() + "','"
					+ c.getLname() + "','" + c.getMail() + "','" + c.getContact() + "')");
			if (result) {
				return "record inserted";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Error occured";
	}

	public String saveAllCustomers(List<Customer> customers) {
		boolean result;
		try {
			result = db.executeBatch("INSERT INTO customer (custId, fname, lname, mail) VALUES (?, ?, ?, ?)",
					customers);
			if (result) {
				return "record inserted";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Error occured";
	}

	public String updateCustomer(String cid, String mail) {
		if (mail == null) {
			throw new MailNotFoundException("Field Mail Id not provided");
		}
		boolean result = db.execute("update customer set mail='" + mail + "' where custId='" + cid + "'");
		if (result) {
			return "record updated";
		}
		return "Error occured";
	}

	public String deleteCustomer(String cid) {
		boolean result = db.execute("delete from customer where custId='" + cid + "'");
		if (result) {
			return "record deleted";
		}
		return "Error occured";
	}

}
