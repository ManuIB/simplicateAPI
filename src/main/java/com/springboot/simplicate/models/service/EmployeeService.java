package com.springboot.simplicate.models.service;

import java.util.List;

import com.springboot.simplicate.models.Item;

public interface EmployeeService {

	public Item findAll();
	
	public List<String> findAllIds();
}
