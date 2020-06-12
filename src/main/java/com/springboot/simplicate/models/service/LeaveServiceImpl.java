package com.springboot.simplicate.models.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.simplicate.AppConfig;
import com.springboot.simplicate.HeaderRequestInterceptor;
import com.springboot.simplicate.models.Item;

@Service
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	private RestTemplate clienteRest;

	@Autowired
	private AppConfig appConfig;

	@Override
	public Item findAllLeaveBalance() {

		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
		interceptors.add(new HeaderRequestInterceptor("Authentication-Key", appConfig.getAuthenticationkey()));
		interceptors.add(new HeaderRequestInterceptor("Authentication-Secret", appConfig.getAuthenticationsecret()));
		clienteRest.setInterceptors(interceptors);
		Item items = clienteRest.getForObject(appConfig.getApiUrl() + "/hrm/leavebalance", Item.class);

		return items;
	}

	@Override
	public Item findLeavePerEmployee(String employeeId) {

		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
		interceptors.add(new HeaderRequestInterceptor("Authentication-Key", appConfig.getAuthenticationkey()));
		interceptors.add(new HeaderRequestInterceptor("Authentication-Secret", appConfig.getAuthenticationsecret()));
		clienteRest.setInterceptors(interceptors);

		Map<String, String> vars = new HashMap<>();
		vars.put("id", employeeId);

		Item items = clienteRest.getForObject(appConfig.getApiUrl() + "/hrm/leave?q[employee.id]={id}", Item.class,
				vars);

		return items;
	}
}
