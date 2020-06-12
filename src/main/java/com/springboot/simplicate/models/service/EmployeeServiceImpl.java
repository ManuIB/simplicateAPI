package com.springboot.simplicate.models.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.simplicate.AppConfig;
import com.springboot.simplicate.HeaderRequestInterceptor;
import com.springboot.simplicate.models.Datum;
import com.springboot.simplicate.models.Item;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private RestTemplate clienteRest;
	
	@Autowired
	private AppConfig appConfig;

	@Override
	public Item findAll() {

		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
		interceptors.add(new HeaderRequestInterceptor("Authentication-Key", appConfig.getAuthenticationkey()));
		interceptors.add(new HeaderRequestInterceptor("Authentication-Secret", appConfig.getAuthenticationsecret()));
		clienteRest.setInterceptors(interceptors);
		Item items = clienteRest.getForObject(appConfig.getApiUrl() + "/hrm/employee", Item.class);

		return items;
	}

	@Override
	public List<String> findAllIds() {

		List<String> employeesIds = new ArrayList<String>();
		Item employees = findAll();

		for (Datum datum : employees.getData()) {
			employeesIds.add(datum.getId());
		}

		return employeesIds;
	}
}
