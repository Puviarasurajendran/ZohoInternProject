package com.example.spring_restapi.service;

import java.util.List;


public interface CrudService <T>{

     List<T> getAll();
     T getById(String id);
     String save(T model);
     String saveAll(List<T> models);
     String update(String id, T model);
     String delete(String id);
}
