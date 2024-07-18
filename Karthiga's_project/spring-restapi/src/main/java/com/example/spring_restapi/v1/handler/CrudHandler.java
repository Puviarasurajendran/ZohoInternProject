package com.example.spring_restapi.v1.handler;

import java.util.List;

import com.example.spring_restapi.v1.model.Customer;
import com.example.spring_restapi.v1.model.CustomerPOJO;
import com.example.spring_restapi.service.Response;

public abstract class CrudHandler <T>{
	
    abstract List<T> getAll();
    abstract T getById(String id);
    abstract Response save(CustomerPOJO model);
    abstract Response saveAll(List<Customer> models);
    abstract Response update(String id, T model);
    abstract Response delete(String id);
}
